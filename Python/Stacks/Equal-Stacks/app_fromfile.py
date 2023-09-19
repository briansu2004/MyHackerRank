#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'equalStacks' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY h1
#  2. INTEGER_ARRAY h2
#  3. INTEGER_ARRAY h3
#

def equalStacks(h1, h2, h3):
    s1 = sum(h1)
    s2 = sum(h2)
    s3 = sum(h3)

    while s1 != s2 or s2 != s3:
        max_sum = max(s1, s2, s3)
        if s1 == max_sum:
            s1 -= h1.pop(0)
        elif s2 == max_sum:
            s2 -= h2.pop(0)
        else:
            s3 -= h3.pop(0)

    return s1

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n1 = int(first_multiple_input[0])

    n2 = int(first_multiple_input[1])

    n3 = int(first_multiple_input[2])

    h1 = list(map(int, input().rstrip().split()))

    h2 = list(map(int, input().rstrip().split()))

    h3 = list(map(int, input().rstrip().split()))

    result = equalStacks(h1, h2, h3)

    fptr.write(str(result) + '\n')

    fptr.close()
