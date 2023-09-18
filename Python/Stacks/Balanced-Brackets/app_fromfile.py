#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'isBalanced' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def isBalanced(s):
    brackets = {'{':'}', '[':']', '(':')'}
    stack = []

    if len(s) % 2 != 0 or s[0] not in brackets.keys():
        return 'NO'

    for i in s:
        if i in brackets.keys():
            stack.append(i)
            
        if len(stack) == 0 and i in brackets.values():
            return 'NO'         
        elif i in brackets.values() and i == brackets.get(stack[-1]):
            stack.pop()

    if len(stack) == 0:
        return 'YES'
    
    return 'NO'


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        s = input()

        result = isBalanced(s)

        fptr.write(result + '\n')

    fptr.close()
