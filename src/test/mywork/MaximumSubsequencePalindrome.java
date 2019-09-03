package test.mywork;


public class MaximumSubsequencePalindrome {
	
	
	/*
	 * This API will return maximum palindromic subsequence recursively
	 * str :- Resembles here the main string
	 */
	
	public static int MPSPRecursive(String str, int begIndx, int endIndx) {
		
		//No solution
		if (begIndx > endIndx)
			return 0;
		
		//Only one alphabet
		if (begIndx == endIndx)
			return 1;
		
		/*
		 * Here if last alphabet is equal to first index then we can take these 2 elements and work on remaining string
		 * If they are not equal then either the solution should be in Ist substring (0,n-1) or (1,n)
		 */
		if (str.charAt(begIndx) == str.charAt(endIndx))
			return 2 + MPSPRecursive(str, begIndx +1, endIndx-1);
		else 
			return max(MPSPRecursive(str, begIndx, endIndx-1), MPSPRecursive(str, begIndx +1, endIndx));
		
	}
	
	/*
	 * This API will return maximum palindromic subsequence using Dynamic Programming
	 * str :- Resembles here the main string
	 */
	
	public static int MPSPDynamic(String str) {
		
		int length = str.length();
		
		int DPArray[][] = new int[length][length];
		
		for (int i=0; i<length; i++)
			for (int j=0; j<length; j++)
				DPArray[i][j] = 0;
		
		/*
		 * Row of the DPArray represents beginning index of the substring
		 * Column will represent end index
		 */
		
		//For substring of size 1 
		for (int i=0; i<length; i++)
			DPArray[i][i] = 1;
		
		
		//For other sizes of substring
		for (int size= 2 ; size <=length; size++) {
			for (int i=0; i <= length-size; i++) {
				int x = i;
				int y = i + size-1;
				if(str.charAt(x) == str.charAt(y))
					DPArray[x][y] = DPArray[x+1][y-1] + 2;
				else
					DPArray[x][y] = max(DPArray[x][y-1], DPArray[x+1][y]);
			}
		}		
		
		return DPArray[0][length-1];	
	}
	
	/*
	 * This will return bigger integer between 2 integers
	 */
	
	public static int max(int x, int y) {
		
		if (x > y)
			return x;
		return y;
		
	}

	public static void main(String[] args) {
		
		//Assuming that denominations given are in decreasing order
		String str = "ACGTGTCAAAATCG";
		//int Num = MPSPRecursive(str, 0, str.length()-1);
		int Num = MPSPDynamic(str);
		
		System.out.println("Maximum palindrome subsequence for " + str + " is:" + Num);
		
			
	}

}
