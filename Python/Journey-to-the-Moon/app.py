#!/bin/python3

import math
import os
import random
import re
import sys
from collections import defaultdict

# Complete the journeyToMoon function below.


def journeyToMoon(n, astronaut):

    graph = defaultdict(list)

    for i, j in astronaut:

        graph[i].append(j)
        graph[j].append(i)

    visited = set()

    def dfs(v):

        visited.add(v)

        nodes = 1

        if v in graph:

            for j in graph[v]:

                if j not in visited:

                    nodes += dfs(j)

        return nodes

    ans = 0
    sum = 0

    countrySizes = []

    for i in range(n):

        if i not in visited:

            countrySizes.append(dfs(i))

    for i in countrySizes:

        ans += sum*i

        sum += i

    return ans


if __name__ == '__main__':
    sys.setrecursionlimit(1500)

    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    np = input().split()

    n = int(np[0])

    p = int(np[1])

    astronaut = []

    for _ in range(p):
        astronaut.append(list(map(int, input().rstrip().split())))

    result = journeyToMoon(n, astronaut)

    fptr.write(str(result) + '\n')

    fptr.close()
