
public class RightTriangle extends Polygon {

	private double height;
	private double base;
	
	public RightTriangle()
	{
	}
	
	public RightTriangle(double h, double b)
	{
		super(3, "Right Triangle");
		height = h;
		base = b;
	}
	


	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	@Override
	public double getPerimeter() {
		double hyp = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
		return base + height + hyp;
	}

	@Override
	public double getArea() {
		return 1.0/2 * base * height;
	}
	
	public String toString()
	{
		return super.toString() + "\nPerimeter " + getPerimeter() + "\nArea " + getArea();
	}
	
	public static void main(String args[])
	{
		RightTriangle one = new RightTriangle(4, 5);
		System.out.println(one);
	}

}
