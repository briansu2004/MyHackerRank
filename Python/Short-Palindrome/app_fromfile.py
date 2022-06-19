import math
import os
import random
import re
import sys

#
# Complete the 'shortPalindrome' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING s as parameter.
#

'''
Loop over S just once
having 3 arrays: 
1) singles[26] - how many times I saw character x 
2) pairs[26][26] - how many pairs xy I saw 
3) triples[26][26] - how many triples xyy I saw

a minor optimization: 
triples here need not be a 2d array, it can be 1d, 
since for "xyy" you don't need to separately maintain the number for each y; 
only the sum over all y matters.
'''


def shortPalindrome(s):
    # Write your code here
    mod = 10**9 + 7
    C1 = [0] * 26
    C2 = [0] * 26 * 26
    C3 = [0] * 26 * 26
    count = 0
    # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]
    r26 = list(range(26))
    for c in s:
        k = ord(c) - 97  # ord('a') is 97
        p = 26 * k - 1
        q = k - 26
        for i in r26:
            q += 26
            p += 1
            count += C3[q]
            C3[p] += C2[p]
            C2[p] += C1[i]
        C1[k] += 1

    return count % mod


if __name__ == '__main__':

    with open('stdin.txt') as f:
        s = f.readline()

        result = shortPalindrome(s)

        print(result)
