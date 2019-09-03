# Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
# https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution(object):
    def letterCombinationsRec(self, digits, str, res):
        if len(digits)==0:
            if str!="":
                res.append(str)
            return
        if not (2<=int(digits[0])<=9):
            self.letterCombinationsRec(digits[1:], str, res)
        else:
            self.letterCombinationsRec(digits[1:], str + chr(3 * (int(digits[0]) - 2) + 97), res)
            self.letterCombinationsRec(digits[1:], str + chr(3 * (int(digits[0]) - 2) + 98), res)
            self.letterCombinationsRec(digits[1:], str + chr(3 * (int(digits[0]) - 2) + 99), res)
            if int(digits[0])==9:
                self.letterCombinationsRec(digits[1:], str + chr(3 * (int(digits[0]) - 2) + 100), res)

    def letterCombinations(self, digits):
        res = []

        if (len(digits)==0):
            return []
        self.letterCombinationsRec(digits, "", res)

        return res