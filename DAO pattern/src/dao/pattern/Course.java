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
public class Course {
    private String courseCode;
    private String courseTitle;

    public Course() {
    }

    public Course(String courseCode, String courseTitle) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    @Override
    public String toString() {
        return "Course{" + "courseCode=" + courseCode + ", courseTitle=" + courseTitle + '}';
    }
    
    
}
