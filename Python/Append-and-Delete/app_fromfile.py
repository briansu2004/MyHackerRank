#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'appendAndDelete' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING s
#  2. STRING t
#  3. INTEGER k
#


def appendAndDelete(s, t, k):
    # Write your code here
    c = 0
    l = len(s)
    while s[:l] != t[:l]:
        l -= 1
        c += 1
    o = len(t) -l + c
    if k < o:
        return("No")
    elif len(s) + len(t) <= k:
        return("Yes")
    elif 2 * len(t) < k:
        return("Yes")
    elif k % 2 == o % 2:
        return("Yes")
    else:
        return("No")


if __name__ == '__main__':

    with open('stdin.txt') as f:

        s = f.readline().strip()

        t = f.readline().strip()

        k = int(f.readline().strip())

        result = appendAndDelete(s, t, k)

        print(result)
