package test.mywork;

import java.io.*;
import java.util.*;

public class NoPrexfixBruteForce2 {

    static boolean isPrefix1(String str1, String str2){
        int l1 = str1.length();
        int l2 = str2.length();
        int i=0;
        while (l1 > 0 && l2 > 0){
            if (str1.charAt(i)!= str2.charAt(i))
            	return false;
            i++;
            l1--;
            l2--;
        }
        
        return true;
    }
    
    static boolean isPrefix(String str1, String str2){
        int l1 = str1.length();
        int l2 = str2.length();
        if (l1<l2)
        	return str2.startsWith(str1);
        else
        	return str1.startsWith(str2);
    }
    
    static void checkPrefix(String str[]){
        if (str.length > 1){
            for(int i=1; i<str.length; i++){
                for (int j=0; j<i;j++){
                    if (isPrefix(str[i], str[j])){
                        System.out.println("BAD SET");
                        System.out.println(str[i]);
                        return;
                    }
                }
            }
        }
        System.out.println("GOOD SET");
    }
    
    public static int[] solve1(int A, int B[]) {
    	int ans[] = new int[B.length];
    	
    	String arr[] = new String[A];
    	for (int i=0; i<A;i++) 
    		arr[i] = Integer.toString(i+1);
    	
    	Arrays.sort(arr);
    	
    	for (int j=0; j<ans.length; j++)
    		ans[j] = Integer.parseInt(arr[B[j]-1]);
    	
    	return ans;
    }

    public static int slove3(int A, int B, int C) {
    	
    	int cnt = 0;
    	if (A==0 && B==0 && C>=0)
    		return 1;
    	if (A<0 || B==0 || C<0)
    		return 0;
    	

    	
    	cnt = cnt + slove3(A-4, B-1, C) + slove3(A-6, B-1, C) + slove3(A, B-1, C) + slove3(A, B-1, C-1);
    	
    	return cnt;
    	
    }

    
 public int slove2 (int A, int B) {
	 if (B%A !=0)
		 return 0;
	 
	 if (B==0)
		 return 1;
	 int x = B/A;
	 
	 int count = 0;
	 for (int i =1; i<=x; i++) {
		 int z = B-A*i;
		 count = count + slove2 (A, z);
	 }
	 
	 return count;
 }
 
 public int solve(int A, int B) {
	 if (B%A !=0)
		 return 0;
	 
	 return slove2(A,B)-1;
 }
    
    public static void main(String[] args) {
        
//        Scanner scanner = new Scanner(System.in);
//        int l = Integer.parseInt(scanner.nextLine());
//
//        String str[] = new String[l];
//
//        for (int i=0; i<l; i++)
//            str[i] = scanner.nextLine();
//        
//        //System.out.println(Arrays.toString(str));
//        
//
//        checkPrefix(str);
    	
    	System.out.println(slove3(6,2,9));

    }
}