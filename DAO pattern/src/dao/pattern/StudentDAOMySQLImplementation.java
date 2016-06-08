/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class StudentDAOMySQLImplementation implements StudentDAO {
    private Connection connection;
    private PreparedStatement listStudentsStatement;
    private PreparedStatement addStudentStatement;
    private Map<String, String> queries;
    
    public StudentDAOMySQLImplementation() {
        String DB_URL = "jdbc:mysql://172.17.0.134/studentdb";
        String DB_USER = "summer2016aj";
        String DB_PASS = "java";
    
        queries = new QueryReader().getQueries();
        
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            listStudentsStatement = connection.prepareStatement(queries.get("LIST_STUDENTS"));
            addStudentStatement = connection.prepareStatement(queries.get("ADD_STUDENT"));
            System.out.println("Connected to the Database");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOMySQLImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addStudent(Student student) {
        try {
            addStudentStatement.setInt(1, student.getId());
            addStudentStatement.setString(2, student.getName());
            addStudentStatement.setDouble(3, student.getCgpa());
            addStudentStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        
        try {
            ResultSet resultSet = listStudentsStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double cgpa = resultSet.getDouble("cgpa");
                
                Student student = new Student(id, name, cgpa);
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOMySQLImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return students;
    }
    
}
