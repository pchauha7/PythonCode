# You are given a string, s, and a list of words, words, that are all of the same length.
# Find all starting indices of substring(s) in s that is a concatenation
# of each word in words exactly once and without any intervening characters.
# https://leetcode.com/problems/substring-with-concatenation-of-all-words/

class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """

        if len(words) == 0 or len(words[0]) == 0:
            return []
        k = len(words[0])
        ln = len(s)
        if ln < k * len(words) or ln == 0:
            return []
        i = 0
        output = []
        while (i < ln):
            # Set = set(words)
            word1 = words[:]
            if s[i:i + k] not in words:
                i = i + 1
            else:
                x = i
                while i < ln and (s[i:i + k] in word1):
                    word1.remove(s[i:i + k])
                    i += k
                if len(word1) == 0:
                    output.append(x)
                i = x + 1

        return output