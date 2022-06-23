# Enter your code here. Read input from STDIN. Print output to STDOUT
from math import factorial, exp


if __name__ == '__main__':
    with open('stdin.txt') as f:
        miu = float(f.readline())
        x = int(f.readline())
        poisson_prob = ((miu ** x) * exp(-miu)) / factorial(x)
        print("%.3f" % poisson_prob)
