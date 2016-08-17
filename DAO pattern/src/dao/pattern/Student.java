/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pattern;

/**
 *
 * @author kmhasan
 */
public class Student {
    private int id;
    private String name;
    private double cgpa;
    private String message;
    
    public Student() {
    }

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
        if(cgpa == 0){
            this.message = "Sorry! You are Failed";
        }
        else if(cgpa > 0 && cgpa <= 4.00){
            this.message = "Congratulations. You are Passed";
        }
        else{
            this.message = "This is not a valid grade";
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getMessage() {
        return message;
    }
    
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", cgpa=" + cgpa + '}';
    }
}
