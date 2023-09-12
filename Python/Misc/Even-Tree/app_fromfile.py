import math
import os
import random
import re
import sys

# Complete the evenForest function below.


class Node(object):
    def __init__(self):
        self.parent = None
        self.size = 1

    def add_parent(self, p):
        self.parent = p
        while p is not None:
            p.size += 1
            p = p.parent


if __name__ == '__main__':
    with open('stdin.txt') as f:

        N, M = map(int, f.readline().split())

        nodes = [Node() for _ in range(N)]
        for _ in range(M):
            child, parent = map(int, f.readline().split())
            nodes[child-1].add_parent(nodes[parent-1])

        print(sum(1 for node in nodes if node.size %
                  2 == 0 and node.parent is not None))
