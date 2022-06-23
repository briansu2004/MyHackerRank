# Enter your code here. Read input from STDIN. Print output to STDOUT
import math

if __name__ == '__main__':
    with open('stdin.txt') as f:
        mean_std = f.readline().split(" ")
        mean, std = mean_std[0], mean_std[1]

        def cdf(x): return 0.5 * \
            (1 + math.erf((x - mean) / (std * (2 ** 0.5))))

        print(round((1-cdf(80))*100, 2))
        print(round((1-cdf(60))*100, 2))
        print(round((cdf(60))*100, 2))
