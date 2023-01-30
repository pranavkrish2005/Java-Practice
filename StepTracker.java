import java.util.ArrayList;

public class StepTracker
{
	private int minsteps;
	private ArrayList<Integer> steps;
	
	public StepTracker(int step)
	{
		minsteps = step;
		steps = new ArrayList<Integer>(0);
	}
	
	public int activeDays()
	{
		int count = 0;
		for(int i = 0; i < steps.size(); i++)
		if(steps.get(i) > minsteps)
			count++;
		return count;
	}
	
	public void addDailySteps(int step)
	{
		steps.add(step);
	}
	
	public double averageSteps()
	{
		if(steps.size() == 0)
			return 0.0;
		else
		{
			int count = 0;
			for(int i = 0; i < steps.size(); i++)
				count += steps.get(i);
			return ((double)count)/steps.size();
		}
	}
	
	public static void main(String[] args)
	{
		StepTracker tr = new StepTracker(10000);
		System.out.println(tr.activeDays());
		System.out.println(tr.averageSteps());
		tr.addDailySteps(9000);
		tr.addDailySteps(5000);
		System.out.println(tr.activeDays());
		System.out.println(tr.averageSteps());
		tr.addDailySteps(13000);
		System.out.println(tr.activeDays());
		System.out.println(tr.averageSteps());
		tr.addDailySteps(23000);
		tr.addDailySteps(1111);
		System.out.println(tr.activeDays());
		System.out.println(tr.averageSteps());
	}
}
