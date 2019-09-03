package test.mywork;

import java.util.Arrays;
import java.util.Scanner;

public class FirstReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		
		String word[] = str.split(" ");
		word[word.length-1] = word[word.length-1].substring(0, word[word.length-1].length()-1);
		System.out.println(Arrays.toString(word));
		
		String revStr = reverse(str.substring(0, str.length()-1));
		System.out.println(revStr);
		
		
		String wordRev[] = revStr.split(" ");
		System.out.println(Arrays.toString(wordRev));
		
	    String wordRev1[] = new String[wordRev.length];
	    
	    for (int i= 0; i< wordRev1.length; i++)
	    	wordRev1[i]=wordRev[wordRev1.length-i-1];
		
		boolean flag = false;
		for (int i=0; i<word.length-1; i++) {
			if(flag ==true)
				break;
			for (int j=i+1; j<word.length; j++) {
				if(word[i].equals(wordRev1[j])) {
					System.out.println(word[i]);
					flag = true;
					break;
				}
			}
		}
		
		if (flag==false)
			System.out.println("$");

	}
	
	public static String reverse(String input) {
		
		StringBuilder input1 = new StringBuilder(); 
		  
        input1.append(input);
        System.out.println(input);
        
 
        input1 = input1.reverse(); 
        System.out.println(input1);

		return input1.toString();
	}
	
//	public static String reverse(String input) {
//		String res = "";
//		for (int i=0; i<res.length(); i++)
//			res = String.valueOf(input.charAt(i)) + res;
//		return res;
//	}
	

}
