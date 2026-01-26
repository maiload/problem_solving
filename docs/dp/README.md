# DP (Dynamic Programming)

[← 메인으로 돌아가기](../../README.md)

---

## 🔑 키워드
`최적 부분 구조` `중복 부분 문제` `메모이제이션` `점화식`

## ❌ 실수 포인트
- 초기값 설정 누락
- 점화식 인덱스 범위 초과
- 메모이제이션 배열 초기화 실수

## ⚠️ 주의할 점
- 완전 탐색 → 중복 발견 → DP 변환
- 점화식 세우기 전에 부분 문제 정의 먼저

---

## DP 적용 조건

1. **최적 부분 구조**: 큰 문제의 최적해가 작은 문제의 최적해로 구성
2. **중복 부분 문제**: 같은 부분 문제가 여러 번 계산됨

---

## 접근 방식

| 방식 | 설명 | 장점 |
|-----|------|-----|
| Top-Down | 재귀 + 메모이제이션 | 직관적, 필요한 것만 계산 |
| Bottom-Up | 반복문 + 테이블 | 스택 오버플로우 없음 |

---

## 기본 구조

### Top-Down (메모이제이션)

```java
int[] dp = new int[N + 1];
Arrays.fill(dp, -1);

int solve(int n) {
    if (n <= 1) return n;  // 기저 조건
    if (dp[n] != -1) return dp[n];  // 이미 계산됨

    return dp[n] = solve(n - 1) + solve(n - 2);
}
```

### Bottom-Up (타뷸레이션)

```java
int[] dp = new int[N + 1];
dp[0] = 0;
dp[1] = 1;

for (int i = 2; i <= N; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
}
```

---

## 대표 유형

### 1. 1차원 DP

```java
// 계단 오르기: dp[i] = i번째 계단까지 최대 점수
dp[i] = Math.max(dp[i-1], dp[i-2]) + cost[i];
```

### 2. 2차원 DP

```java
// 배낭 문제: dp[i][w] = i번째 물건까지 고려, 무게 w일 때 최대 가치
if (weight[i] <= w) {
    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i]);
} else {
    dp[i][w] = dp[i-1][w];
}
```

### 3. LCS (최장 공통 부분 수열)

```java
// dp[i][j] = A[0..i-1]과 B[0..j-1]의 LCS 길이
if (A[i-1] == B[j-1]) {
    dp[i][j] = dp[i-1][j-1] + 1;
} else {
    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
}
```

### 4. LIS (최장 증가 부분 수열)

```java
// O(N^2)
dp[i] = 1;
for (int j = 0; j < i; j++) {
    if (arr[j] < arr[i]) {
        dp[i] = Math.max(dp[i], dp[j] + 1);
    }
}

// O(NlogN) - 이분 탐색 활용
List<Integer> lis = new ArrayList<>();
for (int num : arr) {
    int idx = Collections.binarySearch(lis, num);
    if (idx < 0) idx = -(idx + 1);
    if (idx == lis.size()) lis.add(num);
    else lis.set(idx, num);
}
// LIS 길이 = lis.size()
```

---

## DP 문제 풀이 순서

1. **부분 문제 정의**: dp[i]가 무엇을 의미하는지
2. **점화식 도출**: dp[i]를 이전 값들로 표현
3. **초기값 설정**: 기저 조건
4. **계산 순서 결정**: 어떤 순서로 채울지
5. **정답 추출**: dp 테이블에서 답 찾기
