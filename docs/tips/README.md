# 코테 꿀팁 모음

[← 메인으로 돌아가기](../../README.md)

---

## 가변 길이 결과 → 배열 변환

정답 개수가 정해지지 않았을 때 List로 수집 후 배열로 변환

```java
List<Integer> list = new ArrayList<>();
// ... 결과 추가

int[] result = list.stream().mapToInt(i -> i).toArray();
```

---

## 정수 나눗셈 올림

```java
// 방법 1: 실수 변환 (직관적)
int result = (int) Math.ceil((double) a / b);

// 방법 2: 정수 연산 (빠름)
int result = (a + b - 1) / b;
```

> **원리**: `(a + b - 1) / b`는 나머지가 있으면 몫에 1을 더하는 효과

---

## 시간 시뮬레이션

### 1) Tick 시뮬레이션

시간을 1씩 증가시키며 매 스텝 갱신 (0-패딩 방식)

```java
for (int t = 0; t < maxTime; t++) {
    queue.poll();                      // 매 tick마다 하나씩 빠짐
    if (조건) queue.offer(next);        // 값이 있으면 넣고
    else queue.offer(0);               // 없으면 0으로 채움
}
```

- **언제**: 시간 범위가 작을 때 (≤ 10^6)
- **트리거**: `매초 이동`, `매 턴 진행`, `격자 시뮬레이션`

### 2) Event 시뮬레이션

"언제 일어나는지"만 저장하고 이벤트 시각으로 점프

```java
queue.offer(new int[]{exitTime, target});
if (queue.peek()[0] <= currentTime) queue.poll();
```

- **언제**: 시간 범위가 크거나 tick이 비효율적일 때
- **트리거**: `TTL`, `타임아웃`, `N초 후 만료`, `스케줄링`

### 비교

| 방식 | 시간 복잡도 | 적합한 경우 |
|-----|-----------|-----------|
| Tick | O(T × N) | 시간 작고, 매 턴 규칙 기반 |
| Event | O(E log E) | 시간 크고, 이벤트 발생 시점만 중요 |

> **발상 전환**: State를 매번 갱신하지 말고, **언제 끝나는지(Event)** 로 변환
