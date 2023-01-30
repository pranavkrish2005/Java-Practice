public class DLinkedList {
	private DListNode firstNode;
	private DListNode lastNode;
	
	/**
	 * Construct an empty list
	 */
	
	public DLinkedList() {
		firstNode = null;
		lastNode = null;
	}
	

/**
* Returns true if the list contains no elements
*/
	public boolean isEmpty()
	{
		if(firstNode == null && lastNode == null)
			return true;
		return false;
	}

/**
* Inserts the argument as the first element of this list.
*/
	public void addFirst(Object o)
	{
		DListNode temp = new DListNode(o, firstNode, null);
		firstNode = temp;
		DListNode l = lastNode;
		while(l.getPrevious() != null)
		{
			l = l.getPrevious();
		}
		l.setPrevious(temp);
	}

/**
* Inserts the argument as the last element of this list.
*/

	public void addLast(Object o)
	{
		DListNode temp = new DListNode(o, null, lastNode);
		lastNode = temp;
		DListNode l = firstNode;
		while(l.getNext() != null)
		{
			l = l.getNext();
		}
		l.setNext(temp);
	}

/**
* Removes and returns the first element of this list.
*/
	public Object removeFirst()
	{
		Object temp = firstNode.getValue();
		firstNode = firstNode.getNext();
		firstNode.getNext().setPrevious(null);
		return temp;
	}

/**
* Removes and returns the last element of this list.
*/
	public Object removeLast()
	{
		Object temp = lastNode.getValue();
		lastNode = lastNode.getPrevious();
		lastNode.setNext(null);
		return temp;
	}

/**
* Returns a String representation of the list.
*/
	public String toString()
	{
		String output = "";
		DListNode first = firstNode;
		while(first != null)
		{
			output += first.getValue() + "\n";
			first = first.getNext();
		}
		return output;
	}

/**
* Returns the number of elements in the list as an int.
*/
	public int size()
	{
		int count = 0;
		DListNode first = firstNode;
		while(first != null)
		{
			count++;
			first = first.getNext();
		}
		return count;
	}

/**
* Removes all of the elements from this list.
*/
	public void clear() 
	{
		firstNode = null;
		lastNode = null;
	}
	
	

	public DListNode getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(DListNode firstNode) {
		this.firstNode = firstNode;
	}

	public DListNode getLastNode() {
		return lastNode;
	}

	public void setLastNode(DListNode lastNode) {
		this.lastNode = lastNode;
	}

/**
* Returns a DListIterator.
*/
	public DListIterator iterator()
	{
		return new DListIterator(this);
	}
}