
# print("Waiting the instructions ...")

stack = []
str = ''
stack.append(str)

while True:
    try:
        line = input()
        if not line:
            break  # End of input

        words = line.split()

        if words[0] == '1':
            stack.append(str)
            str += words[1]
            # print(f"Insert: append characters {words[1]}; str => {str}")
        elif words[0] == '2':
            stack.append(str)
            n = int(words[1])
            str = str[:-n]
            # print(f"Delete: delete the last {words[1]} characters; str => {str}")
        elif words[0] == '3':
            index = int(words[1])
            print(str[index - 1])
            # if 0 <= index < len(str):
                # print(str[index])
                # print(f"Print: print the {words[1]}th character; str => {str}")
            # else:
                # print(f"Delete: invalid index {words[1]}; str => {str}")
        elif words[0] == '4':
            try:
                str = stack.pop()
                # print("Popped:", str)
            except IndexError:
                # print("The stack is empty. Cannot pop from an empty stack.")
                str = ''

            # print(f"Undo: str => {str}")
        # else:
            # print(f"Unknown input; str => {str}")
    except EOFError:
        break

# print("Have a good day!")
