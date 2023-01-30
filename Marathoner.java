
public class Marathoner extends Runner
{
	public Marathoner(String fname, String lname, String s)
	{
		super(fname, lname, s);
	}
	
	@Override
	public void race(double miles)
	{
		if(miles > 10.0)
		{
			numraces++;
			MilesRaced += miles;
		}
		else
			super.sethoursTraining(super.gethoursTraining() + (8.5 * miles) / 60);
	}
}
