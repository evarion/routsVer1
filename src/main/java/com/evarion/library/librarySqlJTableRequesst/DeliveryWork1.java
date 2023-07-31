package com.evarion.library.librarySqlJTableRequesst;


import com.evarion.dataBaseConfig.ConfigConnectionSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeliveryWork1 extends JFrame {
    static ConfigConnectionSQL configConnectionSQL = new ConfigConnectionSQL();

    public DeliveryWork1() {

        super("TEST JTABLE");

        setLocationRelativeTo(null);

        setSize(600, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    // create a Function to get the connection
    static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(configConnectionSQL.getJdbcUrl(), configConnectionSQL.getLogin(),
                    configConnectionSQL.getPassword());
        } catch (SQLException ex) {
            //Logger.getLogger(DeliveryWork1.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }

    // create a function to fill the an arraylist from database
    static ArrayList<DeliveryData1> getDeliveries() {

        ArrayList<DeliveryData1> deliveries = new ArrayList<DeliveryData1>();

        Connection con = getConnection();

        Statement st;

        ResultSet rs;

        DeliveryData1 u;

        try {

            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM delivery");

            while (rs.next()) {

                u = new DeliveryData1(
                        rs.getString("id"),
                        rs.getString("container"),
                        rs.getString("line_id"),
                        rs.getString("vessel_id"),
                        rs.getString("port_id"),
                        rs.getString("cargo_id"),
                        rs.getString("exportimport_id"),
                        rs.getString("country_id"),
                        rs.getString("status_id"),
                        rs.getString("typeconteiner_id"),
                        rs.getString("sizeconteiner_id")
                );

                deliveries.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DeliveryWork1.class.getName()).log(Level.SEVERE, null, ex);
        }

        return deliveries;
    }


    public static void main(String[] args) {

 /*
   now we are gonna create and populate a jtable from the arraylist who is populated from mysql database
*/

        JTable table = new JTable();

        DefaultTableModel model = new DefaultTableModel();

        Object[] columnsName = new Object[11];

        columnsName[0] = "id";
        columnsName[1] = "container";
        columnsName[2] = "line_id";
        columnsName[3] = "vessel_id";
        columnsName[4] = "port_id";
        columnsName[5] = "cargo_id";
        columnsName[6] = "exportimport_id";
        columnsName[7] = "country_id";
        columnsName[8] = "status_id";
        columnsName[9] = "typeconteiner_id";
        columnsName[10] = "sizeconteiner_id";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[20];

        for (int i = 0; i < getDeliveries().size();i++) { //getDeliveries().size()
            rowData[0] = getDeliveries().get(i).getId();
            rowData[1] = getDeliveries().get(i).getContainer();
            rowData[2] = getDeliveries().get(i).getLine_id();
            rowData[3] = getDeliveries().get(i).getVessel_id();
            rowData[4] = getDeliveries().get(i).getPort_id();
            rowData[5] = getDeliveries().get(i).getCargo_id();
            rowData[6] = getDeliveries().get(i).getExportimport_id();
            rowData[7] = getDeliveries().get(i).getCountry_id();
         //   rowData[8] = getDeliveries().get(i).getStatus_id();
            //  rowData[9] = getDeliveries().get(i).getTypeconteiner_id();
            // rowData[10] = getDeliveries().get(i).getSizeconteiner_id();
            ;
            model.addRow(rowData);

        }


        table.setModel(model);

        //System.out.println(getDeliveries().size());

        DeliveryWork1 window = new DeliveryWork1();

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        JScrollPane pane = new JScrollPane(table);

        panel.add(pane, BorderLayout.CENTER);

        window.setContentPane(panel);
    }
}

