import java.util.Arrays;
public class SatStudent
{
	public String name;
	public int math;
	public int verbal;
	public int writing;
	public int grade;
	
	public SatStudent()
	{
		this("Andersson", 670,680,700);
	}
	
	public SatStudent(String n, int m, int v, int w)
	{
		name = n;
		math = m;
		verbal = v;
		writing = w;
		this.setGrade();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getVerbal() {
		return verbal;
	}

	public void setVerbal(int verbal) {
		this.verbal = verbal;
	}

	public int getWriting() {
		return writing;
	}

	public void setWriting(int writing) {
		this.writing = writing;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade()
	{
		grade = math + verbal + writing;
	}
	
	public String toString()
	{
		return this.getName() + " : " + this.getGrade();
	}
	
}
