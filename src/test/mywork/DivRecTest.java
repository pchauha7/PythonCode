package test.mywork;

import java.util.Arrays;

class DivRecTest { 
	static int count = 0;
    
	static int NoOfComb(int a[], int Num, int index, int div) {
		int n = a.length;
		if(index<n) {
			for(int i=index;i<n;i++) {
				int finalNum =Num*10 + a[i];
				if(finalNum%div==0) {
					count++;
					System.out.print(finalNum + " ");
				}
				if(i+1<n)
					NoOfComb(a,finalNum, i+1,div);
			}
		}
			
		return count;
	}
	
	static int SumOfComb(int a[], int div) {
		int n = a.length;
		int B[] = new int[div];
		B[0]++;
		int s=0;
		System.out.println(Arrays.toString(B));
		for (int i=0;i<n;i++) {
			s= (s+a[i])%div;
			B[s]++;
		}
		System.out.println(Arrays.toString(B));
		int ans =0;
		for (int i=0;i<n;i++) {
			ans= ans + B[i]*(B[i]-1)/2;
		}
		return ans;
	}	
  
    // Driver Code 
    public static void main(String args[]) 
    { 
        
        int a[] = { 4, 6, 8, 4, 2};
  
        // quantum time of each process 
        int div = 6; 
        
       //int res = NoOfComb(a,0, 0,div);
       int res = SumOfComb(a,div);
       System.out.println();
       System.out.print(res);
        
            } 
} 