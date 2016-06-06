/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse4048lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author kmhasan
 */
public class CSE4048Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> strings;
        strings = new ArrayList<>();
        
        strings.add("berries");
        strings.add("apple");
        strings.add("banana");
        strings.add("pineapple");
        strings.add("dragonfruit");
        strings.add("tokyo");
        strings.add("dhaka");
        strings.add("bangkok");
        
        /*
        // Using anonymous class
        Collections.sort(strings, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String) o1;
                String s2 = (String) o2;
                
                if (s1.length() < s2.length())
                    return -1;
                else if (s1.length() == s2.length())
                    return s1.compareTo(s2);
                else return +1;
            }
        });
        */
        
        Collections.sort(strings, (s1, s2) -> {
            if (s1.length() < s2.length())
                return -1;
            else if (s1.length() == s2.length())
                return s1.compareTo(s2);
            else return +1;
        });
        
        for (String s: strings)
            System.out.println(s);
    }
    
}
