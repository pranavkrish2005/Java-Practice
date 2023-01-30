public class DListIteratorRunner
{
	public static void main(String args[])
	{
		DListNode temp1 = new DListNode("cat", null, null);
		DListNode temp2 = new DListNode("dog", null, null);
		DListNode temp3 = new DListNode("mouse", null, null);
		DListNode temp4 = new DListNode("snake", null, null);
		DLinkedList one = new DLinkedList();
		temp1.setNext(temp2);
		temp2.setNext(temp3);
		temp3.setNext(temp4);
		temp4.setPrevious(temp3);
		temp3.setPrevious(temp2);
		temp2.setPrevious(temp1);
		one.setFirstNode(temp1);
		one.setLastNode(temp4);
		System.out.println(one.toString());
		
		DListIterator two = new DListIterator(one);
		
		System.out.println("Testing remove : ");
		while(two.getCurrent() != null)
		{
			if(two.getCurrent().getValue().equals("dog"))
			{
				two.remove();
				break;
			}
			
			two.setPrevious(two.getCurrent());
			two.setCurrent(two.getCurrent().getNext());
		}
		
		System.out.println(one);
		
		System.out.println("Testing add : ");
		DListIterator three = new DListIterator(one);
		while(three.getCurrent() != null)
		{
			if(((String)three.getCurrent().getValue()).compareTo("donkey") > 0)
			{
				three.add("doney");
				break;
			}
			three.setPrevious(three.getCurrent());
			three.setCurrent(three.getCurrent().getNext());
		}
		System.out.println(one.toString());
	}
}
