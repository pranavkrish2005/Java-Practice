public class DListIterator {
	private DListNode current;
	private DListNode previous;
	private DLinkedList myList;
	private boolean canRemove; // for remove() method. true if OK to call

// remove()

	public DListIterator(DLinkedList list)
	{
		myList = list;
		current = list.getFirstNode();
		previous = list.getFirstNode();
		canRemove = true;
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
		return current.getNext();
	}

	public DListNode getCurrent() {
		return current;
	}

	public void setCurrent(DListNode current) {
		this.current = current;
	}

	public DListNode getPrevious() {
		return previous;
	}

	public void setPrevious(DListNode previous) {
		this.previous = previous;
	}

	public Object previous()
	{
		return current.getPrevious();
	}

	public DLinkedList getMyList() {
		return myList;
	}

	public void setMyList(DLinkedList myList) {
		this.myList = myList;
	}

	public void remove()
	{
		if(current.equals(previous))
		{
			myList.setFirstNode(myList.getFirstNode().getNext());
		}
		
		if(canRemove)
		{
			previous.setNext(current.getNext());
			current.setPrevious(previous.getPrevious());
		}
	}

	public void add(Object element)
	{
		DListNode temp = new DListNode(element, current.getNext(), current);
		previous.getNext().setNext(temp);
		current.getNext().setPrevious(temp);
		canRemove = true;
	}

	public void set(Object element)
	{
		current.setValue(element);
	}
	
}
