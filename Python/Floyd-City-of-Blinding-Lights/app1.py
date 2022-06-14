#!/bin/python3

import math
import os
import random
import re
import sys


n, m = map(int, input().split())
# create disyance graph
dist_graph = [[math.inf for i in range(n+1)] for j in range(n+1)]

for _ in range(m):
    x, y, w = map(int, input().split())
    # update weights in the distance graph
    dist_graph[x][y] = w

# update diagonal of the distance matrix to 0 (node to itself)
for i in range(1, n+1):
    dist_graph[i][i] = 0

# main logic - floyd warshall algorithm
for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            # update minimun distance
            dist_graph[i][j] = min(dist_graph[i][j], dist_graph[i]
                                   [k] + dist_graph[k][j])

q = int(input())
for _ in range(q):
    x, y = map(int, input().split())

    if dist_graph[x][y] == math.inf:
        print(-1)
    else:
        print(dist_graph[x][y])
