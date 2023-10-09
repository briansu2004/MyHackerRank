#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'waiter' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER_ARRAY number
#  2. INTEGER q
#


class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Stack:
    def __init__(self, lst=[]):
        self.head = None
        self.length = 0
        if (len(lst)) > 0:
            for i in range(len(lst)):
                self.push(lst[i])

    def push(self, data):
        node = Node(data)
        if self.head is None:
            self.head = node
        else:
            node.next = self.head
            self.head = node

        self.length += 1

    def pop(self):
        val = self.head.data
        if self.head.next is not None:
            self.head = self.head.next
        else:
            self.head = None

        self.length -= 1
        return int(val)

    def __len__(self):
        return self.length


def sieve(number):
    sieve = [2]
    prime_candidate = 3

    while len(sieve) < number:
        is_prime = True
        sieve_index = 0
        while sieve_index < len(sieve):
            if prime_candidate % sieve[sieve_index] == 0:
                is_prime = False
                break
            sieve_index += 1
        if is_prime:
            sieve.append(prime_candidate)
        prime_candidate += 2

    return sieve


def waiter(number, q):
    answers, stackA, list_loop, stackB = [], Stack(number), [], Stack()
    orig_number = q
    primes = sieve(q)

    while orig_number > 0:
        for i in range(len(stackA)):
            val = stackA.pop()
            if val % primes[q-orig_number] == 0:
                stackB.push(val)
            else:
                list_loop.append(val)
        for i in range(len(stackB)):
            answers.append(stackB.pop())
        stackA = Stack(list_loop)
        list_loop.clear()
        orig_number -= 1

    for i in range(len(stackA)):
        answers.append(stackA.pop())

    return answers


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    q = int(first_multiple_input[1])

    number = list(map(int, input().rstrip().split()))

    result = waiter(number, q)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
