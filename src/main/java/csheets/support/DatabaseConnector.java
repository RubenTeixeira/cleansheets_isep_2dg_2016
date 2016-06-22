/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.support;

import csheets.core.Cell;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ab
 */
public class DatabaseConnector {

    private static DatabaseConnector instance = null;
    private static Connection v_conn;
    private static Statement v_stmt;
    private static ResultSet v_rs;
    private static String v_str;

    private DatabaseConnector() {
    }

    /**
     * Method to aquire the unique instance of DatabaseConnector.
     *
     * @return Instance of DatabaseConnector
     */
    public static DatabaseConnector getInstance() {
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }

    public boolean doesTableExist(String tableName) {
        if (!isConnected()) {
            return false;
        }
        try {
            v_str = "Show tables";
            executeQuery();
            while (v_rs.next()) {
                System.out.println(v_rs.getString(1));
                if (v_rs.getString(1).equalsIgnoreCase(tableName)) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            System.err.print("Error obtaining table data: " + ex.getMessage());
            return false;
        }
        return false;
    }

    public boolean dropTable(String tableName) throws SQLException {
        v_str = "Drop table " + tableName;
        execute();
        return true;
    }

    public boolean createTable(String tableName, String[] headers) throws SQLException {
        if(doesTableExist(tableName)){
            dropTable(tableName);
        }
        v_str = "CREATE TABLE PUBLIC." + tableName + " (";
        for (int i = 0; i < headers.length; i++) {
            v_str += headers[i] + " VARCHAR(50), ";
        }
        v_str += "PRIMARY KEY (" + headers[0] + "))";
        execute();
        return true;
    }

    public boolean saveData(String tableName, String[][] content) throws SQLException {
        //Add verification to check if table columns is the same has content[0] length
        for (int i = 0; i < content.length; i++) {
            v_str = "INSERT INTO " + tableName
                    + " VALUES (";

            for (int j = 0; j < content[i].length; j++) {
                v_str += "'" + content[i][j] + "', ";
            }
            v_str += ")";
            if (execute()) {
                return false;
            }
        }
        return true;
    }

    public ResultSet getTableData(String tableName) throws SQLException {
        v_str = "Select * from " + tableName;
        executeQuery();
        return v_rs;
    }

    /**
     * Executes an SQL query with the use of executeQuery of Statement.
     *
     * @return ResultSet result of the query
     * @throws SQLException
     * @see Statement#executeQuery(String)
     */
    public ResultSet executeQuery() throws SQLException {
        if (isConnected()) {
            sqlConnect();
            if (v_stmt != null) {
                v_rs = v_stmt.executeQuery(v_str);
            }
        }
        return v_rs;
    }

    /**
     * Executes an SQL query with the use of executeQuery of Statement.
     *
     * @return ResultSet result of the query
     * @throws SQLException
     * @see Statement#executeQuery(String)
     */
    public boolean execute() throws SQLException {
        if (isConnected()) {
            sqlConnect();
            if (v_stmt != null) {
                return v_stmt.execute(v_str);

            }
        }
        return false;
    }

    public boolean registerDriver(String driverName) {
        try {
            Class.forName(driverName);
            return true;
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: " + e.getMessage());
            return false;
        }
    }

    public boolean setConnection(String p_driver, String p_url, String p_user, String p_pass) {
        v_conn = null;
        boolean valid = false;
        boolean v_driver = registerDriver(p_driver);
        if (v_driver) {
            try {
                v_conn = DriverManager.getConnection(p_url, p_user, p_pass);
            } catch (Exception e) {
                System.err.print("DriverManager.getConnection: " + e.getMessage());
                return false;
            }
        } else {
            System.err.print("Driver not registered: " + p_driver);
            return false;
        }
        try {
            valid = v_conn.isValid(3);
        } catch (SQLException ex) {
            System.err.print("Connection not valid: " + ex.getMessage());
        }
        return valid;
    }

    public void sqlConnect() {
        if (v_conn != null) {
            try {
                v_stmt = v_conn.createStatement();
            } catch (Exception e) {
                System.err.print("sqlConnect: " + e.getMessage());
            }
        }
    }

    /**
     * Checks to see if the application is connected to the Data Base.
     *
     * @return Returns True if the connection is established and false otherwise
     */
    public boolean isConnected() {
        return v_conn != null;
    }

}
