package dao.pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kmhasan
 */
public enum Grade {
    A_PLUS("A+", 4.00),
    A("A", 3.75), 
    A_MINUS("A-", 3.50);

    private String letterGrade;
    private double numericGrade;
    
    Grade(String letterGrade, double numericGrade) {
        this.letterGrade = letterGrade;
        this.numericGrade = numericGrade;
    }
}
