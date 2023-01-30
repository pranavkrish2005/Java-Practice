
public class Consecutives {

	public static boolean consecutive(int[] a)
	{
		return consecutive(a,0);	
	}
	
	//helper method goes here
	public static boolean consecutive(int[] a, int i)
	{
		if(a.length - 1 == i)
			return false;
		else if(a[i + 1] == a[i] + 1)
			return true;
		else
			return consecutive(a, i + 1);
		
	}
	


	public static void main(String[] args) {
		int[] a = {2,4,8,3,6,1,5,8,10,2,5,9};  //returns false
		System.out.println(consecutive(a));
		
		int[] b = {7,3,5,1,9,6,8,2,6,7,2,8};   //returns true
		System.out.println(consecutive(b));
		
		int[] c = {7,3,5,1,9,6,8,2,6,9,2,3};  //returns true
		System.out.println(consecutive(c));


	}

}