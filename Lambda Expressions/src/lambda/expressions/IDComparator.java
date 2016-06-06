/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda.expressions;

import java.util.Comparator;

/**
 *
 * @author kmhasan
 */
public class IDComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student a = (Student) o1;
        Student b = (Student) o2;
        return a.getId() - b.getId();
    }
    
}
