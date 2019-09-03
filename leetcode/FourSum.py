# Given an array nums of n integers and an integer target, are there elements a, b, c, and d
# in nums such that a + b + c + d = target? Find all unique quadruplets in the array
# which gives the sum of target.
# https://leetcode.com/problems/4sum/

class Solution(object):
    def fourSum(self, nums, target):
        res = set()
        nums.sort()
        ln = len(nums)
        if ln < 4: return res
        i = 0
        while i < (ln - 3):
            l=i+1
            while l <(ln-2):
                j = l + 1
                k = ln - 1
                while (j < k):
                    x = nums[i] + nums[l] + nums[j] + nums[k]
                    if (target == x):
                        res.add((nums[i], nums[l], nums[j], nums[k]))
                        j += 1
                        k -= 1
                    elif (x < target):
                        j+= 1
                    else:
                        k-= 1
                l+=1
            i += 1

        return list(res)