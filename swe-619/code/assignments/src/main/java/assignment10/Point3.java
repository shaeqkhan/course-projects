/*
 * SWE 619 - Assignment 10
 * @author shaeqkhan
 * Point3.java
 */

package assignment10;

public class Point3 extends Point2 {

	private int z;

	public Point3(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	public boolean equals(Object p) {
		if (p instanceof Point3)
			return equals((Point3) p);
		return super.equals(p);
	}

	public boolean equals(Point2 p) {
		if (p instanceof Point3)
			return equals((Point3) p);
		return super.equals(p);
	}

	public boolean equals(Point3 p) {
		if (p == null || z != p.z)
			return false;
		return super.equals(p);
	}

	public int getZ() {
		return z;
	}

	public String toString() {
		return getX() + "," + getY() + "," + getZ();
	}

}