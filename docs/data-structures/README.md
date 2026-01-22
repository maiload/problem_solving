# 스택 / 큐 / 우선순위 큐 ⭐⭐⭐⭐

[← 메인으로 돌아가기](../../README.md)

---

## 🔑 키워드
`괄호` `짝 맞추기` `되돌리기` `LIFO` `FIFO` `최소/최대 우선` `순서대로 처리`

## 🧩 자주 섞이는 조합
- 스택 + 문자열 파싱
- 큐 + BFS
- 우선순위 큐 + 다익스트라
- 우선순위 큐 + 그리디

## ❌ 실수 포인트
- 빈 스택/큐에서 pop/poll 호출
- 우선순위 큐 정렬 방향 착각 (기본: 오름차순)
- ArrayDeque는 null 저장 불가

## ⚠️ 주의할 점
- Stack 클래스 대신 **ArrayDeque** 사용 권장
- LinkedList 대신 **ArrayDeque** 사용 권장 (성능)
- PriorityQueue는 내부 순서 보장 X (poll 시에만 정렬)

---

## 📊 시간 복잡도

| 연산 | Stack/Queue | PriorityQueue |
|-----|-------------|---------------|
| push/offer | O(1) | O(logN) |
| pop/poll | O(1) | O(logN) |
| peek | O(1) | O(1) |
| size | O(1) | O(1) |

- **ArrayDeque**: 원형 배열 + head/tail 인덱스 관리 → 실제 삭제 없이 인덱스만 이동 → O(1)
  - 원형 배열: `index % capacity`로 인덱스 순환
- **PriorityQueue**: 힙 구조 유지 위해 삽입/삭제 시 heapify → O(logN)
- **size**: 내부 size 변수 관리 → O(1)

---

## Stack (스택)

LIFO (Last In First Out) - 후입선출

**사용 예시**: 괄호 매칭, 후위 표기식, 되돌리기(Undo)

```java
ArrayDeque<Integer> stack = new ArrayDeque<>();
stack.push(1);      // 삽입
stack.pop();        // 제거 + 반환
stack.peek();       // 조회
stack.isEmpty();    // 비어있는지 확인
```

---

## Queue (큐)

FIFO (First In First Out) - 선입선출

**사용 예시**: BFS, 순서대로 처리

```java
ArrayDeque<Integer> queue = new ArrayDeque<>();
queue.offer(1);     // 삽입
queue.poll();       // 제거 + 반환
queue.peek();       // 조회
queue.isEmpty();    // 비어있는지 확인
```

---

### ArrayDeque vs LinkedList

| 구현체 | 장점 | 단점 |
|-------|-----|-----|
| ArrayDeque | 빠름, 메모리 효율 | null 저장 불가 |
| LinkedList | null 저장 가능 | 느림, 메모리 비효율 |

> **결론**: 특별한 이유가 없으면 **ArrayDeque 사용**

---

## Priority Queue (우선순위 큐)

우선순위가 높은 원소부터 처리

**사용 예시**: 다익스트라, 그리디, 힙 정렬

```java
// 기본: 오름차순 (최소 힙)
PriorityQueue<Integer> pq = new PriorityQueue<>();

// 내림차순 (최대 힙)
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

// 커스텀 정렬
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

pq.offer(1);        // 삽입
pq.poll();          // 제거 + 반환 (우선순위 높은 것)
pq.peek();          // 조회
```

---

### PriorityQueue vs TreeMap

| 구분 | PriorityQueue | TreeMap |
|-----|---------------|---------|
| 최소값 | O(1) peek | O(logN) firstKey |
| 최대값 | X | O(logN) lastKey |
| 삭제 | O(logN) poll | O(logN) remove |

> **최소/최대 둘 다 필요하면 TreeMap 사용**

```java
TreeMap<Integer, Integer> map = new TreeMap<>();  // <값, 개수>

// 삽입
map.put(num, map.getOrDefault(num, 0) + 1);

// 최소/최대 조회
map.firstKey();  // 최소값
map.lastKey();   // 최대값

// 삭제
int key = map.lastKey();  // 또는 firstKey()
int cnt = map.get(key);
if (cnt == 1) map.remove(key);
else map.put(key, cnt - 1);
```
