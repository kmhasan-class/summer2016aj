/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pattern;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class StudentDAOFileImplementation implements StudentDAO {

    @Override
    public void addStudent(Student student) {
        try {
            RandomAccessFile output = new RandomAccessFile("student.txt", "rw");
            output.seek(output.length());
            String message = student.getId() + ";" + student.getName() + ";" + student.getCgpa();
            output.writeBytes(message + "\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentDAOFileImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentDAOFileImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            RandomAccessFile input = new RandomAccessFile("student.txt", "r");
            String line;
            
            while ((line = input.readLine()) != null) {
                if (line.length() == 0)
                    continue;
                String tokens[] = line.split("\\;");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double cgpa = Double.parseDouble(tokens[2]);
                
                Student student = new Student(id, name, cgpa);
                students.add(student);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentDAOFileImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentDAOFileImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
}
