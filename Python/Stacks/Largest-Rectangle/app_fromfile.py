#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'largestRectangle' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts INTEGER_ARRAY h as parameter.
#


def nsr(arr):
    ans = []
    st = []
    for i in range(len(arr)-1, -1, -1):
        if not st:
            ans.append(len(arr))
        elif st[-1][1] < arr[i]:
            ans.append(st[-1][0])
        else:
            while st and st[-1][1] >= arr[i]:
                st.pop()
            if not st:
                ans.append(len(arr))
            else:
                ans.append(st[-1][0])
        st.append([i, arr[i]])
    return ans[::-1]


def nsl(arr):
    ans = []
    st = []
    for i in range(len(arr)):
        if not st:
            ans.append(-1)
        elif st[-1][1] < arr[i]:
            ans.append(st[-1][0])
        else:
            while st and st[-1][1] >= arr[i]:
                st.pop()
            if not st:
                ans.append(-1)
            else:
                ans.append(st[-1][0])
        st.append([i, arr[i]])
    return ans


def largestRectangle(h):
    # Write your code here
    s1 = nsl(h)
    s2 = nsr(h)
    res = 0
    for i in range(len(h)):
        res = max(res, (s2[i]-s1[i]-1)*h[i])
    return res


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    h = list(map(int, input().rstrip().split()))

    result = largestRectangle(h)

    fptr.write(str(result) + '\n')

    fptr.close()
