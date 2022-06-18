import math
import os
import random
import re
import sys


def merge(arr, L, R):
    i = il = ir = inversion_count = 0
    l_len = len(L)
    r_len = len(R)
    while il < l_len and ir < r_len:
        if L[il] <= R[ir]:
            arr[i] = L[il]
            il += 1
        else:
            arr[i] = R[ir]
            ir += 1
            inversion_count += l_len-il
        i += 1
    while il < l_len:
        arr[i] = L[il]
        il += 1
        i += 1
    while ir < r_len:
        arr[i] = R[ir]
        ir += 1
        i += 1

    return inversion_count


def merge_sort(arr):
    mid = len(arr)//2
    inversion_count = 0
    if mid > 0:
        L = arr[:mid]
        R = arr[mid:]
        inversion_count += merge_sort(L)
        inversion_count += merge_sort(R)
        inversion_count += merge(arr, L, R)
    return inversion_count


def insertionSort(arr):
    return merge_sort(arr)


if __name__ == '__main__':
    with open('stdin_tc_7.txt') as f:

        t = int(f.readline().strip())

        for t_itr in range(t):
            n = int(f.readline().strip())

            arr = list(map(int, f.readline().rstrip().split()))

            result = insertionSort(arr)

            print(result)
