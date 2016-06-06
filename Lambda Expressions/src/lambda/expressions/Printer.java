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
public class Printer implements Runnable {
    private String label;
    private int limit;

    public Printer(String label, int limit) {
        this.label = label;
        this.limit = limit;
    }
    
    public void print() {
        for (int i = 1; i <= limit; i++)
            System.out.printf("%s%d\n", label, i);
    }

    public String getLabel() {
        return label;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public void run() {
        print();
    }
}
