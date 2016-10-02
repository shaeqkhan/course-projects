/*
 * SWE 619 - Assignment 8
 * @author shaeqkhan
 */

package assignment8;

public class Consumer extends Thread {

    protected BoundedStack stack;
    protected int n;

    public Consumer(BoundedStack stack, int n) {
        this.stack = stack;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            Object obj = stack.pop();
            if (obj != null)
                System.out.println("\tconsume: "+obj);
            try {
                sleep((int)(Math.random() * 400));
            }  catch (InterruptedException e) {}
        }
    }
}