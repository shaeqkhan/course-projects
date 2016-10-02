package assignment10;

public class Test {

	public static void main(String[] args) {

		Point3 x = new Point3(7, 8, 9);
		Point2 y = new Point2(7, 8);
		Point3 z = new Point3(7, 8, 0);

		System.out.println(x.equals(y));
		System.out.println(y.equals(x));

		System.out.println(y.equals(z));
		System.out.println(z.equals(y));

		System.out.println(x.equals(z));

		NewPoint3 a = new NewPoint3(33, 34, 35);
		Point2 b = new Point2(33, 34);
		NewPoint3 c = new NewPoint3(33, 34, 40);

		System.out.println(a.equals(b));
		System.out.println(b.equals(c));
		System.out.println(a.equals(c));
	}

}