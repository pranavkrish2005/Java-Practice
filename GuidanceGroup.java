import java.util.Arrays;
public class GuidanceGroup {
	// Array group will store SatStudent objects
	private SatStudent[] group;
	/**
	* Default Constructor for objects of class GuidanceGroup
	*/
	public GuidanceGroup() {
	group = new SatStudent[12];
	group[0] = (new SatStudent("Ye", 640, 695, 686));
	group[1] = (new SatStudent("Bradley", 778, 768, 780));
	group[2] = (new SatStudent("Chen", 687, 614, 705));
	group[3] = (new SatStudent("Davis", 620, 534, 556));
	group[4] = (new SatStudent("Aarons", 550, 565, 517));
	group[5] = (new SatStudent("Gupta", 687, 720, 640));
	group[6] = (new SatStudent("Park", 722, 721, 745));
	group[7] = (new SatStudent("Kohl", 595, 605, 615));
	group[8] = (new SatStudent("Mehta", 525, 637, 521));
	group[9] = (new SatStudent("Bahl", 611, 607, 610));
	group[10] = (new SatStudent("Smith", 670, 703, 610));
	group[11] = (new SatStudent("Issacs", 670, 690, 710));
	}
	// Constructor with a SatStudent[] array as a parameter
	public GuidanceGroup(SatStudent[] myGroup) {
	group = myGroup;
	}

	// This method displays a chart with 2 columns: Name and Total SAT score
	public void display()
	{
		for(SatStudent x : group)
			System.out.println(x.getName() + " : " + x.getGrade());
	}
	// This method returns the name of the student with the lowest total SAT
	public String getMin()
	{
		String n = group[0].getName();
		int min = group[0].getGrade();
		for(SatStudent x : group)
			if(x.getGrade() < min)
			{
				min = x.getGrade();
				n = x.getName();
			}
		return n;
	}
	// This method returns the name of the student with the highest total SAT
	// score
	public String getMax()
	{
		String n = group[0].getName();
		int max = group[0].getGrade();
		for(SatStudent x : group)
			if(x.getGrade() > max)
			{
				max = x.getGrade();
				n = x.getName();
			}
		return n;
	}
	// This method returns the average of all SAT scores
	public double average()
	{
		double sum = 0.0;
		for(SatStudent x : group)
			sum += x.getGrade();
		return sum / group.length;
	}
	// This method displays a list of names of students who scored below 1700
	public void below1700List()
	{
		for(SatStudent x : group)
			if(x.getGrade() < 1700)
				System.out.println(x.getName());
	}
	// This method displays a list of names of students who scored above2000
	public void above2000List()
	{
		for(SatStudent x : group)
			if(x.getGrade() > 2000)
				System.out.println(x.getName());
	}
	// this method will return the total score of an inputed name.
	// return -1 if student is not found
	public int getScore(String lookfor)
	{
		for(SatStudent x : group)
			if(x.getName().equals(lookfor))
				return x.getGrade();
		return -1;
	}
	// returns an array of SatStudents with total scores >1900
	public SatStudent[] scholarship()
	{
		int length = 0;
		for(SatStudent x : group)
			if(x.getGrade() > 1900)
				length++;
		SatStudent[]arr = new SatStudent[length];
		int j = 0;
		for(SatStudent x : group)
			if(x.getGrade() > 1900)
				arr[j++] = x;
		return arr;
	}
	
	// returns a new GuidanceGroup with the SatStudents of this class combined
	// with the SatStudents of other class
	public GuidanceGroup combineGroups(GuidanceGroup other)
	{
		SatStudent[] arr = new SatStudent[this.group.length + other.group.length];
		for(int i = 0; i < this.group.length; i++)
			arr[i] = this.group[i];
		for(int i = 0; i < other.group.length; i++)
			arr[i + this.group.length] = other.group[i];
			
		GuidanceGroup two = new GuidanceGroup(arr);
		return two;
	}
	//Sorts the array of the GuidanceGroup by total score (descending)
	public void sortByTotalScore() 
	{
		int n = group.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (group[j].getGrade() < group[j + 1].getGrade())
				{
					SatStudent temp = group[j];
					group[j] = group[j+1];
					group[j+1] = temp;
				}
		
		this.display();
	}
	//Sorts the array of the GuidanceGroup by Name (ascending (alphabetically))
	public void sortByName()
	{
		int n = group.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (group[j].getName().compareTo(group[j + 1].getName()) > 0)
				{
					SatStudent temp = group[j];
					group[j] = group[j+1];
					group[j+1] = temp;
				}

		
		this.display();
	}
	// this method will return the average of all of the students in the
	// Scholarship category
	public double getScholarShipAverage()
	{
		double sum = 0.0;
		SatStudent[] arr = this.scholarship();
		for(SatStudent x : arr)
			sum += x.getGrade();
		return sum / arr.length;
	}
	
	public String toString()
	{
		String output = "";
		for(SatStudent x : group)
			output += x.getName() + " : " + x.getGrade() + "\n";
		return output;
	}

	public static void main(String[] args)
	{
		
	}
}