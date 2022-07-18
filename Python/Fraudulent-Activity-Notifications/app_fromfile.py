from bisect import bisect_left, insort_left


def med():
    return lastd[d//2] if d % 2 == 1 else ((lastd[d//2] + lastd[d//2-1])/2)


if __name__ == '__main__':
    with open('stdin.txt') as f:
        n, d = map(int, f.readline().split())
        t = list(map(int, f.readline().split()))
        noti = 0

        lastd = sorted(t[:d])

        for i in range(d, n):
            if t[i] >= 2*med():
                noti += 1
            del lastd[bisect_left(lastd, t[i-d])]
            insort_left(lastd, t[i])
        print(noti)
