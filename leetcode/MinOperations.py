
def minimumOperations(numbers):
    lst = []
    totOps = 0
    for i in range(len(numbers)):
        if len(lst) == 0:
            lst.append(numbers[i])
            totOps+=1
            continue
        if lst[0] >= numbers[i]:
            lst.insert(0,numbers[i])
            totOps += 1
            continue
        if lst[-1] <= numbers[i]:
            lst.append(numbers[i])
            totOps += 1
            continue
            


