#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'abbreviation' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING a
#  2. STRING b
#


def abbreviation(a, b):
    # Write your code here
    A = [[None for j in range(len(b))] for i in range(len(a))]
    # construct base cases
    # for our base case it's only going to be true if it's all lower case
    # and one of them is equal to B[0]
    # or there's only been one upper case letter and it's equal to b[j]
    # upper_encountered means that we encountered that upper case letter
    j = 0
    if a[0].upper() == b[0]:
        A[0][0] = True
    upper_encountered = a[0].isupper()
    for i in range(1, len(a)):
        if a[i].isupper() and upper_encountered:
            A[i][j] = False
        elif a[i].isupper() and not upper_encountered and a[i] == b[j]:
            A[i][j] = True
            upper_encountered = True
        elif a[i].isupper() and not upper_encountered and a[i] != b[j]:
            A[i][j] = False
            upper_encountered = True
        elif a[i].islower() and a[i].upper() == b[j] and not upper_encountered:
            A[i][j] = True
        # a[i].islower()
        else:
            A[i][j] = A[i-1][j]
    # since a[i] is only length 1 anything in A[0][1:] will be False
    i = 0
    for j in range(1, len(b)):
        A[i][j] = False
    # now find the solution
    for i in range(1, len(a)):
        for j in range(1, len(b)):
            if a[i].upper() == b[j] and a[i].islower():
                A[i][j] = A[i-1][j-1] or A[i-1][j]
            elif a[i].upper() == b[j] and a[i].isupper():
                A[i][j] = A[i-1][j-1]
            elif a[i].upper() != b[j] and a[i].islower():
                A[i][j] = A[i-1][j]
            else:
                A[i][j] = False
    if A[len(a)-1][len(b)-1]:
        return "YES"
    return "NO"


if __name__ == '__main__':
    with open('stdin.txt') as f:

        q = int(f.readline().strip())

        for q_itr in range(q):
            a = f.readline().strip()

            b = f.readline().strip()

            result = abbreviation(a, b)

            print(result + '\n')
