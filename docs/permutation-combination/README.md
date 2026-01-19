# 순열 / 조합 (Permutation / Combination)

[← 메인으로 돌아가기](../../README.md)

---

## 📎 관련 문서
- [재귀함수 / 백트래킹](../recursion/README.md)

---

## 🔑 키워드
`경우의 수` `선택` `나열` `순서 O/X` `중복 O/X`

## ❌ 실수 포인트
- 순서 유무 혼동 (순열 vs 조합)
- 중복 허용 여부 처리 실수
- 시작 인덱스 설정 오류

---

## 개념

| 구분 | 순서 | 공식 | 예시 (n=3, r=2) |
|-----|-----|-----|----------------|
| 순열 (Permutation) | O | nPr = n! / (n-r)! | {1,2}, {2,1}, {1,3}... = 6개 |
| 조합 (Combination) | X | nCr = n! / (r!(n-r)!) | {1,2}, {1,3}, {2,3} = 3개 |

---

## 유형 분류

| 구분 | 중복 허용 | 순서 | 공식 |
|-----|----------|-----|------|
| 순열 | X | O | nPr |
| 중복 순열 | O | O | n^r |
| 조합 | X | X | nCr |
| 중복 조합 | O | X | n+r-1Cr |

---

## 🧱 기본 코드

**순열 (중복 X, 순서 O)**
```java
static void permutation(int depth) {
    if (depth == R) {
        // 결과 처리
        return;
    }
    for (int i = 0; i < N; i++) {
        if (!visited[i]) {
            visited[i] = true;
            arr[depth] = i;
            permutation(depth + 1);
            visited[i] = false;
        }
    }
}
```

**중복 순열 (중복 O, 순서 O)**
```java
static void permutationWithRepetition(int depth) {
    if (depth == R) {
        // 결과 처리
        return;
    }
    for (int i = 0; i < N; i++) {
        arr[depth] = i;
        permutationWithRepetition(depth + 1);
    }
}
```

**조합 (중복 X, 순서 X)**
```java
static void combination(int depth, int start) {
    if (depth == R) {
        // 결과 처리
        return;
    }
    for (int i = start; i < N; i++) {
        arr[depth] = i;
        combination(depth + 1, i + 1);  // i + 1: 다음 원소부터
    }
}
```

**중복 조합 (중복 O, 순서 X)**
```java
static void combinationWithRepetition(int depth, int start) {
    if (depth == R) {
        // 결과 처리
        return;
    }
    for (int i = start; i < N; i++) {
        arr[depth] = i;
        combinationWithRepetition(depth + 1, i);  // i: 같은 원소 허용
    }
}
```

---

## 핵심 차이

| 구분 | 핵심 코드 |
|-----|----------|
| 순열 | `visited` 배열로 중복 방지 |
| 조합 | `start` 인덱스로 순서 고정 |
| 중복 허용 | `visited` 제거 또는 `i + 1` → `i` |

---

## 중복 원소가 있는 경우

원소에 중복이 있을 때 순열의 개수:
```
n! / (a! × b! × c! × ...)
```

예: {1, 1, 2, 2, 2, 3}의 순열 개수
```
6! / (2! × 3! × 1!) = 60
```
