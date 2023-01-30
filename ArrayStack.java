
public class ArrayStack implements MyStack
{
	public Object[] front;
	
	public ArrayStack()
	{
		front = new Object[0];
	}

	public Object push(Object item)
	{
		Object[] temp = new Object[front.length + 1];
		for(int i = 0; i < front.length; i++)
		{
			temp[i] = front[i];
		}
		temp[front.length] = item;
		front = temp;
		return item + " has been pushed\n";
	}

	public Object pop()
	{
		Object obj;
		if(front.length == 1)
		{
			obj = front[0];
			front = null;
		}
		else
		{
			obj = front[front.length - 1];
			Object[] temp = new Object[front.length - 1];
			for(int i = 0; i < temp.length; i++)
			{
				temp[i] = front[i];
			}
			front = temp;
		}
		
		return obj;
	}

	public Object peek()
	{
		return front[front.length - 1];
	}

	public boolean isEmpty()
	{
		return front == null;
	}

	public int size()
	{
		return front.length;
	}

	public int search(Object a)
	{
		for(int i = 0; i < front.length; i++)
		{
			if(front[i].equals(a))
				return i;
		}
		return -1;
	}
	
	public String toString()
	{
		String output = "";
		for(int i = 0; i < front.length; i++)
		{
			output += (String)front[i] + "\n";
		}
		return output;
	}

}
