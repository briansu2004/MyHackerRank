if __name__ == '__main__':
    # fptr = open("stdin.txt", 'r')
    # line = fptr.read()
    # print(line)
    # fptr.close()

    lines = []
    with open('stdin.txt') as f:
        lines = f.readlines()
        count = 0
        for line in lines:
            count += 1
            print(f'line {count}: {line}')
