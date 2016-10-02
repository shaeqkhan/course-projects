/*
 * SWE 619 - Assignment 8
 * @author shaeqkhan
 */

package assignment8;

public class BoundedStack {

	private Object[] elements; // store elements in stack
	private int size = 0; // max size of stack
	private int top; // top index of stack

	// constructor
	public BoundedStack(int size) {
		if (size > 0) {
			this.size = size;
			elements = new Object[size];
			top = 0;
		}
	}

	// methods

	synchronized public void push(Object e) {
		// Requires: this
		// Modifies: this
		// Effects: push an object e on top of the stack if there is space
		// else wait till there is space

		try {
			while (isFull()) {
				wait();
			}
		} catch (InterruptedException ex) {
		}
		if (ensureCapacity())
			elements[top++] = e;
		notify();
	}

	synchronized public Object pop() {
		// Requires: this
		// Modifies: this
		// Effects: remove an object e from the top of the stack
		// else wait till there is an element on top to remove

		try {
			while (isEmpty()) {
				wait();
			}
		} catch (InterruptedException ex) {
		}
		if (top == 0)
			throw new IllegalStateException("BoundedStack.pop");

		Object result = elements[--top];
		elements[top] = null;
		notify();

		return result;
	}

	synchronized private boolean ensureCapacity() {
		// Requires: this
		// Effects: returns true if there is place to push elements on stack
		return (top <= size);
	}

	synchronized public boolean isEmpty() {
		// Requires: this
		// Effects: returns true if the stack is empty
		return (top == 0);
	}

	synchronized public boolean isFull() {
		// Requires: this
		// Effects: returns true if the stack is full
		return (top == size);
	}

	public static void main(String args[]) {
		BoundedStack stack = new BoundedStack(5);

		new Producer(stack, 15).start();
		new Consumer(stack, 15).start();
	}

}