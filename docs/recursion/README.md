# 재귀함수 (Recursion)

[← 메인으로 돌아가기](../../README.md)

---

## 📎 관련 문서
- [BFS / DFS](../bfs-dfs/README.md)

---

## 정의

자기 자신을 호출하는 함수

---

## 사용 이유

- 탐색 경로가 여러 갈래로 분기되는 트리/그래프 구조
- 큰 문제를 작은 문제로 나누어 해결
- 귀납적 사고: (i-1), (i-2)번째 결과로 (i)번째 답을 구함

---

## ⚠️ 주의할 점

- **재귀함수의 인자**: 다음 분기가 시작되는 지점 정보
- **상태 수정 시 원복 필수**

```java
// 방법 1: 수정 후 원복
sum += arr[pos];
rec_fun(pos + 1, sum);
sum -= arr[pos];  // 원복

// 방법 2: 인자로 전달 (수정 X)
rec_fun(pos + 1, sum + arr[pos]);
```

---

## 🧱 기본 코드

```java
static void rec(int k) {
    if (k == M) {
        // 종료 조건
        return;
    }
    
    for (...) {
        // 처리
        rec(k + 1);
    }
}
```

---

# 백트래킹 (BackTracking)

재귀를 이용해 답을 찾는 도중 **최적해 가능성이 없어지면 탐색 중단**

---

## 특징

- 가능성이 있는 경우를 "유망하다"라고 표현
- 최악의 경우 완전탐색이 되지만, 평균적으로 시간 절약
- **가지치기(Pruning)**: 불필요한 탐색을 조기에 종료

---

## 🧱 기본 코드

```java
static void backtrack(int depth) {
    if (depth == M) {
        // 정답 처리
        return;
    }
    for (int i = 0; i < N; i++) {
        if (!visited[i]) {  // 유망성 검사
            visited[i] = true;
            backtrack(depth + 1);
            visited[i] = false;  // 원복
        }
    }
}
```

| 구분 | DFS의 visited      | 백트래킹의 visited      |
| -- | ----------------- | ------------------ |
| 의미 | **전역적으로 다시 안 가기** | **현재 경로에서만 사용 여부** |
| 수명 | 탐색 전체             | 재귀 한 경로            |
| 원복 | ❌ 안 함             | ✅ 반드시 함            |
| 목적 | 사이클 방지            | 중복 선택 방지           |

