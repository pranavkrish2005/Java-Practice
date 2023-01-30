
public class LoopingFun
{
	public static void primeNumberList(int n)
	{
		String str = "2";
		for(int i = 3; i <= n; i++)
		{
			if(isPrime(i))
				str += ", " + Integer.toString(i);
		}
		System.out.println(str);
	}
	
	public static boolean isPrime(int n)
	{
		int nearnum = (int)Math.sqrt(n) + 1;
		for(int i = 2; i < nearnum; i++)
		{
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
	public static int sumInts(int n)
	{
		return (n * (n + 1)) / 2;
	}
	
	public static long factorial(int n)
	{
		int product = 1;
		for(int i = 0; i < n; i++)
			product *= (n - i);
		return product;
	}
	
	public static boolean isEven(int n)
	{
		if(n % 2 == 0)
			return true;
		return false;
	}
	
	public static int lcm(int a, int b)
	{
		int lowcommondnum = 1;
		int count = 0;
		while( lowcommondnum % a != 0)
		{
			count++;
			lowcommondnum = b * count;
		}
		
		return lowcommondnum;
	}
	
	public static int gcf(int a, int b)
	{
		for(int i = a - 1; i >= 0; i--)
		{
			if(a % i == 0 && b % i == 0)
				return i;
		}
		return 1;
	}
	
	public static int sumDigits(int n)
	{
		int sum = 0;
		String str = Integer.toString(n);
		for(int i = 0; i < str.length(); i ++)
		{
			sum += Integer.parseInt(str.substring(i, i + 1));
		}
		return sum;
	}
	
	public static int reverseNum(int n)
	{
		String str = Integer.toString(n);
		int finstr = 0;
		for(int i = str.length() - 1; i >= 0; i--)
		{
			finstr = (finstr * 10) + Integer.parseInt(str.substring(i , i + 1));
		}
		return finstr;
	}
	
	public static void coinTrials(int n)
	{
		int rand = 0;
		int heads = 0, tails = 0;
		for(int i = 0; i < n; i++)
		{
			rand = (int)(Math.random() * 2);
			if(rand == 0)
				heads++;
			else
				tails++;
		}
		System.out.println("Heads : " + heads + "\nTails : " + tails);
	}
	
	public static int countDigits(int n)
	{
		String str = Integer.toString(n);
		return str.length();
	}
	
	public static void fibonacci(int n)
	{
		int temp;
		int nummin1 = 1;
		int nummin2 = 1;
		int num = 0;
		String str = "1 1 ";
		for(int i = 3; i < n; i++)
		{
			num = nummin1 + nummin2;
			str += Integer.toString(num) + " ";
			temp = nummin1;
			nummin1 = num;
			nummin2 = temp;
		}
		System.out.println(str);
	}
	
	public static boolean isPerfect(int n)
	{
		int sum = 0;
		for(int i = 1; i <= n; i++)
		{
			if(n % i == 0)
				sum += n;
		}
		if(sum == n)
			return true;
		else
			return false;
	}
	
	public static String printFactors(int n)
	{
		String str = "";
		for(int i = 1; i <= n; i++)
		{
			if(n % i == 0)
				str += Integer.toString(i) + " ";
		}
		return str;
	}
	
	public static void primeFactorization(int n)
	{
		int count = 0;
		for(int i = 2; i < n; i++)
		{
			if(isPrime(i) && n % i == 0)
				System.out.print(i + " ");
			count++;
			if((double)(n / (i * count)) % i == 0)
				i--;
		}
	}
	
	public static int binary(int n)
	{
		int bin = 0;
		for(int i = 8; i >= 0; i--)
		{
			if(n >= Math.pow(2, i))
			{
				bin = (bin * 10) + 1;
				n -= Math.pow(2, i); 
			}
			else
				bin = (bin * 10);
			
		}
		return bin;
	}
	
	public static void pyramid(int n)
	{
		for(int i = 0; i < n; i++)
		{
			for(int h = 0; h < n - i - 1; h++)
				System.out.print(" ");
			for(int j = 0; j <= i * 2; j++)
				System.out.print("*");
			for(int h = 0; h < n - i - 1; h++)
				System.out.print(" ");
			System.out.println();
		}
	}
	
	public static void main(String args[])
	{
			System.out.println("#15 - Binary of 122:  " + binary (122));
			System.out.println("\n#10 - Coin trials:  " );
			coinTrials(100);
			System.out.println("\n#11 - CountDigits of 23456:  " + countDigits (23456));
			System.out.println("\n#3 - Factorial of 10:  " + factorial(10));
			System.out.println("\n#12 - Fibonacci of 10:  " );
			fibonacci (10);
			System.out.println("\n\n#7 - gcf of 32 & 80:  " + gcf(32,80) );
			System.out.println("\n#4 - isEven of 62875:  " + isEven (62875));
			System.out.println("#4 - isEven of 62878:  " + isEven (62878));
			System.out.println("\n#13 - isPerfect of 28:  " + isPerfect (28));
			System.out.println("#13 - isPerfect of 30:  " + isPerfect (30));
			System.out.println("\n#5 - isPrime of 30:  " + isPrime (30));
			System.out.println("#5 - isPrime of 31:  " + isPrime (31));
			System.out.println("\n#6 - lcm of 32 & 80:  " + lcm(32,80) );
			System.out.println("\n\n#1 - Prime number list for 100:  " );
			primeNumberList(100);
			System.out.println("\n\n#9 - Reverse of 1358642:  " + reverseNum(1358642));
			System.out.println("\n#16 - Pyramid - 6 high:  " );
			pyramid (6);
			System.out.println("\n#8 - sum digits of 24678:  " + sumDigits (24678));
			System.out.println("\n#2 - sum of ints up to 10:  " + sumInts (10));
//			For some reason, after the primeFactorization method, nothing runs.
//			So had to put it at last.
			System.out.println("\n#14 - Prime Factorization of 112:  ");
			primeFactorization (112);
	}
}