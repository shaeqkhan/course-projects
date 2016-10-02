/*
 * Author - Shaeq Khan
 * Description - Liskov's Poly class is modified to a mutable class
 * 				 Variable trms is now represented as an Integer List
 * 
 * Assignment#3 - Due 19th Sept 2012, 16:30 
 * Course - SWE 619 OO Software Specification and Construction
 * Professor - Dr. Paul Ammann
 * GTA - Ehsan Kouroshfar
 */

package assignment3;

import java.util.*;

public class Poly {

	private List<Integer> trms = new ArrayList<Integer>();
	private int deg;

	// Effects: Initializes this to be the zero polynomial
	public Poly() {
		trms = new ArrayList<Integer>(1);
		// trms[0] = 0;
		trms.add(0, 0);
		deg = 0;
	}

	// Effects: If n < 0 throws IllegalArgumentException
	// else initializes this to be the polynomial c*x^n
	public Poly(int c, int n) throws IllegalArgumentException {
		if (n < 0) {
			throw new IllegalArgumentException("Poly(int, int) constructor");
		}
		if (c == 0) {
			// trms = new int[1];
			trms = new ArrayList<Integer>(1);
			// trms[0] = 0;
			trms.add(0, 0);
			deg = 0;
			return;
		}
		// trms = new int[n+1];
		trms = new ArrayList<Integer>(n + 1);
		// Initializing all elements of list to 0;
		for (int i = 0; i < n + 1; i++) {
			// trms[i] = 0;
			trms.add(i, 0);
		}
		// trms[n] = c;
		trms.add(n, c);
		deg = n;
	}

	private Poly(int n) {
		// trms = new int[n+1];
		trms = new ArrayList<Integer>(n + 1);
		// Initializing all elements of list to 0;
		for (int k = 0; k <= n + 1; k++) {
			trms.add(0);
		}
		deg = n;
	}

	// Effects: returns the degree of the calling Poly object
	public int degree() {
		return deg;
	}

	// Effects: returns the coefficent of the term of this whose exponent is d
	// of the calling Poly object
	public int coef(int d) {
		// return (d < 0 || d > deg) ? 0 : trms[d];
		return (d < 0 || d > deg) ? 0 : trms.get(d);
	}

	// Effects: If q is null throw NullPointerException
	// else call function add with additive inverse of calling Poly object
	public String sub(Poly q) throws NullPointerException {
		return (add(q.minus()));
	}

	// Effects: return the calling Poly object with negative coefficients
	private Poly minus() {
		Poly r = new Poly(deg);
		for (int i = 0; i <= deg; i++) {
			int t = -trms.get(i);
			r.trms.set(i, t);
		}
		return r;
	}

	// Effects: If q is null throw NullPointerException
	// else add Poly q to the calling Poly object and call toString method
	public String add(Poly q) throws NullPointerException {
		Poly la, sm;
		if (deg > q.deg) {
			la = this;
			sm = q;
		} else {
			la = q;
			sm = this;
		}
		int newdeg = la.deg;
		if (deg == q.deg) {
			for (int k = deg; k > 0; k--) {
				// if (trms[k] + q.trms[k] != 0) {
				int s = trms.get(k) + q.trms.get(k);
				if (s != 0) {
					break;
				} else {
					newdeg--;
				}
			}
		}

		Poly r = new Poly(newdeg);
		int i;

		for (i = 0; i <= sm.deg && i <= newdeg; i++) {
			// r.trms[i] = sm.trms[i] + la.trms[i];
			r.trms.set(i, sm.trms.get(i) + la.trms.get(i));
		}
		for (int j = i; j <= newdeg; j++) {
			// r.trms[j] = la.trms[j];
			r.trms.set(j, la.trms.get(j));
		}
		// return r;
		return (r.toString());
	}

	// Effects: If q is null throw NullPointerException
	// else multiply Poly q to the calling Poly object and call toString method
	public String mul(Poly q) throws NullPointerException {

		// if ((q.deg == 0 && q.trms[0] == 0) || (deg == 0 && trms[0] == 0)) {
		if ((q.deg == 0 && q.trms.get(0) == 0) || (deg == 0 && trms.get(0) == 0)) {
			new Poly().toString();
		}

		Poly r = new Poly(deg + q.deg);

		for (int i = 0; i <= deg; i++) {
			for (int j = 0; j <= q.deg; j++) {
				// r.trms[i+j] += trms[i]*q.trms[j];
				r.trms.set(i + j, trms.get(i) * q.trms.get(j));
			}
		}
		// return r;
		// System.out.println(r.toString());
		return (r.toString());
	}

	public String toString() {
		String r = "Poly:";

		if (deg == 0 || trms.get(0) != 0) {
			r += " " + trms.get(0);
		}

		for (int i = 1; i <= deg; i++) {
			if (trms.get(i) < 0) {
				r += " - " + -trms.get(i) + "x^" + i;
			} else if (trms.get(i) > 0) {
				r += " + " + trms.get(i) + "x^" + i;
			}
		}
		return r;
	}

}