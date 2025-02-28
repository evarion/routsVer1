package com.evarion.schedule;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ShipScheduleApp extends JFrame {

    private JTextField shipNameField, arrivalTimeField;
    private JButton addButton, loadButton;
    private JTable scheduleTable;
    private DefaultTableModel tableModel;

    // Database credentials
    private final String DB_URL = "jdbc:postgresql://localhost:5432/ship_schedule";
    private final String USER = "root";
    private final String PASS = "24test1986";

    public ShipScheduleApp() {
        // Initialize GUI components
        setTitle("Ship Schedule Application");
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Ship Name:"));
        shipNameField = new JTextField();
        inputPanel.add(shipNameField);

        inputPanel.add(new JLabel("Arrival Time:"));
        arrivalTimeField = new JTextField();
        inputPanel.add(arrivalTimeField);

        addButton = new JButton("Add Schedule");
        loadButton = new JButton("Load Schedule");

        inputPanel.add(addButton);
        inputPanel.add(loadButton);

        add(inputPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Ship Name", "Arrival Time"}, 0);
        scheduleTable = new JTable(tableModel);
        add(new JScrollPane(scheduleTable), BorderLayout.CENTER);

        // Add button listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSchedule();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSchedule();
            }
        });

        // Initialize the database
        initializeDatabase();

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/", USER, PASS);
             Statement stmt = conn.createStatement()) {

            // Проверка существования базы данных
            ResultSet rs = conn.getMetaData().getCatalogs();
            boolean dbExists = false;
            while (rs.next()) {
                if ("ship_schedule".equals(rs.getString(1))) {
                    dbExists = true;
                    break;
                }
            }

            // Создание базы данных, если она не существует
            if (!dbExists) {
                stmt.executeUpdate("CREATE DATABASE ship_schedule");
                System.out.println("База данных ship_schedule успешно создана.");
            } else {
                System.out.println("База данных ship_schedule уже существует.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Подключение к базе данных ship_schedule и создание таблицы
        try (Connection dbConn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement dbStmt = dbConn.createStatement()) {

            // Создаем таблицу schedule, если она не существует
            dbStmt.executeUpdate("CREATE TABLE IF NOT EXISTS schedule ("
                    + "id SERIAL PRIMARY KEY, "
                    + "ship_name VARCHAR(255) NOT NULL, "
                    + "arrival_time VARCHAR(255) NOT NULL)");
            System.out.println("Таблица schedule успешно создана или уже существует.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addSchedule() {
        String shipName = shipNameField.getText();
        String arrivalTime = arrivalTimeField.getText();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO schedule (ship_name, arrival_time) VALUES (?, ?)")) {
            pstmt.setString(1, shipName);
            pstmt.setString(2, arrivalTime);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Schedule added successfully");
            shipNameField.setText("");
            arrivalTimeField.setText("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadSchedule() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM schedule")) {
            tableModel.setRowCount(0); // Clear table
            while (rs.next()) {
                int id = rs.getInt("id");
                String shipName = rs.getString("ship_name");
                String arrivalTime = rs.getString("arrival_time");
                tableModel.addRow(new Object[]{id, shipName, arrivalTime});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShipScheduleApp().setVisible(true);
            }
        });

}}

