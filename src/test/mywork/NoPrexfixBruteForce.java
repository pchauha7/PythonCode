package test.mywork;

import java.io.*;
import java.util.*;

public class NoPrexfixBruteForce {

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
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int l = Integer.parseInt(scanner.nextLine());

        String str[] = new String[l];

        for (int i=0; i<l; i++)
            str[i] = scanner.nextLine();
        
        //System.out.println(Arrays.toString(str));
        

        checkPrefix(str);

    }
}