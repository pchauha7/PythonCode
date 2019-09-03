package test.mywork;

import java.util.Stack;

public class BracketMatching {
	
    
	static boolean isMatchingPair(char character1, char character2) 
    { 
       if (character1 == '(' && character2 == ')') 
         return true; 
       else if (character1 == '{' && character2 == '}') 
         return true; 
       else if (character1 == '[' && character2 == ']') 
         return true; 
       else
         return false; 
    } 
      
    static boolean areParenthesisBalanced(String exp) 
    { 
    	Stack<Character> st = new Stack<Character>(); 
       
       for(int i=0;i<exp.length();i++) 
       { 
            
          if (exp.charAt(i) == '{' || exp.charAt(i) == '(' || exp.charAt(i) == '[') 
            st.push(exp.charAt(i)); 
       
          if (exp.charAt(i) == '}' || exp.charAt(i) == ')' || exp.charAt(i) == ']') 
          { 
                   
             if (st.isEmpty()) 
               { 
                   return false; 
               }  
       
             else if ( !isMatchingPair(st.pop(), exp.charAt(i)) ) 
               { 
                   return false; 
               } 
          } 
            
       } 
                  
       if (st.isEmpty()) 
         return true; 
       else
         {   
             return false; 
         }  
    }  
    
    static String[] braces(String[] values) {
    	
    	String ans[] = new String[values.length];
    	
    	for (int i=0; i< ans.length; i++) {
    		if (areParenthesisBalanced(values[i]))
    			ans[i]="YES";
    		else
    			ans[i]="NO";
    	}
    	
    	return ans;
    	
    }
      
    /* UTILITY FUNCTIONS */
    /*driver program to test above functions*/
    public static void main(String[] args)  
    { 
        //char exp[] = {'{','(',')','}','[',']'}; 
    	String exp ="{{()[}]}";
             
    } 

}
