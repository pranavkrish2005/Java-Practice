import java.util.Arrays;

public class ArrayExample {
private int[] numbArray;
// 1. Constructs a default array of size 10
public ArrayExample() {
numbArray = new int[10];
numbArray[0] = 1;
numbArray[1] = 3;
numbArray[2] = 7;
numbArray[3] = 19;
numbArray[4] = 15;
numbArray[5] = 19;
numbArray[6] = 7;
numbArray[7] = 3;
numbArray[8] = 19;
numbArray[9] = 48;
}

// 2. Constructs an array of random numbers (0-24) array of size count
public ArrayExample(int count)
{
	int [] arr = new int[count];
	for(int i = 0; i < arr.length; i++)
		arr[i] = (int)(Math.random() * 24) + 1;
}

// 3. This method prints all of the elements of the array in list form
public void display()
{
	for(int x : numbArray)
		System.out.println(x);
}

// 4. This method prints all of the elements in reverse order
public void displayReverse()
{
	for(int i = numbArray.length - 1; i >= 0; i--)
		System.out.println(numbArray.length);
}

// 5. This method calculates and returns the average of all of the elements
// The average of the default array is 14.1
public double average()
{
	double sum = 0;
	for(int x : numbArray)
		sum += x;
	return sum/numbArray.length;
}

// 6. This method returns the maximum value of all of the elements
// The max of the default array is 48.
public int findMax()
{
	int longest = numbArray[0];
	for(int x : numbArray)
		if(longest < x)
			longest = x;
	return longest;
}

// 7. This method returns the index number of the first instance of int lookFor
// returns -1 if not in the list
// ex. Using the default array findIndex(15) will return 4
public int linearSearch(int lookFor)
{
	for(int i = 0; i < numbArray.length; i++)
		if(lookFor == numbArray[i])
			return i;
	return -1;
}
/**
* 8. This method will print the elements and the tally. The list with the
* default constructor will be
* Number Frequency
* 1 1
* 3 2
* 7 2
* 15 1
* 19 3
* 48 1
*/
public void tallyList()
{
	int index = 0;
	int[] toprint = new int[this.findMax() + 1];
	for(int i = 0; i < numbArray.length; i++)
	{
		index = numbArray[i];
		toprint[index]++;
	}
	
	for(int i = 0; i < toprint.length; i++)
		if(toprint[i] != 0)
			System.out.println(i + "\t" + toprint[i]);
}
/**
* 9. This method will print a column of numbers in the original order,
* a column of numbers in reverse order, and the average of the two.
* default constructor will be
* LIST REVERSE AVERAGE
* 1 48 24.5
* 3 19 11.0
* 3 19 11.0
* 7 19 13.0
* 7 15 11.0
* 15 7 11.0
* 19 7 13.0
* 19 3 11.0
* 19 3 11.0
* 48 1 24.5
*/
public void listReverseAvg()
{
	this.sort();
	for(int i = 0; i < numbArray.length; i++)
		System.out.println(numbArray[i] + "\t" + numbArray[numbArray.length - 1 - i] + 
				"\t" + (numbArray[numbArray.length - 1 - i] + numbArray[i]) / 2.0);
}
// 10. This method will sort the array in ascending order
//
public void sort()
{
/*
 * Bubble sort : works by comparing pairs of numbers. We check and switch the consecutive numbers
 * forever until they are in the right sort order. At the end of the first check, we can be sure that
 * the last number in the array is the biggest number. At the end of the second, the last two are the
 * greatest number and so on. After n number of passes, last n numbers are in the correct order. We decrease the 
 * search one by one for every check until we get the right order. We need only array.length - 1; passes to 
 * do the right ascending order.
 */
	int n = numbArray.length;
	for(int i = 0; i < n -1; i++)
		for(int j = 0; j < n - 1 - i; j++)
			if(numbArray[j] > numbArray[j + 1])
			{
				int temp = numbArray[j];
				numbArray[j] = numbArray[j + 1];
				numbArray[j  + 1] = temp;
			}
	System.out.println(Arrays.toString(numbArray));
}

// 11. Binary Search.
// This method returns the index number of the first instance of int lookFor and
// returns -1 if not in the list. The Array must be sorted to use the Binary search.
// ex. Using the default array findIndex(15) will return 4
public int binarySearch(int lookFor)
{
	/*
	 * Binary Search : Big O notation is the runtime complexity of the code. If n is the number of elements in an array,
	 * then the runtime complexity could be something like for example O(n) meaning the runtime complexity is n.
	 * Lesser the complexity, more efficient the code. It can be only used if array is sorted.
	 * 1. Define variables for bottom and top INDEX. Let the number to search be value.
	 * 2. While bottom <= top
	 * 		define middle as middle of top and bottom.
	 * 		if value = value at middle index
	 * 			return middle index.
	 * 		if value < middle# redefine top as middle - 1.
	 * 		else redefine bottom as middle + 1.
	 * 3. loop ends without return, then return "value not on the list".
	 * The runtime complexity for an array with n length, In a linear search it is going to take O(n),
	 * in a binary search, the complexity is only O(log(n)), which is log2(n).
	 */
	int bottom = 0, top = numbArray.length - 1;
	while(bottom <= top)
	{
		int middle = bottom + (top - bottom) / 2;
		
		if(numbArray[middle] == lookFor)
			return middle;
		if(lookFor < numbArray[middle])
			top = middle - 1;
		else
			bottom = middle + 1;
	}
	return - 1;
}

//12. Write a tester that will create a random array of size 50
//and test all of these methods
public static void main(String[] args)
{
	ArrayExample one = new ArrayExample();
	ArrayExample two = new ArrayExample(50);
	
	one.display();
	one.displayReverse();
	System.out.println(one.average());
	System.out.println(one.findMax());
	System.out.println(one.linearSearch(19));
	one.tallyList();
	one.listReverseAvg();
	one.sort();
	System.out.println(one.binarySearch(19));
}

}