package test.mywork;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class FirstReverse2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		
		String word[] = str.split(" ");
		word[word.length-1] = word[word.length-1].substring(0, word[word.length-1].length()-1);
		System.out.println(Arrays.toString(word));
		
		HashSet<String> set = new HashSet<String>();
		
		set.add(word[0]);
		boolean flag = false;
		 for (int i= 1; i< word.length; i++) {
			 String revStr = reverse(word[i]);
			 if (set.contains(revStr)) {
				 System.out.println(revStr);
				 flag =true;
				 break;
			 }
			 else
				 set.add(word[i]);
				 
		 }
		
		if (flag==false)
			System.out.println("$");

	}
	
	public static String reverse(String input) {
		
		StringBuilder input1 = new StringBuilder(); 
		  
        input1.append(input);
        
 
        input1 = input1.reverse(); 

		return input1.toString();
	}
	
	

}
