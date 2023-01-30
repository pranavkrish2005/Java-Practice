public class DListIterator {
	private DListNode current;
	private DListNode previous;
	private DLinkedList myList;
	private boolean canRemove; // for remove() method. true if OK to call

// remove()

	public DListIterator(DLinkedList list)
	{
		myList = list;
		current = null;
		previous = null;
		canRemove = false;
	}

	public String toString()
	{
		return current.getValue() + "";
	}

	public boolean hasPrevious()
	{
		if(current.getPrevious() != null)
			return true;
		return false;
	}

	public boolean hasNext()
	{
		if(current.getNext() != null)
			return true;
		return false;
	}

	public Object next()
	{
		previous = current;
		return current.getNext();
	}

	public Object previous()
	{
		previous = current;
		return current.getPrevious();
	}

	public void remove()
	{
		if(canRemove)
		{
			previous.setNext(current.getNext());
			current.setPrevious(previous.getPrevious());
		}
	}

	public void add(Object element)
	{
		
	}

	public void set(Object element)
	{
		
	}
	
}