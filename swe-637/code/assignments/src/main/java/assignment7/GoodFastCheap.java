package assignment7;

/**
 * @modified - Homework 7, Question 1
 * @student - Shaeq Khan, skhan27
 *
 * GoodFastCheap: A program for investigating clause testing
 * @author Paul Ammann
 * 
 */

public final class GoodFastCheap {

	boolean good = false;
	boolean fast = false;
	boolean cheap = false;

	public void makeGood() {
		good = true;
		if (fast && cheap) {
			cheap = false;
		}
	}

	public void makeFast() {
		fast = true;
		if (good && cheap) {
			good = false;
		}
	}

	public void makeCheap() {
		cheap = true;
		if (fast && good) {
			fast = false;
		}
	}

	public void makeBad() {
		good = false;
	}

	public void makeSlow() {
		fast = false;
	}

	public void makeExpensive() {
		cheap = false;
	}

	public boolean satisfactory() {
		if ((good && fast) || (good && cheap) || (fast && cheap)) {
			return true;
		}
		return false;
	}

	public boolean getGood() {
		return good;
	}

	public boolean getFast() {
		return fast;
	}

	public boolean getCheap() {
		return cheap;
	}

	public static void main(String[] args) {

		/*
		 * RACC major clause Test case g (2,6) f (2,4) c (3,4)
		 * 
		 * Truth table g f c -------------------- row 2 T T F row 3 T F T row 4
		 * T F F row 6 F T F
		 */

		GoodFastCheap gfc = // g f c
				new GoodFastCheap(); // F F F

		System.out.println("Good " + " Fast " + " Cheap\n");
		System.out.println(gfc.getGood() + " " + gfc.getFast() + " " + gfc.getCheap());

		gfc.makeFast(); // F T F
		System.out.println(gfc.getGood() + " " + gfc.getFast() + " " + gfc.getCheap());

		gfc.makeGood(); // T T F
		System.out.println(gfc.getGood() + " " + gfc.getFast() + " " + gfc.getCheap());

		gfc.makeCheap(); // T F T
		System.out.println(gfc.getGood() + " " + gfc.getFast() + " " + gfc.getCheap());

		gfc.makeExpensive(); // T F F
		System.out.println(gfc.getGood() + " " + gfc.getFast() + " " + gfc.getCheap());

		System.out.println("Satisfactory: " + gfc.satisfactory());
	}
}
