import math
import os
import random
import re
import sys

#
# Complete the 'connectedCell' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY matrix as parameter.
#


def connectedCell(matrix):
    # Write your code here
    xi = [-1, -1, -1, 0, 0, 0, 1, 1, 1]
    yi = [-1, 0, 1, -1, 0, 1, -1, 0, 1]
    r = len(matrix)
    c = len(matrix[0])

    def helper(i, j, matrix, count):
        # return if not 1
        if matrix[i][j] != 1:
            return count

        # mark the cell as visited by placing 9
        count += 1
        matrix[i][j] = 9

        for x, y in zip(xi, yi):
            if 0 <= i + x < r and 0 <= j + y < c:
                count = max(count, helper(i + x, j + y, matrix, count))
        return count

    max_cells = 0
    for i in range(r):
        for j in range(c):
            max_cells = max(max_cells, helper(i, j, matrix, 0))
            # print('---')
            # for row in matrix:
            #     print(row)
            #     print(f"count: {max_cells}")

    return max_cells


if __name__ == '__main__':
    with open('stdin.txt') as f:

        n = int(f.readline().strip())

        m = int(f.readline().strip())

        matrix = []

        for _ in range(n):
            matrix.append(list(map(int, f.readline().rstrip().split())))

        result = connectedCell(matrix)

        print(result)
