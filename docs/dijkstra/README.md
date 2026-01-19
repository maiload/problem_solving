# 다익스트라 (Dijkstra)

[← 메인으로 돌아가기](../../README.md)

---

## 📎 관련 문서
- [그래프](../graph/README.md)
- [스택 / 큐 / 우선순위 큐](../data-structures/README.md)

---

## 🔑 키워드
`최단 경로` `가중치 그래프` `양수 가중치` `우선순위 큐`

## ❌ 실수 포인트
- 음수 가중치에 사용 (불가능)
- 거리 배열 초기값 설정 누락
- 이미 방문한 노드 재처리

---

## 정의

**가중치가 있는 그래프**에서 한 정점에서 다른 모든 정점까지의 최단 경로를 구하는 알고리즘

---

## 조건

- **양수 가중치**만 가능 (음수 가중치 → 벨만-포드)
- 방향/무방향 그래프 모두 가능

---

## 📊 시간 복잡도
- 우선순위 큐 사용: `O((V + E) log V)`
- 배열 사용: `O(V²)`

---

## 동작 원리

1. 시작 정점의 거리를 0으로, 나머지는 무한대로 초기화
2. 우선순위 큐에서 최소 거리 정점 추출
3. 해당 정점에서 갈 수 있는 정점의 거리 갱신
4. 갱신된 정점을 우선순위 큐에 삽입
5. 큐가 빌 때까지 반복

---

## 🧱 기본 코드

```java
static int[] dijkstra(int start) {
    int[] dist = new int[V + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    // 최소 힙: {거리, 노드}
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.offer(new int[]{0, start});

    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int curDist = cur[0];
        int curNode = cur[1];

        // 이미 처리된 노드 스킵
        if (curDist > dist[curNode]) continue;

        for (int[] next : graph[curNode]) {
            int nextNode = next[0];
            int nextDist = curDist + next[1];

            if (nextDist < dist[nextNode]) {
                dist[nextNode] = nextDist;
                pq.offer(new int[]{nextDist, nextNode});
            }
        }
    }

    return dist;
}
```

**그래프 초기화**
```java
ArrayList<int[]>[] graph = new ArrayList[V + 1];
for (int i = 0; i <= V; i++) {
    graph[i] = new ArrayList<>();
}
// graph[from].add(new int[]{to, cost});
```

---

## 관련 알고리즘

| 알고리즘 | 음수 가중치 | 시간 복잡도 | 용도 |
|---------|-----------|-----------|-----|
| 다익스트라 | X | O((V+E)logV) | 단일 출발점 최단 경로 |
| 벨만-포드 | O | O(VE) | 음수 가중치 허용 |
| 플로이드-워셜 | O | O(V³) | 모든 쌍 최단 경로 |
