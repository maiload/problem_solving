# 이분 탐색 (Binary Search) ⭐⭐⭐⭐⭐

[← 메인으로 돌아가기](../../README.md)

---

## 🔑 키워드
`최소/최대` `가능한가? (YES/NO)` `조건 만족` `최적값`

## 🧩 자주 섞이는 조합
- 이분 탐색 + 그리디
- 이분 탐색 + BFS
- 이분 탐색 + 누적합

## ❌ 실수 포인트
- `l <= r` vs `l < r` 헷갈림
- mid 계산 시 overflow

## ⚠️ 주의할 점
- 배열에서 찾는 게 아니라 **"값의 범위"**에서 찾는 것
- 답은 대부분 `l` (최대값은 `l - 1`)

---

## 📊 시간 복잡도
`O(logN)`

---

## 개념

N개의 원소를 가진 배열에서 X라는 값이 있는지 알고 싶다면?
(또는 해당 값보다 작은/큰 값의 개수는? / 해당 값의 근삿값은?)

- 순차 탐색: `O(N)`
- **정렬 후 Binary Search**: `O(logN)`
  - 중간 값을 기준으로 크기를 비교해 탐색 범위를 절반씩 줄여가며 찾는 방법

---

## Case 1. 일치하는 값

> 일치하는 값의 경우 이진 탐색보다 HashSet의 contains()를 사용하는 것이 더 빠르다 → 평균 O(1)

<details>
<summary>code 보기</summary>

**API**
```java
int idx = Arrays.binarySearch(arr, x);
// 값이 존재하면 index, 없으면 음수 반환
```

**구현**
```java
int search(int[] arr, int X) {
    int l = 0, r = arr.length - 1;     // 폐구간 패턴 [l, r]
    while (l <= r) {
        int m = (l + r) / 2;
        if (arr[m] < X) l = m + 1;
        else if (arr[m] > X) r = m - 1;
        else return m;
    }
    return -1;
}
```
</details>

---

## Case 2. lowerBound / upperBound

**lowerBound / upperBound란?**
- **lowerBound**: n 이상 중 최소
- **upperBound**: n 이하 중 최대

**왜 `r = 마지막 인덱스 + 1` 인가?**
- "목표 구간의 다음 위치(경계)" 를 반환하도록 설계
- 경계는 항상 `[0, N]` 범위에 존재 → "없음"도 자연스럽게 표현 가능

**lowerBound로 통일하기**
- 조건문으로 구분 (`<` vs `<=`) 할 수도 있고, 반환값으로 구분 (`l` vs `l-1`) 할 수도 있다
- **반환값으로 구분하면 조건문을 lowerBound 하나로 통일 가능!**

| 찾고 싶은 것 | 의미 | 반환값 |
|------------|------|-------|
| lowerBound | n **이상** 중 최소 | `l` |
| upperBound | n **이하** 중 최대 | `l - 1` |

---

## 🧱 기본 코드

```java
static int search(int n, int[] arr) {
    int l = 0, r = arr.length;
    while (l < r) {
        int m = (l + r) / 2;
        if (arr[m] < n) {
            l = m + 1;
        } else {
            r = m;
        }
    }
    return l;       // lowerBound: n 이상 최소
 // return l - 1;   // upperBound: n 이하 최대
}

// l, r 직접 설정
static int search(int n, int[] arr, int l, int r) {
    while (l < r) {
        int m = (l + r) / 2;
        if (arr[m] < n) {
            l = m + 1;
        } else {
            r = m;
        }
    }
    return l;       // lowerBound: n 이상 최소
 // return l - 1;   // upperBound: n 이하 최대
}
```

---

## 📎 관련 문서
- [Parametric Search](./parametric-search.md)
