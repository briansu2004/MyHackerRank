import math

def get_rank(X, n):
    x_rank = dict((x, i+1) for i, x in enumerate(sorted(set(X))))
    return [x_rank[x] for x in X]

if __name__ == '__main__':
    with open('stdin.txt') as f:

        n = int(f.readline())
        X = list(map(float, f.readline().split()))
        Y = list(map(float, f.readline().split()))

        rx = get_rank(X, n)
        ry = get_rank(Y, n)

        d = [(rx[i] - ry[i])**2 for i in range(n)]
        rxy = 1 - (6 * sum(d)) / (n * (n*n - 1))

        print('%.3f' % rxy)
