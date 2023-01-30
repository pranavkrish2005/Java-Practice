
public abstract class Polygon
{
	private int sides;
	private String type;
	
	public Polygon()
	{
	}
	
	public Polygon(int s, String t)
	{
		sides = s;
		type = t;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString()
	{
		return "SIDES : " + sides + "\nTYPE : " + type;
	}
	
	public abstract double getPerimeter();
	
	public abstract double getArea();
	
}
