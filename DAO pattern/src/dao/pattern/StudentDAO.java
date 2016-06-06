/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pattern;

import java.util.List;

/**
 *
 * @author kmhasan
 */
public interface StudentDAO {
    public List<Student> getAllStudents();
    //public void deleteStudent(Student student);
    //public void updateStudent(Student student);
    public void addStudent(Student student);
}
