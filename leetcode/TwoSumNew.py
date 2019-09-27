def twoSum(nums, target):
    arr = []
    for i,x in enumerate(nums):
        arr.append((x,i))
    arr.sort()
    print arr

    i=0;
    j=len(nums) -1
    while i<j:
        if (target== arr[i][0]+arr[j][0]+ 30):
            return [arr[i][1],arr[j][1]]
        elif(target > arr[i][0]+arr[j][0]+ 30):
            i+=1
        else:
            j-=1
    return [0,0]

lst = [10, 40, 60, 20, 100, 30, 60, 80, 90]
print twoSum(lst, 150)