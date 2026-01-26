# Array / List

[← 메인으로 돌아가기](../../README.md) | [시간 복잡도](./time-complexity.md)

---

## 🔑 키워드
`순차 저장` `인덱스 접근` `동적 크기`

## ❌ 실수 포인트
- 배열 인덱스 범위 초과 (0 ~ N-1)
- ArrayList 순회 중 삭제 시 ConcurrentModificationException
- 빈 리스트에서 get() 호출

---

## 📊 시간 복잡도

| 연산 | 배열 | ArrayList |
|-----|-----|-----------|
| 인덱스 접근 | O(1) | O(1) |
| 맨 뒤 삽입 | - | O(1) |
| 중간 삽입/삭제 | - | O(N) |
| 검색 | O(N) | O(N) |

---

## 배열 (Array)

```java
// 선언 + 초기화
int[] arr = new int[N];
int[] arr = {1, 2, 3};
int[][] arr2d = new int[N][M];

// 배열 복사
int[] copy = arr.clone();
int[] copy = Arrays.copyOf(arr, arr.length);

// 배열 채우기
Arrays.fill(arr, 0);
Arrays.fill(arr, start, end, value);  // [start, end)

// 배열 정렬
Arrays.sort(arr);
Arrays.sort(arr, start, end);  // [start, end)
```

---

## ArrayList

```java
List<Integer> list = new ArrayList<>();

list.add(1);            // 맨 뒤 추가
list.add(0, 1);         // 인덱스에 삽입
list.get(i);            // 조회
list.set(i, value);     // 수정
list.remove(i);         // 인덱스로 삭제
list.remove(Integer.valueOf(1));  // 값으로 삭제
list.size();            // 크기
list.isEmpty();         // 비어있는지
list.contains(1);       // 포함 여부
list.indexOf(1);        // 위치 (-1: 없음)
list.clear();           // 전체 삭제
```

---

## 배열 ↔ 리스트 변환

```java
// 배열 → 리스트
List<Integer> list = Arrays.stream(arr).boxed().toList();

// 리스트 → 배열
int[] arr = list.stream().mapToInt(i -> i).toArray();
```

---

## Map / Set 변환

```java
// Map keys → 리스트
List<String> keys = new ArrayList<>(map.keySet());

// Map values → 리스트
List<Integer> values = new ArrayList<>(map.values());

// Set → 리스트
List<Integer> list = new ArrayList<>(set);

// 리스트 → Set (중복 제거)
Set<Integer> set = new HashSet<>(list);
```

---

## 순회 중 삭제

```java
// ❌ ConcurrentModificationException
for (int num : list) {
    if (조건) list.remove(num);
}

// ✅ Iterator 사용
Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    if (조건) it.remove();
}

// ✅ 역순 인덱스 순회
for (int i = list.size() - 1; i >= 0; i--) {
    if (조건) list.remove(i);
}
```
