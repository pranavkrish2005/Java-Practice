public class CollegeDataBase {
	/**
	 * CollegeDataBase contains an array of College objects
	 */
	private College[] list;

// this constructor is already complete – no other constructors needed
	public CollegeDataBase ()
	{
		list = new College[8];
		list[0] =  new College("Brown University","Bears",6670,3061,736);
		list[1] =  new College("Columbia University","Lions",8868,20116,3763);
		list[2] =  new College("Cornell University","Big Red",15182,8418,2908);
		list[3] =  new College("Dartmouth College","Big Green",4310,2099,571);
		list[4] =  new College("Harvard University","Crimson",6699,13120,4671);
		list[5] =  new College("University of Pennsylvania","Quakers", 10496,11013,4464);
		list[6] =  new College("Princeton University","Tigers",5394,2879,1172);
		list[7] =  new College("Yale University","Bulldogs",5453,6859,4140);
	}

/**
	 * Method prints all colleges names followed by their nicknames
	 */
	public void printSchoolsNicknames()
	{
		for(int i = 0; i < list.length; i++)
			System.out.println("Name : " + list[i].getInstitution() + "\tNickname" + list[i].getNickname());
	}
	
	/**
	 * Given a word, method prints out all institutions whose nicknames	 
 * contains the word.   e.g. sending in "Big" would print out: 
	 * Cornell University     Big Red 
	 * Dartmouth College      Big Green
	 * @param phrase
	 */
	public void findNickname(String phrase)
	{
		for(College i : list)
			if(i.getNickname().contains(phrase))
				System.out.println("Name : " + i.getInstitution() + "\tNickname" + i.getNickname());
	}
	
	/**
	 * Method will print all institutions with a total enrollment larger than a given parameter
	 * @param size
	 */
	public void totalEnrollment(int size)
	{
		for(College i : list)
			if(i.getUndergraduates() + i.getGraduates() > size)
				System.out.println(i.getInstitution());
	}
	
	/**
	 * Method calculates and returns the average total enrollment (grad plus   
 	 * undergrad) from all colleges
	 * @return average total enrollment (for all institutions)
	 */
	public double averageEnrollment()
	{
		double sum = 0.0;
		for(College i : list)
			sum += i.getGraduates() + i.getUndergraduates();
		return sum/list.length;
	}
	
	/**
	 * Method will return nickname of institution supplied as a parameter
	 * @param inst
	 * @return nickname of institution
	 */
	public String getNickname(String inst)
	{
		for(College i : list)
			if(i.getInstitution().equals(inst))
				return i.getNickname();
		return null;
	}
	
	/**
	 * Method calculates the average total enrollment from two given institutions
	 * @param inst1
	 * @param inst2
	 * @return average total enrollment 
	 */
	public double twoSchoolAverage(String inst1, String inst2)
	{
		double sum = 0.0;
		for(College i : list)
		{
			if(i.getInstitution().equals(inst1))
				sum += i.getGraduates() + i.getUndergraduates();
			else if(i.getInstitution().equals(inst2))
				sum += i.getGraduates() + i.getUndergraduates();
		}
		return sum / 2;
	}
	
	/**
	 * Method calculates the faculty/enrollment ratio for all schools, and returns 
	 * the name of the institution with the highest faculty/enrollment ratio
	 * @return name of institution
	 */
	public String highestRatio()
	{
		int max = list[0].getFaculty() / (list[0].getUndergraduates() + list[0].getGraduates());
		String name = list[0].getInstitution();
		for(College i : list)
			if((i.getFaculty() / (i.getUndergraduates() + i.getGraduates()) > max))
			{
				max = i.getFaculty() / (i.getUndergraduates() + i.getGraduates());
				name = i.getInstitution();
			}
		return name;
	}
	
	
	public static void main(String[] args)
	{
		CollegeDataBase one = new CollegeDataBase();
		one.printSchoolsNicknames();
		one.findNickname("B");
		one.totalEnrollment(10000);
		System.out.println("The average enrollment of all colleges is " + one.averageEnrollment());
		System.out.println("The nickname of Princeton University:  " + one.getNickname("Princeton University"));
		System.out.println("The average enrollment of Cornell and Harvard is:  " + one.twoSchoolAverage("Harvard University", "Cornell University"));
		System.out.println("The school with the highest faculty to student ratio: " + one.highestRatio());
	}
}