
public class DLinkedListRunner
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
		System.out.println(one);
		
		System.out.println("Testing add : ");
		one.addFirst("deer");
		one.addLast("lion");
		System.out.println(one);
		
		System.out.println("Testing remove : ");
		one.removeFirst();
		one.removeLast();
		System.out.println(one);
		
		System.out.println("Test other methods : ");
		System.out.println(one.size());
		one.clear();
		System.out.println(one);
	}
}
