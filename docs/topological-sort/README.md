# 위상 정렬 (Topological Sort)

[← 메인으로 돌아가기](../../README.md)

---

## 📎 관련 문서
- [그래프](../graph/README.md)
- [BFS / DFS](../bfs-dfs/README.md)

---

## 🔑 키워드
`순서` `선후관계` `의존성` `DAG` `사이클 없음` `선수과목`

## ❌ 실수 포인트
- 사이클 존재 여부 체크 누락
- 진입 차수 갱신 실수

---

## 정의

**방향 그래프**에서 간선의 방향을 거스르지 않도록 정점을 나열하는 것

---

## 조건

- **DAG (Directed Acyclic Graph)**: 사이클이 없는 방향 그래프
- 사이클이 있으면 위상 정렬 불가능

---

## 📊 시간 복잡도
`O(V + E)`

---

## 구현 방법

### BFS (Kahn's Algorithm) - 권장

1. 진입 차수가 0인 정점을 큐에 삽입
2. 큐에서 꺼낸 정점의 간선 제거 (연결된 정점의 진입 차수 감소)
3. 진입 차수가 0이 된 정점을 큐에 삽입
4. 큐가 빌 때까지 반복

```java
static List<Integer> topologicalSort() {
    List<Integer> result = new ArrayList<>();
    ArrayDeque<Integer> q = new ArrayDeque<>();

    // 진입 차수가 0인 정점 삽입
    for (int i = 1; i <= V; i++) {
        if (indegree[i] == 0) {
            q.offer(i);
        }
    }

    while (!q.isEmpty()) {
        int now = q.poll();
        result.add(now);

        for (int next : graph[now]) {
            indegree[next]--;
            if (indegree[next] == 0) {
                q.offer(next);
            }
        }
    }

    // 사이클 체크: 모든 정점이 결과에 포함되지 않으면 사이클 존재
    if (result.size() != V) {
        return null;  // 사이클 존재
    }

    return result;
}
```

### DFS

1. 모든 정점에서 DFS 수행
2. DFS 종료 시점에 스택에 삽입
3. 스택을 뒤집으면 위상 정렬 결과

```java
static void dfs(int node) {
    visited[node] = true;
    for (int next : graph[node]) {
        if (!visited[next]) {
            dfs(next);
        }
    }
    stack.push(node);  // 종료 시점에 삽입
}
```
