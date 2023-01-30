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
		DListNode temp = new DListNode(element, current, previous);
		previous.setNext(temp);
		current.setPrevious(temp);
		canRemove = true;
	}

	public void set(Object element)
	{
		current.setValue(element);
	}
	
}