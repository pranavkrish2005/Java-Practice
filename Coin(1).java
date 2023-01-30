
public class Coin
{
	private int date = 0;
	private String type = "";
	
	public Coin()
	{
		date = 0;
		type = "";
	}
	public Coin(int i, String string)
	{
		date = i;
		type = string;
	}
	
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean equals(Coin c)
	{
		if((c.getDate()/10) * 10 == 10 * (this.getDate() / 10))
		{
			if(!this.getType().equals(c.getType()))
				return true;
			else
				return false;
		}
		else
			return true;
	}
	
	public String toString()
	{
		return date + ", " + type + "\n";
	}
}
