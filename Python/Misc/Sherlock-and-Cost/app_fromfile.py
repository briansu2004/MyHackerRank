#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'cost' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY B as parameter.
#


def cost(B):
    # Write your code here
    n = len(B)
    hi, low = 0, 0
    for i in range(1, n):  # note we skip index 0
        high_to_low_diff = abs(B[i-1] - 1)
        low_to_high_diff = abs(B[i] - 1)
        high_to_high_diff = abs(B[i] - B[i-1])

        low_next = max(low, hi + high_to_low_diff)
        hi_next = max(hi + high_to_high_diff, low + low_to_high_diff)

        hi, low = hi_next, low_next

        # loLo = 0 # 1 - 1
        # loHi = abs(B[idx] - 1)
        # hiLo = abs(B[idx-1] - 1)
        # hiHi = abs(B[idx-1] - B[idx])

        # newLoSum = max( loSum + loLo, hiSum + hiLo )
        # newHiSum = max( loSum + loHi, hiSum + hiHi )

    return max(hi, low)


if __name__ == '__main__':
    with open('stdin.txt') as f:

        t = int(f.readline().strip())

        for t_itr in range(t):
            n = int(f.readline().strip())

            B = list(map(int, f.readline().rstrip().split()))

            result = cost(B)

            print(result)
