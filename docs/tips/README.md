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

## ExitTime 패턴

> **핵심**: State를 매번 갱신하지 말고, **언제 끝나는지(Event)** 로 변환

"매 tick마다 모든 상태 갱신" → "이 상태는 언제 끝나는지만 알면 되지 않나?"

```java
// ❌ Before: 상태 기반 (매초 전체 갱신)
for (Item item : items) {
    item.remainingTime--;
}

// ✅ After: 이벤트 기반 (종료 시점만 저장)
queue.offer(new int[]{exitTime, target});
if (queue.peek()[0] <= currentTime) queue.poll();
```

| 방식 | 시간 복잡도 |
|-----|-----------|
| 상태 기반 | O(N) per tick |
| 이벤트 기반 | O(1) per event |

**트리거 키워드**: `일정 시간 후 만료`, `N초 후 퇴장`, `TTL`, `타임아웃`
