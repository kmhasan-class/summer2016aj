/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executor.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class Adder implements Runnable {

    private int from;
    private int to;
    private int sum;

    public Adder(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        sum = 0;
        for (int i = from; i <= to; i++)
            sum = sum + i;
        System.out.println("Done adding up numbers " + sum);
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getSum() {
        return sum;
    }
    
    
}
