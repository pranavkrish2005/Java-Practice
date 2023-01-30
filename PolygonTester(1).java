public class PolygonTester
{
	public static void main(String[] args) {

		RightTriangle a = new RightTriangle(3, 4);

		Rectangle b = new Rectangle(1, 1);

		Square c = new Square(5);

		RegularNgon d = new RegularNgon(4, 5);

		Polygon[] shapes = new Polygon[4];
		shapes[0] = a;
		shapes[1] = b;
		shapes[2] = c;
		shapes[3] = d;

		double tot = 0;
		for (Polygon x : shapes) {
			System.out.println(x + "\n");
			tot += x.getArea();

		}
		System.out.println("\nTotal Area: " + tot);
	}
}