
public class RegularNgon extends Polygon
{
	private int length;
	private int n;
	
	public RegularNgon()
	{
	}
	
	public RegularNgon(int n, int l)
	{
		super(n, n + " sided Ngon");
		this.n = n;
		length = l;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public String toString()
	{
		return super.toString() + "\nPerimeter " + getPerimeter() + "\nArea " + getArea();
	}

	@Override
	public double getPerimeter() {
		return length * n;
	}

	@Override
	public double getArea() {
		return (Math.pow(length, 2) * n)/(double)(4 * Math.tan(Math.PI/n));
	}
	
	public static void main(String args)
	{
		RegularNgon one = new RegularNgon(6, 5);
		System.out.println(one);
	}


}
