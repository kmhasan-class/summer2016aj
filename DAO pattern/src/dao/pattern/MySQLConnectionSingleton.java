/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class MySQLConnectionSingleton {
    private static MySQLConnectionSingleton instance
            = new MySQLConnectionSingleton();
    private static PreparedStatement listStudentsStatement;
    private static PreparedStatement addStudentStatement;
    private static Map<String, String> queries;

    public static PreparedStatement getListStudentsStatement() {
        return listStudentsStatement;
    }

    public static PreparedStatement getAddStudentStatement() {
        return addStudentStatement;
    }
    
    private MySQLConnectionSingleton() {
        String DB_URL = "jdbc:mysql://172.17.0.134/studentdb";
        String DB_USER = "summer2016aj";
        String DB_PASS = "java";
    
        queries = new QueryReader().getQueries();
        
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            listStudentsStatement = connection.prepareStatement(queries.get("LIST_STUDENTS"));
            addStudentStatement = connection.prepareStatement(queries.get("ADD_STUDENT"));
            System.out.println("Connected to the Database");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOMySQLImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

}
