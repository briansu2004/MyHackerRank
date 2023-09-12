#!/bin/python3

import math
import os
import random
import re
import sys
from heapq import heappush, heappop

#
# Complete the 'minimumAverage' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY customers as parameter.
#


def minimumAverage(customers):
    # Write your code here
    total_time = waiting_time = 0
    customers.sort(reverse=True)
    queue = []
    while customers or queue:
        while customers and customers[-1][0] < total_time:
            heappush(queue, customers.pop()[::-1])
        if queue:
            task = heappop(queue)
            total_time += task[0]
            waiting_time += total_time - task[1]
        else:
            heappush(queue, customers.pop()[::-1])
            total_time = queue[0][1]
    return waiting_time // n


if __name__ == '__main__':
    #fptr = open(os.environ['OUTPUT_PATH'], 'w')
    fptr = open('stdout.txt', 'w')

    n = int(input().strip())

    customers = []

    for _ in range(n):
        customers.append(list(map(int, input().rstrip().split())))

    result = minimumAverage(customers)

    fptr.write(str(result) + '\n')

    fptr.close()
