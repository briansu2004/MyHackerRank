import math
import os
import random
import re
import sys

#
# Complete the 'morganAndString' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING a
#  2. STRING b
#


def morgan(a, b):
    a += 'z'
    b += 'z'

    for _ in range(len(a) + len(b) - 2):
        if a < b:
            yield a[0]
            a = a[1:]
        else:
            yield b[0]
            b = b[1:]


def morganAndString(a, b):
    # Write your code here
    return ''.join(morgan(a, b))


if __name__ == '__main__':
    with open('stdin.txt') as f:
        t = int(f.readline().strip())

        for t_itr in range(t):
            a = f.readline()

            b = f.readline()

            result = morganAndString(a, b)

            print(result)
