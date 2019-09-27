package test.mywork;

import java.util.*;

class LongestValidParenthesis {

    public boolean isValid (String s){
        Stack<Character> stk = new Stack<>();
        int i =0;
        while (i<s.length()){

            if (s.charAt(i)=='(')
                stk.push('(');
            else if (stk.size()>0 && stk.peek() =='(')
                stk.pop();
            else
                return false;
            i++;
        }
        return stk.empty();
    }

    public int longestValidParentheses(String s) {
        int count = 0;
        int k =2;
        while (k<=s.length()){
            for (int i=0; i<=s.length() -k;i++){
                if (isValid(s.substring(i,i+k))) {
                    count = k;
                    break;
                }
            }
            k+= 2;
        }

        return count;
    }
}