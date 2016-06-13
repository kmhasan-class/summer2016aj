/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * POJO (Plain Old Java Object) model class
 *
 * @author kmhasan
 */
@Entity
public class Student {

    @Id
    private int id;
    private String name;
    @OneToMany
    private List<Course> registeredCourses;
    
    public Student() {
        registeredCourses = new ArrayList<>();
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void addCourse(Course course) {
        registeredCourses.add(course);
    }
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", registeredCourses=" + registeredCourses + '}';
    }


}
