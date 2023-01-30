public abstract class Athlete {

	private String firstName;
	private String lastName;
	private String sport;
	private double hoursTraining;

	/**
	 * Constructs an athlete with a specified name and sport; hoursTraining is
	 * initialized to 0.
	 * 
	 * @param fname
	 *            first name of athlete
	 * @param lname
	 *            last name of athlete
	 * @param sportPlayed
	 *            sport in which athlete participates
	 */
	public Athlete(String fname, String lname, String s)
	{
		firstName = fname;
		lastName = lname;
		hoursTraining = 0.0;
		sport = s;
	}


	public String toString() {
		return firstName + " " + lastName + " is a " + sport + " and has trained " + hoursTraining + " hours, ";
	}
	
	public double gethoursTraining()
	{
		return hoursTraining;
	}
	
	public void sethoursTraining(double h)
	{
		hoursTraining = h;
	}
	

	/**
	 * Increments hours of training.
	 * 
	 * @param hours   number of hours athlete trained
	 */
	public abstract void train(double hours);

	
	/**
	 * Calculates the number of calories burned
	 * based on the number of hours athlete trained
	 * 
	 */
	public abstract int caloriesBurned();
	
	public abstract void race(double miles);
	


}