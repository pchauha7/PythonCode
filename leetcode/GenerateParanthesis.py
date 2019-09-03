# Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
# https://leetcode.com/problems/generate-parentheses/

class Solution(object):
    def validateAPI(self, str, chr, stack, num, res):
        if num==1:
            if (chr==')' and len(stack)==1):
                res.append(str+chr)
                stack.pop()
            return
        if (chr==')' and len(stack)==0):
            return
        str = str+chr
        if (chr==')'):
            stack.pop()
        else:
            stack.append(chr)

        self.validateAPI(str, "(", stack[:], num-1, res)
        self.validateAPI(str, ")", stack[:], num-1, res)

    def generateParenthesis(self, n):
        num = 2*n - 1
        res = []
        if n>0:
            self.validateAPI ("(", "(", ["("], num, res)
            self.validateAPI("(", ")", ["("], num, res)
        return res
