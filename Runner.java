
public class Runner extends Athlete
{
	public int numraces;
	public double MilesRaced;
	
	public Runner(String fname, String lname, String s)
	{
		super(fname, lname, s);
		MilesRaced = 0;
		numraces = 0;
	}
	
	public void race(double miles)
	{
		numraces++;
		MilesRaced += miles;
	}
	
	@Override
	public void train(double hours)
	{
		super.sethoursTraining(super.gethoursTraining() + hours);
	}

	@Override
	public int caloriesBurned()
	{
		return (int)(400 * super.gethoursTraining());
	}
	
	public String toString()
	{
		return super.toString() + "expending " + caloriesBurned() + 
				"\n # of races and training miles : " + numraces + " races / " + MilesRaced + " miles.";
	}

}
