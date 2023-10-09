Q = int(input())
S = ''
stack = []
for _ in range(Q):
    ops = input()
    if ops[0] == '1':
        stack.append(S)
        S += ops[2:]
    if ops[0] == '2':
        stack.append(S)
        index = int(ops[2:])
        S = S[:len(S) - index]
    if ops[0] == '3':
        index = int(ops[2:])
        print(S[index - 1])
    if ops[0] == '4':
        S = stack.pop()
