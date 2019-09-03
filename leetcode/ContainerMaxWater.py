# Container With Most Water
# https://leetcode.com/problems/container-with-most-water/

import math

def maxArea(height):
        maxHeight = 0
        i = 0
        j = len(height) - 1
        while(i<j):
            x = min(height[i], height[j])*(j-i)
            if (maxHeight<x):
                maxHeight = x
            if (height[i]<height[j]):
                i+=1
            else:
                j-=1
        return maxHeight

print (maxArea([1,8,6,2,5,4,8,3,7]))