/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executor.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ExecutorDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdderCallable a1 = new AdderCallable(1, 50);
        AdderCallable a2 = new AdderCallable(51, 100);
        
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future f1 = executorService.submit(a1);
        Future f2 = executorService.submit(a2);
        /*
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a2);
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ExecutorDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        int total;
        try {
            total = ((Integer) f1.get()).intValue();
            total += ((Integer) f2.get()).intValue();
            System.out.println("Printing from main " + total);
        } catch (InterruptedException ex) {
            Logger.getLogger(ExecutorDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(ExecutorDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        executorService.shutdown();
                
    }
    
}
