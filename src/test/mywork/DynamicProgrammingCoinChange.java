package test.mywork;

public class DynamicProgrammingCoinChange {
	
	
	/*
	 * This API will return minimum number of coins required to make given value.
	 * den[] :- Resembles here the denomination array
	 * n :- no. of denominations in the array
	 * Num :- represents the value which is to be formed using given denominations
	 */
	
	public static int minCoinChange(int den[], int n, int Num) {
		
		//This table contains all the minimum combination from 0 to Num.
		//So, after execution dpTable[Num] should have result
		int dpTable[] = new int[Num+1];
		
		//For Num = 0, no denomination is required
		dpTable[0] = 0;
		
		//Feeding from Num=1 to Num =Num in the Array
		for(int i= 1; i< Num+1; i++) {
			//For others, assuming that maximum solution, that would be Num no. of coins
			dpTable[i] = Num;
			for(int j=n-1; j>=0; j--) {
				if (i>=den[j]) {
					int temp_res = dpTable[i-den[j]];
					if (temp_res+1 < dpTable[i])
						dpTable[i] = temp_res+1;
						
				}
			}
			System.out.println(i+" --> "+dpTable[i]);
		}
		
		return dpTable[Num];
		
	}
	

	public static void main(String[] args) {
		
		//Assuming that denominations given are in increasing order
		int den[] = {1,9,15};
		int Num = 37;
		
		int minCoinsUsed = minCoinChange(den, den.length, Num);
		System.out.println("Minimum number of coins used: " + minCoinsUsed);
		
			
	}

}
