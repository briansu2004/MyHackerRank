#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'swapNodes' function below.
#
# The function is expected to return a 2D_INTEGER_ARRAY.
# The function accepts following parameters:
#  1. 2D_INTEGER_ARRAY indexes
#  2. INTEGER_ARRAY queries
#

sys.setrecursionlimit(int(1e9))

def swapNodes(t, queries):
    t = [[]] + t  # make 1-based indexes work
    def f(k,r=1,d=1):
        t[r] = t[r] if d%k else t[r][::-1]
        return f(k,t[r][0],d+1)+[r]+f(k,t[r][1],d+1) if r+1 else []
    return [f(i) for i in queries]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    indexes = []

    for _ in range(n):
        indexes.append(list(map(int, input().rstrip().split())))

    queries_count = int(input().strip())

    queries = []

    for _ in range(queries_count):
        queries_item = int(input().strip())
        queries.append(queries_item)

    result = swapNodes(indexes, queries)

    fptr.write('\n'.join([' '.join(map(str, x)) for x in result]))
    fptr.write('\n')

    fptr.close()
