public class College
{
	String institution, nickname;
	int undergraduates, graduates, faculty;
	// complete this constructor
	public College(String inst, String nick, int ugStu, int gradStu, int fac)
	{
		institution = inst;
		nickname = nick;
		undergraduates = ugStu;
		graduates = gradStu;
		faculty = fac;
	}
	
	public String toString()
	{
		return "College : " + this.getInstitution() + "\tNickname : " + this.getNickname() + "\tundergraduates : " + 
				this.getUndergraduates() + "\tgraduates : " + this.getGraduates() + "\tfaculty : " + this.getFaculty();
	}
	
	public String getInstitution()
	{
		return institution;
	}

	public void setInstitution(String institution)
	{
		this.institution = institution;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public int getUndergraduates()
	{
		return undergraduates;
	}

	public void setUndergraduates(int undergraduates)
	{
		this.undergraduates = undergraduates;
	}

	public int getGraduates()
	{
		return graduates;
	}

	public void setGraduates(int graduates)
	{
		this.graduates = graduates;
	}

	public int getFaculty()
	{
		return faculty;
	}

	public void setFaculty(int faculty)
	{
		this.faculty = faculty;
	}

	// you can use this tester to make sure your toString and constructor works
	public static void main(String[] args)
	{
		College one = new College("Brown University","Bears",6670,3061,736);
		System.out.println(one);
	}

}