def solve(N, profit, l, r):
    lst = []
    res = []
    for i in range(N):
        lst.append(profit[i])

    lst.sort()

    for i in range(len(l)):
        j = searchInsert(lst,l[i])
        k = searchInsert(lst,r[i])

        if (lst[k]==r[i]):
            k+=1

        if (k-j >0):
            res.append(k-j)
        else:
            res.append(0)

    return res

def searchInsert(nums, target):
    l = 0
    r = len(nums) - 1
    while l <= r:
        mid = (l + r) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            l = mid + 1
        else:
            r = mid - 1
    if nums[mid] > target:
        return mid
    else:
        return mid + 1