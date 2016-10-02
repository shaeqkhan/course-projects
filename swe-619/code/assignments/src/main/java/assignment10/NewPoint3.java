/*
 * SWE 619 - Assignment 10
 * @author shaeqkhan
 * NewPoint3.java
 */

package assignment10;

public class NewPoint3 {

	private Point2 point;
	private int z;

	public NewPoint3(int x, int y, int z) {
		point = new Point2(x, y);
		this.z = z;
	}

	public Point2 asPoint() {
		return point;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof NewPoint3))
			return false;
		NewPoint3 np = (NewPoint3) o;
		return (np.point.equals(point) && z == np.z);
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = point.hashCode();
		result = 31 * result + z;
		return result;
	}

	public String toString() {
		return point.getX() + "," + point.getY() + "," + z;
	}

}