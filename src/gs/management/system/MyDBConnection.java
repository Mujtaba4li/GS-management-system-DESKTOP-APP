/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author MUJTABA R0Y
 */
public class MyDBConnection {
    
    public Connection myconnection;
    
    

    public MyDBConnection() {

    }

    public void init() {
        try {
            myconnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gs_store?serverTimezone=UTC","root","");

        } catch (Exception e) {
            System.out.println("Exception :" + e.getMessage());
            System.out.println(e);
            System.out.println("+++++++++++++++++++++++++");
        }
    }

    public Connection getMyConnection() {
        return myconnection;
    }

    public String insertRecord(String query) {
        try {
            Statement stmt = myconnection.createStatement();
            int rows = stmt.executeUpdate(query);
            return "Query executed successfully" + rows;

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateRecord(String query) {
        try {
            Statement stmt = myconnection.createStatement();
            int rows = stmt.executeUpdate(query);
            return "record Updated with effectoed rows" + rows;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public ResultSet getRecord(String query) {
        try {
            Statement stmt = myconnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;

        } catch (Exception e) {
            return null;
        }
    }

    public int deleteRecord(String query) {
        try {
            Statement stmt = myconnection.createStatement();
            int row = stmt.executeUpdate(query);
            return row;

        } catch (Exception ex) {
            return 0;
        }
    }

    public void close() {
        if (myconnection != null) {
            try {
                myconnection.close();
            } catch (Exception e) {
            }
        }
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}