public class Almanac {
City[] list;
public Almanac() {
list = new City[5];
list[0] = new City(1581000, "Philadelphia");
list[1] = new City(486290 , "Atlanta");
list[2] = new City(486290 , "Boston");
list[3] = new City(8623000, "New York");
list[4] = new City(28491, "West Windsor");
}

/**
* Displays List of Cities
*/
public void printList()
{
	for(City i : list)
		System.out.println(i.toString());
}

/**
* Find the city with the smallest population return the name.
*/
public String smallestPop()
{
	int min = list[0].getPopulation();
	String name = list[0].getName();
	for(int i = 1; i < list.length; i++)
		if(list[i].getPopulation() < min)
		{
			min = list[i].getPopulation();
			name = list[i].getName();
		}
	return name;
}
/**
* Returns the average population
*/
public double averagePop()
{
	int sum = 0;
	for(City i : list)
		sum += i.getPopulation();
	return sum/list.length;
}
/**
* Changes the population of a City that matches searchName to newPopulation
*/
public void changePop(String searchName, int newPopulation)
{
	for(int i = 0; i < list.length; i++)
		if(searchName == list[i].getName())
			list[i].setPopulation(newPopulation);
		
}

/**
* this method will add rate % to each population in the list
* e.g. increasePop(5) will increase a city's population by 5%
*/
public void increasePop(double rate)
{
	for(int i = 0; i < list.length; i++)
		list[i].setPopulation((int)(list[i].getPopulation() + (list[i].getPopulation() * (double)rate / 100)));
}

public static void main(String[] args)
{
Almanac one = new Almanac();
one.printList();
System.out.println();
System.out.println("Average Population: " + one.averagePop());
System.out.println("Smallest: " + one.smallestPop());
one.changePop("West Windsor", 40000);
System.out.println();
System.out.println("After Change");
one.printList();
one.increasePop(5);
System.out.println();
System.out.println("After Increase");
one.printList();
}
}