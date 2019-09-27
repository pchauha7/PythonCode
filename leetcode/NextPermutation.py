class Solution(object):
    def nextPermutation(self, nums):
        i = len(nums) -1
        while i>0:
            if nums[i-1] < nums[i]:
                j = i
                k=i
                while j < len(nums):
                    if (nums[i-1]< nums[j]< nums[k]):
                        k=j
                    j+=1
                nums[i-1], nums[k] = nums[k], nums[i-1]
                break
            i-=1

        swapped = True
        while swapped:
            swapped = False
            for x in range(i,len(nums) - 1):
                if nums[x] > nums[x + 1]:
                    nums[x], nums[x + 1] = nums[x + 1], nums[x]
                    swapped = True


x = Solution()
print x.nextPermutation([2,3,1])