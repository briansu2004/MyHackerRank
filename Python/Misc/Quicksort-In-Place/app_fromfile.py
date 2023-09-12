
import math
import os
import random
import re
import sys


def partition(st, en):
    global ar
    if en - st > 0:
        pivot, border = ar[en], st
        for i in range(st, en):
            if ar[i] < pivot:
                ar[i], ar[border] = ar[border], ar[i]
                border += 1
        ar[en], ar[border] = ar[border], ar[en]
        print(' '.join(str(x) for x in ar))
        partition(st, border-1)  # Sort Left
        partition(border+1, en)  # Sort Right


if __name__ == '__main__':
    with open('stdin.txt') as f:
        m = int(f.readline().strip())
        ar = list(map(int, f.readline().strip().split()))
        partition(0, m-1)
