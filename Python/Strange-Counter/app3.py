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


def strangeCounter(t):
    # Write your code here
    rem = 3
    while t > rem:
        t = t - rem
        rem *= 2

    return rem - t + 1


if __name__ == '__main__':
    with open('stdin.txt') as f:

        t = int(f.readline().strip())

        result = strangeCounter(t)

        print(result)
