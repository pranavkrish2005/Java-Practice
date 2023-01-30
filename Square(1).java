
public class Square extends Polygon {
	
	private int side;
	
	public Square()
	{
	}
	
	public Square(int si)
	{
		super(4, "Square");
		side = si;
	}
	
	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	@Override
	public double getPerimeter() {
		return 4 * side;
	}

	@Override
	public double getArea() {
		return Math.pow(side, 2);
	}
	
	public String toString()
	{
		return super.toString() + "\nPerimeter " + getPerimeter() + "\nArea " + getArea();
	}
	
	public static void main(String args[])
	{
		Square one = new Square(4);
		System.out.println(one);
	}

}
