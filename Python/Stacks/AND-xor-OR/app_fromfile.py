#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'andXorOr' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY a as parameter.
#

def andXorOr(a):
    stack = [a[0], a[1]]
    S = a[0] ^ a[1]
    for i in range(2, len(a)):
        while len(stack) > 0 and stack[-1] >= a[i]:
            S = max(S, stack[-1] ^ a[i])
            stack.pop()
        if len(stack) > 0:
            S = max(S, stack[-1] ^ a[i])
        stack.append(a[i])
    return S

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    a_count = int(input().strip())

    a = list(map(int, input().rstrip().split()))

    result = andXorOr(a)

    fptr.write(str(result) + '\n')

    fptr.close()
