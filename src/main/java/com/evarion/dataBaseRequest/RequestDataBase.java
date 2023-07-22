package com.evarion.dataBaseRequest;

import com.evarion.dataBaseConfig.ConfigConnectionSQL;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class RequestDataBase extends AbstractTableModel {
    Connection connection;
    ArrayList<String[]> dataArrayList;
    ConfigConnectionSQL configConnectionSQL = new ConfigConnectionSQL();
    int columnCount = 11;


    public RequestDataBase() {
        dataArrayList = new ArrayList<String[]>();
        for (int i = 0; i < dataArrayList.size(); i++) {
            dataArrayList.add(new String[getColumnCount()]);
        }
    }

    public void startConnection() {
        connection = null;
        try {
            connection = DriverManager.getConnection(configConnectionSQL.getJdbcUrl(), configConnectionSQL.getLogin(),
                    configConnectionSQL.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create a addData connection", e);
        }
    }


    public ResultSet resultSetQuery(String query) {

        startConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sqlQuery(String query) {

        startConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }





    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rows = dataArrayList.get(rowIndex);

        return rows[columnIndex];
    }

    public void addData(String[] row) {
        String[] rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);

    }

    public void addData() {
        startConnection();
        ResultSet result = resultSetQuery("SELECT * FROM delivery");



        try {
            while (result.next()) {
                String[] row = {
                        result.getString("id"),
                        result.getString("container"),
                        result.getString("line_id"),
                        result.getString("vessel_id"),
                        result.getString("port_id"),
                        result.getString("cargo_id"),
                        result.getString("exportimport_id"),
                        result.getString("country_id"),
                        result.getString("status_id"),
                        result.getString("typeconteiner_id"),
                        result.getString("sizeconteiner_id")};
                addData(row);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //https://www.youtube.com/watch?v=MSccUn5gS3M
}
