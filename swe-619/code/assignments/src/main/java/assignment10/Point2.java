/*
 * SWE 619 - Assignment 10
 * @author shaeqkhan
 * Point2.java
 */

package assignment10;

public class Point2 {

	private int x;
	private int y;

	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Point2))
			return false;
		Point2 p = (Point2) o;
		return (p.x == x && p.y == y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + x;
		result = 31 * result + y;
		return result;
	}

	public String toString() {
		return x + "," + y;
	}

}