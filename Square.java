
public class Square extends Rectangle {
	
	
	public Square()
	{
	}
	
	public Square(int si)
	{
		this.setLength(si);
		this.setWidth(si);
		this.setType("Square");
		this.setSides(4);
	}
	
	
	
	public static void main(String args[])
	{
		Square one = new Square(4);
		System.out.println(one);
	}

}
