# Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
# Find all unique triplets in the array which gives the sum of zero.
# https://leetcode.com/problems/3sum/

class Solution(object):
    def threeSum(self, nums):
        res = set()
        nums.sort()
        ln = len(nums)
        if ln < 3: return res
        i = 0
        while i < (ln - 2):
            j = i + 1
            x = nums[i] * -1
            k = ln - 1
            while (j < k):
                if (x == (nums[j] + nums[k])):
                    res.add((nums[i], nums[j], nums[k]))
                    j += 1
                    k -= 1
                elif (x < (nums[j] + nums[k])):
                    k -= 1
                else:
                    j += 1
            i += 1

        return list(res)