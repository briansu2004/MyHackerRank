# Enter your code here. Read input from STDIN. Print output to STDOUT
from math import factorial, exp

miu = float(input())
x = int(input())
poisson_prob = ((miu ** x) * exp(-miu)) / factorial(x)
print("%.3f" % poisson_prob)
