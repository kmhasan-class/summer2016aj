/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda.expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author kmhasan
 */
public class LambdaExpressions {

    public LambdaExpressions() {
        ArrayList<Student> students;
        students = new ArrayList<>();

        students.add(new Student(5, "Abul", 3.5));
        students.add(new Student(1, "Kabul", 2.25));
        students.add(new Student(7, "Babul", 4.0));
        students.add(new Student(4, "Putul", 3.53));

        System.out.println("Before sorting");
        for (Student student : students) {
            System.out.println(student);
        }

        //Collections.sort(students, new IDComparator());

        /*
        // Anonymous Class
        Collections.sort(students, new Comparator() {
            
            @Override
            public int compare(Object o1, Object o2) {
                Student a = (Student) o1;
                Student b = (Student) o2;
                double value = a.getCgpa() - b.getCgpa();
                if (value < 0)
                    return -1;
                else if (value > 0)
                    return +1;
                else return 0;
            }
        });
        */
        
        //Collections.sort(students, (a, b) -> a.getName().compareTo(b.getName()));
        Collections.sort(students, (a, b) -> a.getId() - b.getId());
        
        System.out.println();
        System.out.println("After sorting");
        for (Student student : students) {
            System.out.println(student);
        }

        
        Printer printA = new Printer("A", 1000);
        Printer printB = new Printer("B", 1000);
        new Thread(printA).start();
        new Thread(printB).start();
        new Thread(() -> {for (int i = 1; i <= 1000; i++) System.out.printf("C%d\n", i);}).start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new LambdaExpressions();
    }

}
