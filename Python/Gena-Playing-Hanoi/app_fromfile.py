import math
import os
import random
import re
import sys

#
# Complete the 'hanoi' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY posts as parameter.
#


from collections import deque


def legal_moves(x):
    for i in range(len(x)):
        if x[i]:
            for j in range(len(x)):
                if not x[j] or x[i][-1] < x[j][-1]:
                    yield (i, j)


def is_goal(x):
    return all([len(x[i]) == 0 for i in range(1, len(x))])


def bfs(x):
    def tuplify(z):
        return tuple(tuple(t) for t in z)

    def do_move(g, m):
        y = [list(t) for t in g]
        y[m[1]].append(y[m[0]].pop())
        # WLOG sort 2nd-4th stacks by order of largest disk
        y[1:4] = sorted(y[1:4], key=lambda t: t[-1] if t else 0)
        return tuplify(y)

    visited = set()

    start = (tuplify(x), 0)

    q = deque([start])
    visited.add(start)

    while q:
        node, depth = q.popleft()

        if is_goal(node):
            return depth

        for move in legal_moves(node):
            child = do_move(node, move)
            if child not in visited:
                visited.add(child)
                q.append((child, depth+1))


def hanoi(posts):
    # Write your code here
    return bfs(posts)


if __name__ == '__main__':
    with open('stdin.txt') as f:

        n = int(f.readline().strip())

        loc = list(map(int, f.readline().rstrip().split()))

        res = hanoi(loc)
        print(res)
