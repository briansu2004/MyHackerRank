#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'matrixRotation' function below.
#
# The function accepts following parameters:
#  1. 2D_INTEGER_ARRAY matrix
#  2. INTEGER r
#


def matrixRotation(matrix, r):
    # Write your code here

    m = len(matrix)
    n = len(matrix[0])

    # temp matrix
    mat = []

    # of layers
    k = min(m, n) // 2

    # get elements from the layer
    for i in range(k):
        temp = []
        for j in range(i, n-1-i):
            temp.append(matrix[i][j])
        for j in range(i, m-1-i):
            temp.append(matrix[j][n-1-i])
        for j in range(n-1-i, i, -1):
            temp.append(matrix[m-1-i][j])
        for j in range(m-1-i, i, -1):
            temp.append(matrix[j][i])
        mat.append(temp)

    # rotate elements and place it in the original matrix
    for i in range(k):
        row = mat[i]
        # find index after rotation
        idx = r % len(row)

        def inc():
            return (idx+1) % len(row)
        # assgin new rotated elements
        for j in range(i, n-1-i):
            matrix[i][j] = row[idx]
            idx = inc()
        for j in range(i, m-1-i):
            matrix[j][n-1-i] = row[idx]
            idx = inc()
        for j in range(n-1-i, i, -1):
            matrix[m-1-i][j] = row[idx]
            idx = inc()
        for j in range(m-1-i, i, -1):
            matrix[j][i] = row[idx]
            idx = inc()

    # print the matrix
    for row in matrix:
        print(*row)

if __name__ == '__main__':
    first_multiple_input = input().rstrip().split()

    m = int(first_multiple_input[0])

    n = int(first_multiple_input[1])

    r = int(first_multiple_input[2])

    matrix = []

    for _ in range(m):
        matrix.append(list(map(int, input().rstrip().split())))

    matrixRotation(matrix, r)

# 1
'''
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
'''
