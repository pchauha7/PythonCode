package test.mywork;

import java.util.Stack;

class LongestValidParentEfficient {

    public int longestValidParentheses(String s) {
        int count = 0;
        int left = 0;
        int right = 0;

        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='(')
                left++;
            else
                right++;
            if (right==left)
                count = Math.max(count, left*2);
            else if (left>right)
                right = left = 0;
        }
        right = left = 0;
        for (int i = s.length()-1; i>=0; i--){
            if (s.charAt(i)=='(')
                left++;
            else
                right++;
            if (right==left)
                count = Math.max(count, left*2);
            else if (left<right)
                right = left = 0;
        }
        return count;
    }
}