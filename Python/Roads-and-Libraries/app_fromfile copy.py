#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'roadsAndLibraries' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER c_lib
#  3. INTEGER c_road
#  4. 2D_INTEGER_ARRAY cities
#


def roadsAndLibraries(n, c_lib, c_road, cities):
    # Write your code here

    # create adjacency list for graph connection
    graph = [[] for i in range(n + 1)]
    for x, y in cities:
        # bidirectional graph
        graph[x].append(y)
        graph[y].append(x)

    total_cost = 0
    visited = [False] * (n + 1)

    # create depth first search function
    # to find the subset of cities
    def dfs(u, graph, visited):
        visited[u] = True
        n_cities = 1
        for v in graph[u]:
            if visited[v] == False:
                n_cities += dfs(v, graph, visited)

        return n_cities

    # main logic
    for v in range(1, n + 1):
        if visited[v] == False:
            # find no. of cities in the subset of graph
            n_cities = dfs(v, graph, visited)
            # calculate cost of roads and 1 library
            cost1 = (n_cities - 1) * c_road + c_lib
            # calculate cost of building libraries in all cities
            cost2 = n_cities * c_lib
            # add the minimum cost to the total
            total_cost += min(cost1, cost2)

    return total_cost


if __name__ == '__main__':
    with open('stdin.txt') as f:
        q = int(f.readline().strip())

        for q_itr in range(q):
            first_multiple_input = f.readline().rstrip().split()

            n = int(first_multiple_input[0])

            m = int(first_multiple_input[1])

            c_lib = int(first_multiple_input[2])

            c_road = int(first_multiple_input[3])

            cities = []

            for _ in range(m):
                cities.append(list(map(int, f.readline().rstrip().split())))

            result = roadsAndLibraries(n, c_lib, c_road, cities)

            print(result)
