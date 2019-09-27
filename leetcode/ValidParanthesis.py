# Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
# https://leetcode.com/problems/valid-parentheses/

class Solution(object):
    def isValid(self, s):
        stack = []
        l = len(s)
        if l==0:
            return True
        for c in s:
            if c== '(' or c== '{' or c== '[':
                stack.append(c)
            elif c== ')' or c== '}' or c== ']':
                if len(stack) ==0:
                    return False
                x=stack[-1]
                if (x=='(' and c==')') or (x=='[' and c==']') or (x=='{' and c=='}'):
                    stack.pop()
                else:
                    return False
        if len(stack) == 0:
            return True
        else:
            return False
