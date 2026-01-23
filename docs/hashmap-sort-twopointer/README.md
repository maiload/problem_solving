# 해시맵 + 정렬 / 투포인터 ⭐⭐⭐⭐

[← 메인으로 돌아가기](../../README.md)

---

## 📎 관련 문서
- [정렬](../sort/README.md)

---

## 🔑 키워드
`중복 제거` `빈도수` `존재 여부` `구간 합` `연속 부분` `정렬 후 처리`

## 🧩 자주 섞이는 조합
- Map + 정렬
- 투포인터 + 정렬
- Map + BFS visited

## ❌ 실수 포인트
- HashMap null 체크 누락
- 투포인터 경계 조건 실수
- 정렬 후 원본 인덱스 필요한 경우

## ⚠️ 주의할 점
- 범위 불명확 → Map
- 범위 작고 명확 → 배열

---

## 📊 시간 복잡도

| 자료구조/알고리즘 | 시간 복잡도 |
|----------------|-----------|
| HashMap/HashSet | 평균 O(1), 최악 O(N) |
| TreeMap/TreeSet | O(logN) |
| Arrays.sort (primitive) | 평균 O(NlogN), 최악 O(N²) |
| Arrays.sort (Object) | O(NlogN) |
| Two Pointer | O(N) |

---

## HashMap / HashSet

**Set**: 중복 없는 원소 집합
- `add()`, `remove()`, `contains()`

**Map**: <key, value> 쌍 저장
- `put()`, `remove()`, `containsKey()`, `get()`, `getOrDefault()`

| 구현체 | 특징 | 순서 |
|-------|-----|-----|
| HashSet/HashMap | O(1) | 보장 X |
| TreeSet/TreeMap | O(logN) | 정렬 순서 |
| LinkedHashMap | O(1) | 삽입 순서 |

### 순회 패턴

**Set 순회**
```java
Set<Integer> set = new HashSet<>();
for (int num : set) {
    // auto-unboxing
}
```

**Map 순회**
```java
Map<String, Integer> map = new HashMap<>();

// Entry 순회 (key, value 둘 다 필요)
for (Map.Entry<String, Integer> e : map.entrySet()) {
    String key = e.getKey();
    int value = e.getValue();
}

// Key만 순회
for (String key : map.keySet()) {
    int value = map.get(key);
}

// Value만 순회
for (int value : map.values()) {
    // value만 필요할 때
}
```

---

## Sort (정렬)

**Arrays.sort**

| 타입 | 알고리즘 | 복잡도 | stable |
|-----|---------|-------|--------|
| primitive[] | Dual-Pivot Quick Sort | 평균 O(NlogN), 최악 O(N²) | X |
| Object[] | Tim Sort | O(NlogN) | O |

---

## Two Pointer

O(N²) → **O(N)** 최적화

### 패턴 1. 같은 출발점 (슬라이딩 윈도우)
> 이상/이하 조건에서 사용

```java
int R = -1;
for (int L = 0; L < N; L++) {
    while (R < N - 1 && 조건식) {
        R++;
        // R번째 값 추가
    }
    // L번째 값 제거
}
```

### 패턴 2. 시작/끝 (수렴 패턴)
> 정확한 매칭 조건에서 사용

```java
int L = 0, R = N - 1;
while (L < R) {
    if (조건식) R--;
    else if (조건식) L++;
    else break;
}
```

> **L < R vs L <= R**
> - `L < R`: 두 명을 짝지어야 할 때 (한 명 남으면 종료)
> - `L <= R`: 한 명도 처리해야 할 때 (모든 원소 처리)
