class Insertion:
    def __init__(self):
        self.count = 0

    def insertionsort(self, a):
        for i in range(1, len(a)):
            key = a[i]
            j = i-1
            while j >= 0 and a[j] > key:
                self.count += 1
                a[j+1] = a[j]
                j -= 1
            a[j+1] = key
        return self.count


class QuickSort:
    def __init__(self):
        self.count = 0

    def swap(self, b, c, d):
        temp = b[c]
        b[c] = b[d]
        b[d] = temp
        return b

    def partition(self, a, s, e):
        pivot = e
        pindex = s
        for i in range(s, e):
            if a[i] <= a[pivot]:
                self.swap(a, i, pindex)
                self.count += 1
                pindex += 1
        self.count += 1
        self.swap(a, pindex, pivot)
        return pindex

    def quicksort(self, a, s, e):
        if s < e:
            pIndex = self.partition(a, s, e)
            self.quicksort(a, s, pIndex-1)
            self.quicksort(a, pIndex+1, e)
        return self.count


n = int(input())
br = []
ar = [int(temp) for temp in input().strip().split(' ')]
for i in ar:
    br.append(i)

start = 0
end = len(ar)-1
quicksort = QuickSort()
insertion = Insertion()
print(insertion.insertionsort(br)-quicksort.quicksort(ar, start, end))
