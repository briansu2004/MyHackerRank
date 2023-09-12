#!/bin/python3

import math
import os
import random
import re
import sys

if __name__ == '__main__':
    with open('stdin.txt') as f:
        n, m = map(int, f.readline().strip().split(" "))
        dist = [[math.inf]*(n+1) for _ in range(n+1)]

        for _ in range(m):
            i, j, w = map(int, f.readline().strip().split(" "))
            dist[i][j] = w
        for i in range(1, n+1):
            dist[i][i] = 0

        for k in range(1, n+1):
            for i in range(1, n+1):
                for j in range(1, n+1):
                    dist[i][j] = min(dist[i][j], dist[i][k]+dist[k][j])

        q = int(f.readline())

        for _ in range(q):
            i, j = map(int, f.readline().strip().split(" "))
            print(dist[i][j] if dist[i][j] != math.inf else -1)
