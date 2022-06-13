import math
import os
import random
import re
import sys

#
# Complete the 'longestIncreasingSubsequence' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#


def longestIncreasingSubsequence(nums):
    # Write your code here
    tails = [0] * len(nums)
    size = 0
    for x in nums:
        i, j = 0, size
        while i != j:
            m = (i + j) // 2
            if tails[m] < x:
                i = m + 1
            else:
                j = m
        tails[i] = x
        size = max(i + 1, size)
    return size


if __name__ == '__main__':
    with open('stdin.txt') as f:
        n = int(f.readline().strip())

        arr = []

        for _ in range(n):
            arr_item = int(f.readline().strip())
            arr.append(arr_item)

        result = longestIncreasingSubsequence(arr)

        print(result)
