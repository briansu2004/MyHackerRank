# Enter your code here. Read input from STDIN. Print output to STDOUT


if __name__ == '__main__':
    with open('stdin.txt') as f:
        # Input from stdin
        averageX, averageY = [float(num) for num in f.readline().split(" ")]

        # Cost
        CostX = 160 + 40*(averageX + averageX**2)
        CostY = 128 + 40*(averageY + averageY**2)

        print(round(CostX, 3))
        print(round(CostY, 3))
