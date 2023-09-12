import math
import os
import random
import re
import sys

#
# Complete the 'steadyGene' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING gene as parameter.
#


def extras_available(all_counts, max_nucleotide_count):
    '''Returns True if any nucleotide count is greater than max_nucleotide_count'''
    # loop through all counts
    for counts in all_counts.values():
        # if any count is greater than max_nucleotide_count, return True
        if counts > max_nucleotide_count:
            return True
    # if got past loop, no extras found => return False
    return False


def steadyGene(gene):
    # Write your code here
    # genes are made up of nucleotides
    # nucleotides are A, T, C, G

    gene_length = len(gene)
    max_nucleotide_count = gene_length / 4

    # get all counts
    all_counts = {
        "A": 0,
        "T": 0,
        "C": 0,
        "G": 0,
    }

    for nucleotide in gene:  # O(n)
        all_counts[nucleotide] += 1

    # "Extras" are any count that is over max_nucleotide_count
    if not extras_available(all_counts, max_nucleotide_count):
        return 0

    # find smallest subset of string containing all extras
    # using moving window
    right_runner = 0
    left_runner = 0
    min_substring_length = float("inf")

    while right_runner < gene_length:  # O(n)
        # if extras still available...
        while right_runner < gene_length and extras_available(all_counts, max_nucleotide_count):
            # move right runner and remove nucleotide from all_counts
            nucleotide = gene[right_runner]
            all_counts[nucleotide] -= 1
            right_runner += 1
        while left_runner < gene_length and not extras_available(all_counts, max_nucleotide_count):
            # no extras available => window may contain best substring
            # move left runner and add nucleotide to all_counts
            nucleotide = gene[left_runner]
            all_counts[nucleotide] += 1
            left_runner += 1
        # left runner goes 1 more than needed
        min_substring_length = min(
            min_substring_length, right_runner - left_runner + 1)

    return min_substring_length  # Total Time Complexity: O(n)


if __name__ == '__main__':
    with open('stdin.txt') as f:

        n = int(f.readline().strip())

        gene = f.readline()

        result = steadyGene(gene)

        print(result)
