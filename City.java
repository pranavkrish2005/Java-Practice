
public class City
{
	private String name;
	private int population;
	
	public City(int p, String n)
	{
		name = n;
		population = p;
	}
	
	public City()
	{
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	public String toString()
	{
		return "City : " + name + ", Population : " + population;
	}
}
