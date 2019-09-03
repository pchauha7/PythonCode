# Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
# Return the sum of the three integers. You may assume that each input would have exactly one solution.
# https://leetcode.com/problems/3sum-closest/

class Solution(object):
    def threeSumClosest(self, nums, target):
        nums.sort()
        ln = len(nums)
        if ln < 3: return 0
        trgtNow = nums[0]+nums[1]+nums[2]
        if trgtNow==target: return target
        i = 0
        while i < (ln - 2):
            j = i + 1
            k = ln - 1
            while (j < k):
                z = nums[i] + nums[j] + nums[k]
                if (target == z):
                    return target
                elif (z<target):
                    if (target-z) < abs(trgtNow-target):
                        trgtNow=z
                    j+=1
                else:
                    if (z-target) < abs(trgtNow-target):
                        trgtNow=z
                    k-=1
            i += 1

        return trgtNow