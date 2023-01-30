
public class Rectangle extends Polygon
{
	private int length;
	private int width;
	
	public Rectangle()
	{
	}
	
	public Rectangle(int l, int w)
	{
		super(4, "Rectangle");
		length = l;
		width = w;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getPerimeter()
	{
		return 2 * (length + width);
	}
	
	public double getArea()
	{
		return length * width;
	}
	
	public String toString()
	{
		return super.toString() + "\nPerimeter " + getPerimeter() + "\nArea " + getArea();
	}
	
	public static void main(String args[])
	{
		Rectangle one = new Rectangle(4, 5);
		System.out.println(one);
	}
}
