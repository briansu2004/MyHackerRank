#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'acmTeam' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts STRING_ARRAY topic as parameter.
#


def acmTeam(topic):
    # Write your code here
    d = []
    resdic = {}
    m = 0
    for t in topic:
        temp = set()
        for i in range(len(t)):
            if t[i] == '1':
                temp.add(i)
        d.append(temp.copy())
    # print(d)
    for i in range(len(d)-1):
        for j in range(i+1, len(d)):
            l = len(d[i].union(d[j]))
            m = max(m, l)
            resdic[l] = resdic.get(l, 0)+1
    return [m, resdic[m]]


if __name__ == '__main__':
    with open('stdin.txt') as f:

        first_multiple_input = f.readline().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        topic = []

        for _ in range(n):
            topic_item = f.readline()
            topic.append(topic_item)

        result = acmTeam(topic)
        print('\n'.join(map(str, result)))
        print('\n')
