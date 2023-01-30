import java.util.Arrays;
public class ArrayFunHouseTwoRunner
{
	public static void main( String args[] )
	{
		int[] one = {1,2,3,4,5,6,7,8,9,10};
		int[] two = {1,2,3,9,11,20,30};
		int[] three = {9,8,7,6,5,4,3,2,0,-2};
		int[] four = {3,6,9,12,15,18,21,23,19,17,15,13,11,10,9,6,3,2,1,0};
		
		System.out.println(ArrayFunHouseTwo.goingUp(one));
		System.out.println(ArrayFunHouseTwo.goingDown(three));
		System.out.println(Arrays.toString(ArrayFunHouseTwo.getCountValuesBiggerThanX(two, 3, 3)));
	}
}