from collections import defaultdict
from heapq import heappop, heappush

n, m = map(int, input().split())
graph = defaultdict(list)
for i in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))
dist = [float('inf')]*(n+1)
dist[1] = 0
h = [(0, 1)]
visited = [0]*(n+1)
while h:
    a, b = heappop(h)
    if visited[b]:
        continue
    visited[b] = 1
    for x, y in graph[b]:
        if dist[x] > a + max(0, y - a):
            dist[x] = a + max(0, y - a)
            heappush(h, (dist[x], x))
print(dist[-1] if dist[-1] != float('inf') else 'NO PATH EXISTS')
