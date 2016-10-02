package assignment2;

public class Super {
	// Broken - constructor invokes an overridable method
	String message = "Hello";

	public Super() {
		overrideMe();
	}

	public void overrideMe() {
		System.out.println("Super: overrideMe" + message);
	}
}
