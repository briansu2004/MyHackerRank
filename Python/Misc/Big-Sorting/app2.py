#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'strangeCounter' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts LONG_INTEGER t as parameter.
#


if __name__ == '__main__':
    with open('stdin.txt') as f:

        n = int(f.readline())
        u = {}
        for _ in range(n):
            x = f.readline().strip()
            try:
                u[len(x)].append(x)
            except KeyError:
                u[len(x)] = [x]
        for i in sorted(u):
            for j in sorted(u[i]):
                print(j)
