# 트리 (Tree)

[← 메인으로 돌아가기](../../README.md)

---

## 📎 관련 문서
- [BFS / DFS](../bfs-dfs/README.md)
- [그래프](../graph/README.md)

---

## 정의

사이클이 없는 연결 그래프

---

## 특징

- 계층적인 자료 구조 (부모 - 자식 관계)
- 모든 노드가 연결되어 있음
- **정점 개수(V) = 간선 개수(E) + 1**
- 사이클이 없음 → 재귀 호출 시 별도의 baseCase 불필요

---

## 용어

| 용어 | 설명 |
|-----|------|
| 루트 (Root) | 최상위 노드 |
| 부모 노드 | 어떤 노드의 바로 위 노드 |
| 자식 노드 | 어떤 노드의 바로 아래 노드들 |
| 리프 (Leaf) | 자식 노드가 없는 노드 |
| 서브 트리 | 특정 노드를 루트로 하는 트리 |
| 레벨 (Level) | 루트를 Level 1로 했을 때 각 노드의 깊이 |

---

## ⚠️ 주의할 점

- 트리는 재귀적 구조 → 주로 **DFS** 사용
- 간선이 적은 그래프 → **인접 리스트**로 구현

---

## 🧱 기본 코드

```java
ArrayList<Integer>[] tree = new ArrayList[V + 1];
for (int i = 0; i <= V; i++) {
    tree[i] = new ArrayList<>();
}

// 무방향 연결
tree[parent].add(child);
tree[child].add(parent);
```

**트리 DFS 탐색**
```java
static void dfs(int node, int parent) {
    for (int child : tree[node]) {
        if (child != parent) {
            dfs(child, node);
        }
    }
}
```
