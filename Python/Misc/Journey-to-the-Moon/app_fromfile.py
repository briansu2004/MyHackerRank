'''
Grouping Items
A typical use of the Python defaultdict type is to set .default_factory to list and then build a dictionary that maps keys to lists of values. With this defaultdict, if you try to get access to any missing key, then the dictionary runs the following steps:
- Call list() to create a new empty list
- Insert the empty list into the dictionary using the missing key as key
- Return a reference to that list

Grouping Unique Items

dep = [('Sales', 'John Doe'),
       ('Sales', 'Martin Smith'),
       ('Accounting', 'Jane Doe'),
       ('Marketing', 'Elizabeth Smith'),
       ('Marketing', 'Elizabeth Smith'),
       ('Marketing', 'Adam Doe'),
       ('Marketing', 'Adam Doe'),
       ('Marketing', 'Adam Doe')]

dep_dd = defaultdict(set)
for department, employee in dep:
    dep_dd[department].add(employee)
'''
import os
import random
import re
import sys
import math
sys.setrecursionlimit(10**8)


def cn2(n):
    return n * (n - 1) // 2


def journeyToMoon(n, astronaut):
    # create adjacency list for graph edges
    graph = [[] for i in range(n)]
    for x, y in astronaut:
        graph[x].append(y)
        graph[y].append(x)

    visited = [False] * n

    # calculate total pairs
    pairs = cn2(n)

    # create dfs function
    # to find # of persons in one country
    def dfs(u, graph, visited):
        visited[u] = True

        # vertices = persons
        vertices = 1
        for v in graph[u]:
            if visited[v] == False:
                vertices += dfs(v, graph, visited)
        return vertices

    # main logic
    for v in range(n):
        if visited[v] == False:
            n_persons = dfs(v, graph, visited)
            # print(f"# of persons: ", n_persons)
            # remove possible combinations from the same country
            pairs -= cn2(n_persons)

    return pairs


if __name__ == '__main__':
    with open('stdin.txt') as f:
        sys.setrecursionlimit(1500)
        np = f.readline().split()
        n = int(np[0])
        p = int(np[1])
        astronaut = []

        for _ in range(p):
            astronaut.append(list(map(int, f.readline().rstrip().split())))

        result = journeyToMoon(n, astronaut)
        print(result)
