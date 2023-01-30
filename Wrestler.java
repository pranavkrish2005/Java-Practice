
public class Wrestler extends Athlete
{
	
	public double MilesRaced;
	
	public Wrestler(String fname, String lname, String s)
	{
		super(fname, lname, s);
	}

	@Override
	public void train(double hours) {
		
		super.sethoursTraining(super.gethoursTraining() + hours);
	}

	@Override
	public int caloriesBurned() {
		return (int)(600 * super.gethoursTraining());
	}
	
	public String toString()
	{
		return super.toString() + "expending " + caloriesBurned();
	}
	
	public void race(double miles)
	{
		MilesRaced += miles;
	}

}
