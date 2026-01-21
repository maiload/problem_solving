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
