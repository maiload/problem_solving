# 정렬 (Sort)

[← 메인으로 돌아가기](../../README.md) | [Array / List](./array-list.md)

---

## 정의

데이터 집합을 적합한 순서로 배치하는 것

---

## 📊 시간 복잡도

| 분류 | 알고리즘 | 복잡도 |
|-----|---------|-------|
| O(N²) | Bubble, Selection, Insertion | O(N²) |
| O(NlogN) | Quick, Merge, Heap | O(NlogN) |
| 기타 | Counting, Radix, Bucket | O(N+K) |

---

## Arrays.sort

| 타입 | 알고리즘 | 복잡도 | stable |
|-----|---------|-------|--------|
| primitive[] | Dual-Pivot Quick Sort | 평균 O(NlogN), 최악 O(N²) | X |
| Object[] | Tim Sort | O(NlogN) | O |

> **stable**: 값이 같은 원소들의 기존 상대적 순서가 정렬 후에도 유지

---

## 🧱 기본 코드

**기본 정렬**
```java
int[] arr = {3, 1, 2};
Arrays.sort(arr);  // 오름차순
```

**객체 정렬 (Comparator)**
```java
Integer[] arr = {3, 1, 2};
Arrays.sort(arr, Collections.reverseOrder());  // 내림차순

// 2차원 배열 정렬
int[][] arr = {{1, 3}, {2, 1}, {1, 2}};
Arrays.sort(arr, (a, b) -> a[0] - b[0]);  // 첫 번째 원소 기준
```

**리스트 정렬**
```java
List<Integer> list = new ArrayList<>();
Collections.sort(list);                              // 오름차순
Collections.sort(list, Collections.reverseOrder()); // 내림차순
Collections.sort(list, (a, b) -> b - a);            // 내림차순 (람다)
```

**Comparator.comparingInt**
```java
List<int[]> list = new ArrayList<>();
Collections.sort(list, Comparator.comparingInt(a -> a[0]));            // 오름차순
Collections.sort(list, Comparator.comparingInt(a -> -a[0]));           // 내림차순
Collections.sort(list, Comparator.comparingInt(a -> a[0]).reversed());  // 내림차순
```

**다중 조건 정렬**
```java
Collections.sort(list, Comparator
    .comparing((int[] a) -> a[0])         // 1순위
    .thenComparing(a -> a[1]));           // 2순위
```

---

## Comparable vs Comparator

| 구분 | Comparable | Comparator |
|-----|------------|------------|
| 인터페이스 | `compareTo(T o)` | `compare(T o1, T o2)` |
| 위치 | 클래스 내부 구현 | 외부에서 정의 |
| 용도 | 기본 정렬 기준 | 다양한 정렬 기준 |

**Comparable (compareTo 구현)**
```java
class Node implements Comparable<Node> {
    int x, y;

    @Override
    public int compareTo(Node o) {
        if (this.x == o.x) {
            return this.y - o.y;  // 2순위: y 오름차순
        }
        return this.x - o.x;      // 1순위: x 오름차순
    }
}

// 사용
List<Node> list = new ArrayList<>();
Collections.sort(list);  // compareTo 기준으로 정렬
```

**Comparator (comparing 사용)**
```java
class Node {
    int x, y;
}

// 사용
List<Node> list = new ArrayList<>();
Collections.sort(list, Comparator
    .comparingInt((Node n) -> n.x)    // 1순위: x 오름차순
    .thenComparingInt(n -> n.y));     // 2순위: y 오름차순
```

> **Tip.** 클래스 수정이 가능하면 `Comparable`, 외부 정렬 기준이 필요하면 `Comparator`
