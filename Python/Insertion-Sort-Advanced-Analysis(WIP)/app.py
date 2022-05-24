import math
import os
import random
import re
import sys

#
# Complete the 'insertionSort' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#

def merge(A, s, m, t):
    r = 0
    i, j, k, u = 0, 0, s, m + 1

    A_1 = A[s:m+1].copy()
    A_2 = A[m+1:t+1].copy()

    while i < len(A_1) and j < len(A_2):
        if A_1[i] <= A_2[j]:
            A[k] = A_1[i]
            i,k = i+1, k+1
            continue

        r += len(A_1) - i #### only part needed for solving the problem
        #                 #### rest is same as merge-sort.

        A[k] = A_2[j]
        j,k = j+1, k+1

    while i < len(A_1):
        A[k] = A_1[i]
        i, k = i+1, k+1

    while j < len(A_2):
        A[k] = A_2[j]
        j, k = j+1, k+1

    return r

def msort(A):
    r = 0
    n = 1
    l = len(A)

    while n <= l:
        s = 0
        while s < l:
            m = s + n - 1
            t = s + 2 * n - 1

            if t >= l:
                t = l - 1

            if t > s:
                r += merge(A, s, m, t)
            s = s + n * 2
        n *= 2
    return r

def insertionSort(arr):
    # Write your code here
    return msort(arr)

if __name__ == '__main__':
    fptr = open("stdout.txt", "w") # os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        arr = list(map(int, input().rstrip().split()))

        result = insertionSort(arr)

        fptr.write(str(result) + '\n')

    fptr.close()
