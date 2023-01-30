import java.util.ArrayList;

public class ArrayListStack implements MyStack
{
	public ArrayList<Object> front;
	
	public ArrayListStack()
	{
		front = new ArrayList<>();
	}

	public Object push(Object item)
	{
		front.add(item);
		return item + " has been pushed\n";
	}

	public Object pop()
	{
		Object obj = front.get(front.size() - 1);
		front.remove(front.size() - 1);
		return obj;
	}

	public Object peek()
	{
		return front.get(front.size() - 1);
	}

	public boolean isEmpty()
	{
		return front.isEmpty();
	}

	public int size()
	{
		return front.size();
	}

	public int search(Object a)
	{
		return front.indexOf(a);
	}
	
	public String toString()
	{
		String output = "";
		for(int i = 0; i < front.size(); i++)
			output += front.get(i) + "\n";
		return output;
	}

}
