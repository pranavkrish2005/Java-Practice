import java.util.Arrays;

public class StringTo2DIntArray {

	// #1 - splitter to Array of Strings(takes String object)
	public static String[] splitIt(String word)
	{
		String[] temp = word.split(" ");
		return temp;
	}
	
	
	// #2 - Method takes an array of Strings and converts
	//      to array of ints(takes String[] parameter)
	public static int[] stringToInt(String[] arr)
	{
		int[] a = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
			a[i] = Integer.parseInt(arr[i]);
		return a;
	}
	// #3 Method takes oneD int array and uses it to 
	//    to populate a twoD int array(takes row, col, int[])
	// ** If the oneD array has fewer elements, stop populating
	//    the twoD array when the oneD runs out.
	//    If the oneD array has more elements than the twoD,
	//    then stop populating when the twoD is full
	public static int[][] oneToTwo(int r, int c, int[] arr)
	{
		int[][]a = new int[r][c];
		int count = 0;
		for(int i = 0; i < a.length; i++)
			for(int j = 0; j < a[i].length; j++)
				if(count < arr.length)
					a[i][j] = arr[count++];
		return a;
	}
	
	// #4 - Extension: In the example below, the process
	//      required three method calls:
	//      	1. splitIt(numList)
	//			2. stringToInt(one)
	//			3. oneToTwo(3, 4, two)
	//   	Is it possible to change the implementation
	//  	above so that only one method call is needed?
	//  	If so, then do it.  If not, explain why not.
	
	
	public static void main(String[] args) {
		String numList = "2 5 8 5 3 78 9 -1 3 6 9 0";
		String[] one = splitIt(numList);
		System.out.println(Arrays.toString(one) + "\n");
		// be careful, this is still an array of Strings
		
		int[] two = stringToInt(one);
		System.out.println(Arrays.toString(two)+ "\n");
		// they look the same, but this is an array of ints
		
		int[][] three = oneToTwo(3, 4, two);
		int[][] four = oneToTwo(4, 4, two);
		int[][] five = oneToTwo(3, 2, two);
		System.out.println(Arrays.deepToString(three));
		System.out.println(Arrays.deepToString(four));
		System.out.println(Arrays.deepToString(five));


	}

}

//[2, 5, 8, 5, 3, 78, 9, -1, 3, 6, 9, 0]
//
//[2, 5, 8, 5, 3, 78, 9, -1, 3, 6, 9, 0]
//
//[[2, 5, 8, 5], [3, 78, 9, -1], [3, 6, 9, 0]]
//[[2, 5, 8, 5], [3, 78, 9, -1], [3, 6, 9, 0], [0, 0, 0, 0]]
//[[2, 5], [8, 5], [3, 78]]