/**
 * SWE 637 Assignment 1
 *
 * @author shaeqkhan
 * @lastmodified feb 4,2013
 */

package assignment1;

import java.util.Vector;

public class Assignment1 {

	/*
	 * @param any vector a
	 * 
	 * @param any vector b
	 * 
	 * @return union of vector a and b this method returns a vector of objects
	 * that are in either of the two argument vectors
	 */
	public static Vector union(Vector a, Vector b) {
		Vector res = new Vector();

		for (int i = 0; i < a.size(); i++) {
			res.add(a.get(i));
		}

		for (int j = 0; j < b.size(); j++) {
			if (!res.contains(b.get(j)))
				res.add(b.get(j));
		}

		return res;
	} // end of union

} // end of class