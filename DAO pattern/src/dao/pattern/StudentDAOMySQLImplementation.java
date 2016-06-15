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
    public StudentDAOMySQLImplementation() {
    }

    @Override
    public void addStudent(Student student) {
        try {
            PreparedStatement addStudentStatement = MySQLConnectionSingleton.getAddStudentStatement();
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
            PreparedStatement listStudentsStatement = MySQLConnectionSingleton.getListStudentsStatement();
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
