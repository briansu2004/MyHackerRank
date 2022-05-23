from math import inf
from bisect import bisect_left as bLeft, bisect_right as bRight
from collections import defaultdict
import fileinput


def get_health(seq, first, last, largest):
    h, ls = 0, len(seq)
    for f in range(ls):
        for j in range(1, largest+1):
            if f+j > ls:
                break
            sub = seq[f:f+j]
            if sub not in subs:
                break
            if sub not in gMap:
                continue
            ids, hs = gMap[sub]
            h += hs[bRight(ids, last)] - hs[bLeft(ids, first)]
    # print(h)
    return h


if __name__ == '__main__':
    with open('stdin.txt') as f:
        n = int(f.readline().strip())
        genes = f.readline().rstrip().split()
        health = list(map(int, f.readline().rstrip().split()))

        gMap = defaultdict(lambda: [[], [0]])
        subs = set()
        for i, gene in enumerate(genes):
            gMap[gene][0].append(i)
            for j in range(1, min(len(gene), 500) + 1):
                subs.add(gene[:j])

        for v in gMap.values():
            for i, ix in enumerate(v[0]):
                v[1].append(v[1][i]+health[ix])
        largest = max(list(map(len, genes)))
        hMin, hMax = inf, 0
        # print(gMap)
        s = int(f.readline().strip())
        for s_itr in range(s):
            first_multiple_input = f.readline().rstrip().split()
            first = int(first_multiple_input[0])
            last = int(first_multiple_input[1])
            d = first_multiple_input[2]
            h = get_health(d, first, last, largest)
            hMin, hMax = min(hMin, h), max(hMax, h)
        print(hMin, hMax)
