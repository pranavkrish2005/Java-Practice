public class Reservation
{
private String name; // last name of the person reserving the room
private double rate; // room rate for 1 night&#39;s stay
public Reservation()
{
	name = null;
	rate = 0.0;
}
public Reservation(String myName, double myRate)
{
	name = myName;
	rate = myRate;
}

public double getRate()
{
	return rate;
}
public String getName()
{
	return name;
}

public String toString()
{
	return "Name : " + name + "\tRate : " + rate;
}
}