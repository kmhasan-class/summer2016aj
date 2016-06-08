/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pattern;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField cgpaField;
    private StudentDAO implementation;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        implementation = new StudentDAOMySQLImplementation();
        
        List<Student> students = implementation.getAllStudents();
//        for (Student student: students)
//            System.out.println(student);
//        students.forEach(student -> System.out.println(student));
        students.forEach(System.out::println);
    }

    @FXML
    private void handleSubmitAction(ActionEvent event) {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        double cgpa = Double.parseDouble(cgpaField.getText());

        Student student = new Student(id, name, cgpa);
        implementation.addStudent(student);
        
        /*
         String DB_URL = "jdbc:mysql://172.17.0.134/studentdb";
         String DB_USER = "summer2016aj";
         String DB_PASS = "java";
         try {
         Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
         System.out.println("Connected to the Database");
            
         int id = Integer.parseInt(idField.getText());
         String name = nameField.getText();
         double cgpa = Double.parseDouble(cgpaField.getText());
            
         Statement statement = connection.createStatement();
            
         String query = "INSERT INTO student VALUES(" + id + ", '" + name + "', "+ cgpa + ")";
            
         statement.executeUpdate(query);
         } catch (SQLException ex) {
         Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
         */
    }

}
