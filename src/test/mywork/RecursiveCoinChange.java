package test.mywork;

import java.util.Arrays;

public class RecursiveCoinChange {
	
	private static int maxValue = 100000;
	private static boolean flag = false;
	
	/*
	 * This API will return minimum number of coins required to make given value.
	 * den[] :- Resembles here the denomination array
	 * Num :- represents the value which is to be formed using given denominations
	 */
	
	public static int minCoinChange(int den[], int Num) {
		
		//This is base condition check if Num is 0 then the segment will be skipped and it will simply return Num
		if (Num != 0) {
			//Assuming minimum denomination can be 1 unit, so maximum numbers of coins can be Num
			int result = maxValue;
			for (int i =0; i<den.length; i++) 
			{
				if (Num >=den[i]) {
					int newNum = Num - den[i];
					int temp_res = minCoinChange(den, newNum);
					
					if (result > temp_res+1)
						result = temp_res + 1;
				}
				
			}
			return result;
		}
		else
			return 0;
		
	}
	
	/*
	 * Once we have obtained the minimum no. of coins required, we can use that input to print the series of coin
	 * using below API.This will populate the printArr with series of denominations used for minimum combination
	 * den[] :- Resembles here the denomination array
	 * Num :- represents the value which is to be formed using given denominations
	 * val :- index of printArray where denomination is to be fed
	 * minDen :- Output of API (minCoinChange)
	 */
	
	public static void coinSeries(int den[], int printArr[], int val, int minDen, int Num) {
		
		if(Num==0 || flag==true)
			return;
			
		for (int i =0; i<den.length; i++) 
			
		{
			if (flag==true)
				break;
			if (Num >=den[i] && val<minDen) {
				printArr[val]=den[i];
				int newNum = Num - den[i];
				if (newNum ==0 && val == minDen-1) {
					flag=true;
					return;
					}
				coinSeries(den, printArr, val+1, minDen, newNum);
					
				}
				
			}
		
	}

	public static void main(String[] args) {
		
		//Assuming that denominations given are in decreasing order
		int den[] = {15,9,1};
		int Num = 37;
		
		int minCoinsUsed = minCoinChange(den, Num);
		System.out.println("Minimum number of coins used: " + minCoinsUsed);
		
		//Printing the series
		int printArray[]= new int[minCoinsUsed];
		coinSeries(den, printArray, 0, minCoinsUsed, Num);
		
		System.out.println("And the series is: " + Arrays.toString(printArray));
		
			
	}

}
