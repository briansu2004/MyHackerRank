#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'getMax' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts STRING_ARRAY operations as parameter.
#

class Stack:
    def __init__(self):
        self.items = []
        self.max_val = 0

    def is_empty(self):
        return len(self.items) == 0

    def push(self, item):
        self.items.append(item)
        self.max_val = max(self.max_val, item)

    def pop(self):
        if self.is_empty():
            raise IndexError("Stack is empty")
        
        p = self.items.pop()
        if self.is_empty():
            self.max_val = 0
        elif p == self.max_val:
            self.max_val = max(self.items)

        return p
        
    def get_max(self):
        if self.is_empty():
            return 0
        
        return self.max_val

def getMax(operations):
    stack = Stack()
    answers = []
    for op in operations:
        if op[0] == '1':
            stack.push(int(op[2:]))
        elif op[0] == '2':
            stack.pop()
        elif op[0] == '3':
            answers.append(stack.get_max())
    return answers
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    ops = []

    for _ in range(n):
        ops_item = input()
        ops.append(ops_item)

    res = getMax(ops)

    fptr.write('\n'.join(map(str, res)))
    fptr.write('\n')

    fptr.close()
