#Implement atoi which converts a string to an integer
# https://leetcode.com/problems/string-to-integer-atoi/

def myAtoi(str):
    result = 1
    if len(str) == 0:
        return 0
    i = 0
    while i < len(str) and str[i] == ' ':
        i += 1
    if i < len(str) and str[i] == '-':
        result = -1
    if i < len(str) and (str[i] == '+' or str[i] == '-'):
        i += 1
    while i < len(str) and str[i] == '0':
        i += 1
    val = 0
    j = i;
    while i < len(str) and str[i].isdigit():
        i += 1
    if (i > j):
        val = int(str[j:i])
    val = val * result
    if val < -2 ** 31:
        val = -2 ** 31
    if val > (2 ** 31 - 1):
        val = 2 ** 31 - 1
    return val


str = "-0"
print (myAtoi(str))
