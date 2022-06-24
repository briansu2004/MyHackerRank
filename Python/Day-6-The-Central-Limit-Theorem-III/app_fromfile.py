import math

if __name__ == '__main__':
    with open('stdin.txt') as f:

        samples = float(f.readline())
        mean = float(f.readline())
        sd = float(f.readline())
        interval = float(f.readline())
        z = float(f.readline())

        sd_sample = sd / (samples**0.5)
        print(round(mean - sd_sample*z, 2))
        print(round(mean + sd_sample*z, 2))
