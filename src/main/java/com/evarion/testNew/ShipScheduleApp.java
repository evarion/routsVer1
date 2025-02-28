package com.evarion.testNew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


/*
CREATE DATABASE ship_schedule;

\c ship_schedule;

CREATE TABLE ships (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    departure_time TIMESTAMP NOT NULL,
    arrival_time TIMESTAMP NOT NULL,
    origin VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL
);



 */

public class ShipScheduleApp extends JFrame {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ship_schedule";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "24test1986";

    private JTextField nameField, departureField, arrivalField, originField, destinationField;
    private JTextArea displayArea;
    private Connection connection;

    public ShipScheduleApp() {
        setTitle("Ship Schedule Management");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Создание GUI компонентов
        JPanel panel = new JPanel(new GridLayout(7, 2));
        nameField = new JTextField();
        departureField = new JTextField();
        arrivalField = new JTextField();
        originField = new JTextField();
        destinationField = new JTextField();
        displayArea = new JTextArea();

        panel.add(new JLabel("Ship Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Departure Time:"));
        panel.add(departureField);
        panel.add(new JLabel("Arrival Time:"));
        panel.add(arrivalField);
        panel.add(new JLabel("Origin:"));
        panel.add(originField);
        panel.add(new JLabel("Destination:"));
        panel.add(destinationField);

        JButton addButton = new JButton("Add Ship");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShipScheduleApp.this.addShip();
            }
        });
        JButton updateButton = new JButton("Update Ship");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShipScheduleApp.this.updateShip();
            }
        });
        JButton deleteButton = new JButton("Delete Ship");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShipScheduleApp.this.deleteShip();
            }
        });
        JButton viewButton = new JButton("View All Ships");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShipScheduleApp.this.viewShips();
            }
        });

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(viewButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            displayArea.append("Connected to the database.\n");
        } catch (SQLException e) {
            displayArea.append("Failed to connect to the database.\n");
            e.printStackTrace();
        }
    }

    private void addShip() {
        String name = nameField.getText();
        String departure = departureField.getText();
        String arrival = arrivalField.getText();
        String origin = originField.getText();
        String destination = destinationField.getText();

        String query = "INSERT INTO ships (name, departure_time, arrival_time, origin, destination) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setTimestamp(2, Timestamp.valueOf(departure));
            stmt.setTimestamp(3, Timestamp.valueOf(arrival));
            stmt.setString(4, origin);
            stmt.setString(5, destination);
            stmt.executeUpdate();
            displayArea.append("Ship added successfully.\n");
        } catch (SQLException e) {
            displayArea.append("Error adding ship.\n");
            e.printStackTrace();
        }
    }

    private void updateShip() {
        // Here you should implement update functionality using a similar structure to addShip().
        // You need to get the ship ID that you want to update and modify its details.
    }

    private void deleteShip() {
        // Here you should implement delete functionality.
        // You need to get the ship ID from the user and delete it from the database.
    }

    private void viewShips() {
        String query = "SELECT * FROM ships";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            displayArea.setText("");
            while (rs.next()) {
                displayArea.append("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Departure: " + rs.getTimestamp("departure_time") +
                        ", Arrival: " + rs.getTimestamp("arrival_time") +
                        ", Origin: " + rs.getString("origin") +
                        ", Destination: " + rs.getString("destination") + "\n");
            }
        } catch (SQLException e) {
            displayArea.append("Error retrieving ship data.\n");
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
    }
}
