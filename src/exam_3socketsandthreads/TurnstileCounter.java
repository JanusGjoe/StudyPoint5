/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam_3socketsandthreads;

public class TurnstileCounter
{
    private long count = 0;
    
    public long getTotalAmount()
    {
        return count;
    }
    
    synchronized public void incr()
    {
        count++;
    }
}
