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
			this.doubleCapacity();
		arrayQ[count] = obj;
		count = (count + 1) % arrayQ.length;
	}

	public Object remove()
	{
		Object obj = arrayQ[front];
		arrayQ[front] = null;
		front = (front + 1) % arrayQ.length;
		return obj;
	}

	public boolean isEmpty()
	{
		return front == count;
	}
	
	public boolean isfull()
	{
//		for(int i = 0; i < arrayQ.length; i++)
//			if(arrayQ[i] == null)
//				return false;
//		return true;
		return (count + 1) % arrayQ.length == front;
	}

	public void doubleCapacity()
	{
		Object[] temp = new Object[arrayQ.length * 2];
		int f = front;
		for(int i = 0; i < arrayQ.length - 1; i++)
			temp[i] = this.remove();
		
		arrayQ = temp;
		int num = 0;
		for(int i = 0; i < arrayQ.length - 1; i++)
			if(arrayQ[i] != null)
				num++;
		count = num;
		front = 0;
	}
	
	public String toString()
	{
//		String output = "";
//		if(front < count)
//		{
//			for(int i = front; i < count; i++)
//				output += arrayQ[i] + ", ";
//			return output;
//		}
//		else
//		{
//			for(int i = front; i < count + arrayQ.length; i++)
//				output += arrayQ[i % arrayQ.length] + ", ";
//			return output;
//		}
		String output = "";
		for(int i = 0; i < arrayQ.length; i++)
			output += arrayQ[i] + " ";
		return output;
		
	
	}
}