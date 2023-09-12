import math
import os
import random
import re
import sys
from heapq import heappush, heappop
from collections import defaultdict

#
# Complete the 'shortestReach' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER n
#  2. 2D_INTEGER_ARRAY edges
#  3. INTEGER s
#


def shortestReach(n, edges, s):
    # Write your code here
    # initialization of adjacency list
    graph = defaultdict(list)
    for (x, y), w in edges.items():
        # undirected graph
        graph[x].append((w, y))
        graph[y].append((w, x))

    distance = [sys.maxsize] * (n + 1)
    visited = [False] * (n + 1)

    # initialize for starting node
    distance[s] = 0
    minHeap = [(distance[s], s)]

    # main logic
    while minHeap:
        d, u = heappop(minHeap)
        if visited[u] == True:
            continue

        # update node as visited
        visited[u] = True

        for w, v in graph[u]:
            if visited[v] == False and distance[v] > distance[u] + w:
                # update the minimum distance
                distance[v] = distance[u] + w
                # update the priority queue
                heappush(minHeap, (distance[v], v))

    del distance[s]
    del distance[0]

    # update unreachable nodes as -1
    for i in range(len(distance)):
        if distance[i] == sys.maxsize:
            distance[i] = -1

    return distance


if __name__ == '__main__':
    with open('stdin.txt') as f:

        t = int(f.readline().strip())

        for t_itr in range(t):

            first_multiple_input = f.readline().rstrip().split()

            n = int(first_multiple_input[0])

            m = int(first_multiple_input[1])

            edges = dict()

            for _ in range(m):
                u, v, w = map(int, f.readline().rstrip().split())
                if (u, v) in edges:
                    edges[(u, v)] = min(edges[(u, v)], w)
                elif (v, u) in edges:

                    edges[(v, u)] = min(edges[(v, u)], w)
                else:
                    edges[(u, v)] = w

            s = int(f.readline().strip())

            result = shortestReach(n, edges, s)

            print(result)
