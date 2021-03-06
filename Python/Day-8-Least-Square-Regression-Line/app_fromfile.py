'''
For numeric data types, * is used as multiplication operator
For sequences such as string, list and tuple,  * is a repetition operator
Single asterisk as used in function declaration allows variable number of arguments passed from calling environment. Inside the function it behaves as a tuple.
'''

import math


if __name__ == '__main__':
    with open('stdin.txt') as f:

        n = 5
        xy = [map(int, f.readline().split()) for _ in range(n)]
        sx, sy, sx2, sxy = map(sum, zip(*[(x, y, x**2, x * y) for x, y in xy]))
        b = (n * sxy - sx * sy) / (n * sx2 - sx**2)
        a = (sy / n) - b * (sx / n)
        print('{:.3f}'.format(a + b * 80))
