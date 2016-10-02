/*
 * SWE 619 - Assignment 8
 * @author shaeqkhan
 */

package assignment8;

public class Producer extends Thread {

    protected BoundedStack stack;
    protected int n;

    public Producer(BoundedStack stack, int n) {
        this.stack = stack;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            stack.push(new Integer(i));
            System.out.println("produce: " + i);
            try {
               sleep((int)(Math.random() * 100));
            }  catch (InterruptedException e) {}
        }
    }
}