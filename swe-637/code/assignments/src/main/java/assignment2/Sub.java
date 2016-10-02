package assignment2;

import java.util.Date;

public final class Sub extends Super {
	private final Date date; // Blank final; set by constructor

	public Sub() {
		date = new Date();
	}

	@Override
	public void overrideMe() {
		System.out.println("Sub: overrideMe " + date);
	}

	public static void main(String[] args) {
		Sub sub = new Sub(); // Test: Expected = date is printed
		// sub.overrideMe();
		Super s = new Super();
		// s.overrideMe();
		Super s1 = new Sub();
		// s1.overrideMe();
	}
}