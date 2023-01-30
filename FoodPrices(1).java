import java.util.*;
public class FoodPrices {
	
	private Map<String, Double> eachitem;
	
	
	public FoodPrices()
	{
		eachitem = new TreeMap<String, Double>();
		eachitem.put("burgers", 4.5);
		eachitem.put("buns", 2.11);
		eachitem.put("cups", 1.3);
		eachitem.put("straws", 0.45);
		eachitem.put("fries", 5.22);
		eachitem.put("cokesyrup", 6.17);
		eachitem.put("napkins", 1.76);
	}


	public Map<String, Double> getEachitem() {
		return eachitem;
	}


	public void setEachitem(Map<String, Double> eachitem) {
		this.eachitem = eachitem;
	}
	
	public LinkedList<Double> calcCost(Map<String, Integer> item){
		LinkedList<Double> one = new LinkedList<Double>();
		for(String x : item.keySet())
			if(item.get(x) * eachitem.get(x) != 0)
				one.add(item.get(x) * item.get(x) * eachitem.get(x));
		return one;
	}
	
	public double calcTotalCost(Map<String, Integer> item)
	{
		LinkedList<Double> one = this.calcCost(item);
		int total = 0;
		for(double d : one)
			total += d;
		return total;
	}
	

}
