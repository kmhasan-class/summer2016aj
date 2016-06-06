/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda.expressions;

/**
 *
 * @author kmhasan
 */
public class Student implements Comparable {

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
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

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", cgpa=" + cgpa + '}';
    }

    @Override
    public int compareTo(Object o) {
        Student a = this;
        Student b = (Student) o;
        return a.name.compareTo(b.name);
/*
        double subtraction = a.cgpa - b.cgpa;
        if (subtraction < 0)
            return -1;
        else if (subtraction > 0)
            return +1;
        else return 0;
        */
    }
}
