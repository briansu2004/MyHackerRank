#!/bin/python3

import math
import os
import random
import re
import sys
from collections import Counter
from itertools import groupby

#
# Complete the 'happyLadybugs' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING b as parameter.
#


def happyLadybugs(b):
    # Write your code here
    c = Counter(b)
    if "_" in c:
        for x, y in c.items():
            if y < 2 and x != "_":
                return "NO"
    else:
        for x, y in groupby(b):
            if len(list(y)) < 2:
                return "NO"
    return "YES"


if __name__ == '__main__':
    with open('stdin.txt') as f:

        g = int(f.readline().strip())

        for g_itr in range(g):
            n = int(f.readline().strip())

            b = f.readline().strip()

            result = happyLadybugs(b)

            print(result)
