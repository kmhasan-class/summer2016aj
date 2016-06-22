/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executor.demo;

import java.util.concurrent.Callable;

/**
 *
 * @author kmhasan
 */
public class AdderCallable implements Callable {
    int from;
    int to;

    public AdderCallable(int from, int to) {
        this.from = from;
        this.to = to;
    }
    
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = from; i <= to; i++)
            sum += i;
        return new Integer(sum);
    }
    
}
