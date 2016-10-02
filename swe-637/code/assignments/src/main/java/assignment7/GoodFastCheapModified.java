package assignment7;

/**
 * @modified - Homework 7, Question 2
 * @student - Shaeq Khan, skhan27
 *
 * GoodFastCheapModified: A program for investigating clause testing
 * @author Paul Ammann
 */

public final class GoodFastCheapModified {

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
		if (good && fast)
			return true;
		if (good && cheap)
			return true;
		if (fast && cheap)
			return true;

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
		 * RACC
		 * 
		 * g && f
		 * 
		 * major clause Test case g (1,3) f (1,2)
		 * 
		 * Truth table g f ---------------- row 1 T T row 2 T F row 3 F T
		 * 
		 *
		 * g && c
		 *
		 * major clause Test case g (1,3) c (1,2)
		 *
		 * Truth table g c ---------------- row 1 T T row 2 T F row 3 F T
		 *
		 * f && c
		 *
		 * major clause Test case f (1,3) c (1,2)
		 * 
		 * Truth table f c ---------------- row 1 T T row 2 T F row 3 F T
		 *
		 * 
		 * Overall states that need to be visited with respect to previous truth
		 * table Truth table g f c -------------------- row 2 T T F row 3 T F T
		 * row 4 T F F row 5 F T T row 6 F T F
		 *
		 */

		GoodFastCheap gfc = // g f c
				new GoodFastCheap(); // F F F

		System.out.println("Good " + " Fast " + " Cheap\n");
		System.out.println(gfc.getGood() + " " + gfc.getFast() + " " + gfc.getCheap());

		gfc.makeFast(); // F T F
		System.out.println(gfc.getGood() + " " + gfc.getFast() + " " + gfc.getCheap());

		gfc.makeCheap(); // F T T
		System.out.println(gfc.getGood() + " " + gfc.getFast() + " " + gfc.getCheap());

		gfc.makeGood(); // T T F
		System.out.println(gfc.getGood() + " " + gfc.getFast() + " " + gfc.getCheap());

		gfc.makeCheap(); // T F T
		System.out.println(gfc.getGood() + " " + gfc.getFast() + " " + gfc.getCheap());

		gfc.makeExpensive(); // T F F
		System.out.println(gfc.getGood() + " " + gfc.getFast() + " " + gfc.getCheap());
	}
}
