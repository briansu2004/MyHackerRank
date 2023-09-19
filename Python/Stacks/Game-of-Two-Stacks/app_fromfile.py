#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'twoStacks' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER maxSum
#  2. INTEGER_ARRAY a
#  3. INTEGER_ARRAY b
#

def twoStacks(maxSum, a, b):
    i = 0
    j = 0
    c = 0
    ans = 0

    while i < len(a) and c + a[i] <= maxSum:
        c += a[i]
        i += 1

    ans = max(ans, i)
    i -= 1

    while j < len(b) and c <= maxSum:
        c += b[j]
        j += 1

        while i >= 0 and c > maxSum:
            c -= a[i]
            i -= 1

        if c <= maxSum:
            ans = max(ans, i + j + 1)

    return ans

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    g = int(input().strip())

    for g_itr in range(g):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        maxSum = int(first_multiple_input[2])

        a = list(map(int, input().rstrip().split()))
        # a.reverse()
        b = list(map(int, input().rstrip().split()))
        # b.reverse()
        result = twoStacks(maxSum, a, b)

        fptr.write(str(result) + '\n')

    fptr.close()
