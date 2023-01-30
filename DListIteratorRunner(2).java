
public class DListIteratorRunner
{
	public static void main(String args[])
	{
		DListNode temp1 = new DListNode("dog", null, null);
		DListNode temp2 = new DListNode("cat", null, null);
		DListNode temp3 = new DListNode("mouse", null, null);
		DLinkedList one = new DLinkedList();
		temp1.setNext(temp2);
		temp2.setNext(temp3);
		temp3.setPrevious(temp2);
		temp2.setPrevious(temp1);
		one.setFirstNode(temp1);
		one.setLastNode(temp3);
		DListIterator two = new DListIterator(one);
	}
}
