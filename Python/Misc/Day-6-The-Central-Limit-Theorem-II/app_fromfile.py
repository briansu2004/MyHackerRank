from math import erf


if __name__ == '__main__':
    with open('stdin.txt') as f:

        max_num = float(f.readline())
        n = int(f.readline())
        mu = float(f.readline())
        std = float(f.readline())
        mean = n*mu
        stan = std*(n**0.5)
        def f(x): return 0.5*(1+erf((x-mean)/(stan*(2**0.5))))
        pro = f(max_num)
        pro = round(pro, 4)
        print(pro)
