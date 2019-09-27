def pushMe(num, dict):
    if num < 10:
        dict[str(num)] = 1
    else:
        x = num%10
        num = num/10 + x
        if dict.has_key(str(num)):
            z = dict[str(num)]
            dict[str(num)] = z+1
        else:
            dict[str(num)] = 1

def lottery(n):
    dict = {}
    for i in range(1, n+1):
        pushMe(i, dict)

    print dict
    maxCount = 0
    for key, value in dict.iteritems():
        if value>maxCount:
            maxCount = value

    count = 0
    for key, value in dict.iteritems():
        if value == maxCount:
            count+=1
    return count

print lottery(22)


