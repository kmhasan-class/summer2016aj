/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class StudentDAOMySQLImplementation implements StudentDAO {

    @Override
    public void addStudent(Student student) {
        String DB_URL = "jdbc:mysql://172.17.0.134/studentdb";
        String DB_USER = "summer2016aj";
        String DB_PASS = "java";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Connected to the Database");

            Statement statement = connection.createStatement();
            
            String query = "INSERT INTO student VALUES(" + student.getId() + ", '" + student.getName() + "', "+ student.getCgpa() + ")";
            
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @Override
    public List<Student> getAllStudents() {
        // ADD YOUR CODE HERE AND THEN REMOVE THE FOLLOWING LINE
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
