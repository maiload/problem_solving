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
- 시간 복잡도를 계산할 때는 최악의 상황을 가정하여 구해야 하지만, </br>
  l과 r의 범위를 구할 때는 주어진 입력값 중에서 최댓값으로 설정하면 된다.

---

## 🧱 기본 코드
- Binary-Search와 동일

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
    return l;       // 최솟값 : lowerBound
//  return l - 1;   // 최댓값 : upperBound - 1
}
```
```java
boolean check(int m) {
    return 결과 < 목표;     // 목표 보다 작을 때만 m + 1    -> lowerBound(m >= n)
//  return 결과 <= 목표;    // 목표 일 때까지 m + 1       -> upperBound(m > n)
}
```
