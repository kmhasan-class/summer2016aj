/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse4048lab1;

import java.util.ArrayList;
import java.util.Collections;

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
        
        Collections.sort(strings);
        
        for (String s: strings)
            System.out.println(s);
    }
    
}
