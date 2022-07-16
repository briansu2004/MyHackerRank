#!/bin/python3

import math
import os
import random
import re
import sys


def quick_sort(pivot, arr):
    lists = [[], [pivot], []]
    [(lists[0] if n < pivot else lists[2] if n > pivot else lists[1]).append(n)
     for n in arr]

    for i in filter(lambda x: len(lists[x]) > 1, [0, 2]):
        lists[i] = quick_sort(lists[i].pop(0), lists[i])
        print(*lists[i])

    return sum(lists, [])


if __name__ == '__main__':
    with open('stdin.txt') as f:
        __ = f.readline()
        pivot, *arr = [int(n) for n in f.readline().split()]

        print(*quick_sort(pivot, arr))
