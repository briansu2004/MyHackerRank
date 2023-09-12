import collections


def tc(n, arr):
    d = collections.defaultdict(list)
    for i in range(n):
        k, v = arr[i].split()
        if i < n//2:
            d[int(k)].append("-")
        else:
            d[int(k)].append(v)
    od = collections.OrderedDict(sorted(d.items()))
    print(" ".join([" ".join(l) for l in od.values()]))


if __name__ == '__main__':
    with open('stdin.txt') as f:
        n = int(f.readline())
        arr = []
        for _ in range(n):
            arr.append(f.readline())
        tc(n, arr)
