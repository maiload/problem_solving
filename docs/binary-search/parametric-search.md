# Parametric Search

[← 이분 탐색으로 돌아가기](./README.md)

---

## 개념
최적값 문제를 **"값 X가 답이 될 수 있는가?"** 라는 결정 문제로 바꾼 뒤, Binary Search로 찾는 방법

---

## Binary Search와의 차이점

| 구분 | Binary Search | Parametric Search |
|-----|---------------|-------------------|
| 탐색 대상 | 배열의 원소 | 구하고자 하는 값의 범위 |
| 비교 방식 | `arr[m]` 비교 | `check(m)` 함수로 판단 |

> ex) 백준 2805: 주어진 나무의 높이 배열에서의 최적값이 아닌, **절단기에 설정할 수 있는 높이(h)의 최적값**을 구하는 문제
> → 높이(h)가 parameter이며 이 값의 최소, 최대가 l과 r이 된다

---

## 📊 시간 복잡도
`O(logN × check함수)`

---

## 💡 문제 접근 방법

1. 구하고자 하는 값의 범위를 설정: `[l, 마지막 값 + 1)`
2. 최소값: `l`, 최대값: `l - 1`

---

## 🧱 기본 코드

```java
static int search(int l, int r) {
    while (l < r) {
        int m = (l + r) / 2;
        if (check(m)) {      
            l = m + 1;
        } else {
            r = m;
        }
    }
    return l;       // 최소값: 조건 만족하는 첫 위치
 // return l - 1;   // 최대값: 조건 만족하는 마지막 위치
}
```

**check 함수 작성법**
- check는 항상 **"아직 목표에 못 미치는가?"** 로 작성 (항상 `<` 사용)
- Binary Search의 `arr[m] < n` 패턴과 동일

```java
boolean check(int m) {
    return 결과 < 목표;  // 항상 < 사용
}
```

| 찾고 싶은 것 | 반환값 |
|------------|-------|
| 조건 만족 **최소값** | `l` |
| 조건 만족 **최대값** | `l - 1` |

**예시: 나무 자르기 (M 이상 얻기)**
```java
boolean check(int h) {
    return getWood(h) < M;  // 나무가 M보다 적으면 true
}
```
