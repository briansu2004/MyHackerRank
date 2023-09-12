from itertools import combinations


if __name__ == '__main__':
    with open('stdin.txt') as f:

        n, k = map(int, f.readline().split())
        teams = [list(map(int, list(f.readline().strip()))) for i in range(n)]
        sums = [sum([x[0] or x[1] for x in list(zip(*i))])
                for i in combinations(teams, 2)]
        print(max(sums), sums.count(max(sums)), sep='\n')
