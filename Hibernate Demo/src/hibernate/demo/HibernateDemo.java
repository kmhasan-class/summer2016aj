/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.demo;

import java.util.List;
import model.Course;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author kmhasan
 */
public class HibernateDemo {

    public SessionFactory buildSession() {
        Configuration configuration = new Configuration();
        configuration.configure(HibernateDemo.class.getResource("hibernate.cfg.xml"));
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
    
    public HibernateDemo() {
        SessionFactory factory = buildSession();
        Session session = factory.openSession();
        
        List<Student> students = null;
        
        Transaction transaction = session.beginTransaction();
        try {
            //session.save(new Student(12, "Akter"));
            //session.save(new Course("CSE4047", "Advanced Java", 3.0));
            Student s = new Student(99, "Alam");
            Course c1 = new Course("CSE1033", "Data Structures", 3.0);
            Course c2 = new Course("CSE1034", "Data Structures Lab", 1.0);
            Course c3 = new Course("MATH1024", "Coordinate Geometry", 3.0);
            s.addCourse(c1);
            s.addCourse(c2);
            s.addCourse(c3);
            
            session.save(c1);
            session.save(c2);
            session.save(c3);
            session.save(s);
            students = session.createCriteria(Student.class).list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        
        students.forEach(System.out::println);
        
        session.close();
        System.exit(0);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new HibernateDemo();
    }
    
}
