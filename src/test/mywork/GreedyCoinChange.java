package test.mywork;

import java.util.*;

public class GreedyCoinChange {
	

	/*
	 * This API will return minimum number of coins required to make given value.
	 * And will also store the series in prinArr vector
	 * den[] :- Resembles here the denomination array
	 * Num :- represents the value which is to be formed using given denominations
	 */
	public static int greedyCoinChange(int den[], Vector<Integer> printArr, int Num) {
		int count = 0;
		
		for(int i=0; i<den.length; i++) {
			while (Num - den[i] >= 0) {
				count++;
				//System.out.println(i + " " + den[i]);
				printArr.add(den[i]);
				Num = Num - den[i];
				if (Num == 0)
					return count;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		//Assuming that denominations given are in decreasing order
		int den[] = {50,25,10,5,1};
		int Num = 17;
		Vector<Integer> printArr = new Vector<Integer>();
		int minCoinsUsed = greedyCoinChange(den, printArr, Num);
		System.out.println("Minimum number of coins used: " + minCoinsUsed);
		System.out.println("And the series is: " + printArr.toString());

	}

}
