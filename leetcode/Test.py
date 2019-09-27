def subStringkDist(inputStr, num):
    setX =set()
    for i in range(len(inputStr)-num + 1):
        st = ""
        for j in range(i, i+num):
            if inputStr[j] in st:
                break
            else:
                st = st + inputStr[j]
        if len(st) == num:
            setX.add(st)

    return list(setX)

print subStringkDist("abcd", 3)