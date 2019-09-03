# Write a function to find the longest common prefix string amongst an array of strings.
# https://leetcode.com/problems/longest-common-prefix/

class Solution(object):
    def getPrefix(self, left, right):
        res = ""
        ln = min(len(left), len(right))
        i=0
        while(i<ln):
            if left[i] != right[i]:
                return left[:i]
            i+=1
        return left[:ln]


    def longestCommonPrefix1(self, strs, st, end):
        if st==end:
            return strs[st]
        mid = (st+end)/2
        left = self.longestCommonPrefix1(strs, st, mid)
        right = self.longestCommonPrefix1(strs, mid+1, end)
        return self.getPrefix(left, right)

    def longestCommonPrefix(self, strs):
        if (strs==None or len(strs)==0): return ""
        return self.longestCommonPrefix1(strs, 0, len(strs)-1)

