public class CircularArrQueue {
	private Object[] arrayQ;
	private int front;
	private int count;

	public CircularArrQueue(int n)
	{
		arrayQ = new Object[n];
		front = 0;
		count = 0;
	}

	public void add(Object obj)
	{
		if(this.isfull())
		{
			this.doubleCapacity();
		}
		arrayQ[count] = obj;
		count = (count + 1) % arrayQ.length;
	}

	public Object remove()
	{
		Object obj = arrayQ[front];
		front = (front + 1) % arrayQ.length;
		return obj;
	}

	public boolean isEmpty()
	{
		return front == count;
	}
	
	public boolean isfull()
	{
		return (count + 1) % arrayQ.length == front;
	}

	public void doubleCapacity()
	{
		Object[] temp = new Object[arrayQ.length * 2];
		for(int i = 0; i < arrayQ.length - 1; i++)
			temp[i] = this.remove();
		arrayQ = temp;
		count = count - front;
		front = 0;
	}
	
	public String toString()
	{
		String output = "";
		if(front < count)
		{
			for(int i = front; i < count; i++)
				output += arrayQ[i] + ", ";
			return output;
		}
		else
		{
			for(int i = front; i < count + arrayQ.length; i++)
				output += arrayQ[i % arrayQ.length] + ", ";
			return output;
		}
	}
}