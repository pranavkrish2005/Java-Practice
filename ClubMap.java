import java.util.HashMap;
import java.util.TreeSet;

public class ClubMap {
	HashMap<String, TreeSet<Student>> clubList;
	
	public ClubMap()
	{
		clubList = new HashMap<String, TreeSet<Student>>();
	}
	
	public void add(String[] s)
	{
		Student st = new Student(s[1], s[0], s[2]);
		TreeSet<Student> ts = new TreeSet<Student>();
		if(clubList.get(s[3]) == null)
		{
			ts.add(st);
			clubList.put(s[3], ts);
		}
		else
		{
			ts = clubList.get(s[3]);
			ts.add(st);
			clubList.put(s[3], ts);
		}
	}
	
	public String getStudents(String club)
	{
		String output = club + " : \t";
		if(club.length() <= 4)
			output += "\t";
		for(Student s : clubList.get(club))
		{
			output += s.toString() + "\t";
			if(s.toString().length() <= 23)
				output += "\t";
		}
		return output.substring(0, output.length() - 2);
	}
	
	public String printAllStudents()
	{
		String output = "";
		for(String s : clubList.keySet())
			output += this.getStudents(s) + "\n";
		return output;
	}
}
