import math


def cdf(x, mu, sigma):
    Z = (x - mu)/sigma
    return 0.5*(1 + math.erf(Z/(math.sqrt(2))))


if __name__ == '__main__':
    with open('stdin.txt') as f:
        x = int(f.readline())
        n = int(f.readline())
        mu = int(f.readline())
        sigma = int(f.readline())

        mu_sum = n * mu
        sigma_sum = math.sqrt(n) * sigma

        print(round(cdf(x, mu_sum, sigma_sum), 4))
