# 분할 정복 (Divide and Conquer)

[← 메인으로 돌아가기](../../README.md)

---

## 🔑 키워드
`분할` `정복` `병합` `재귀` `반으로 나누기`

## 🧩 자주 섞이는 조합
- 분할 정복 + 이분 탐색
- 분할 정복 + 재귀

## ❌ 실수 포인트
- 기저 조건 누락
- 분할 범위 계산 실수 (mid 포함 여부)
- 병합 과정 누락

---

## 📊 시간 복잡도
보통 O(NlogN)

---

## 핵심 아이디어

1. **분할 (Divide)**: 문제를 작은 부분 문제로 나눔
2. **정복 (Conquer)**: 부분 문제를 재귀적으로 해결
3. **병합 (Combine)**: 부분 문제의 해를 합쳐서 원래 문제 해결

---

## 기본 구조

```java
void solve(int left, int right) {
    // 기저 조건
    if (left >= right) return;

    // 분할
    int mid = (left + right) / 2;

    // 정복
    solve(left, mid);
    solve(mid + 1, right);

    // 병합
    merge(left, mid, right);
}
```

---

## 대표 예시

### 병합 정렬 (Merge Sort)

```java
void mergeSort(int[] arr, int left, int right) {
    if (left >= right) return;

    int mid = (left + right) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) temp[k++] = arr[i++];
        else temp[k++] = arr[j++];
    }
    while (i <= mid) temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];

    for (int t = 0; t < temp.length; t++) {
        arr[left + t] = temp[t];
    }
}
```

### 거듭제곱 (Fast Power)

```java
// a^n mod m
long power(long a, long n, long m) {
    if (n == 0) return 1;

    long half = power(a, n / 2, m);
    long result = half * half % m;

    if (n % 2 == 1) result = result * a % m;
    return result;
}
```
