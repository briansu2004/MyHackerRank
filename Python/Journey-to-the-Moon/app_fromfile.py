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
