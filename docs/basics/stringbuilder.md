# StringBuilder

[← String으로 돌아가기](./string.md)

---

## 특징

- **mutable** (가변 객체) → 문자열 수정 가능
- 문자열 연결이 많을 때 String보다 효율적
- 내부적으로 char 배열 사용, 용량 초과 시 자동 확장

---

## String vs StringBuilder

| 구분 | String | StringBuilder |
|-----|--------|---------------|
| 가변성 | immutable | mutable |
| 연결 연산 | 새 객체 생성 | 기존 객체 수정 |
| 용도 | 읽기 위주 | 수정/연결 위주 |

```java
// ❌ String 연결: O(N)
String s = s1 + s2;

// ✅ StringBuilder 연결: O(1)
sb.append(s2);
```

> **왜 O(N)?** </br> 
> `s1 + s2`는 내부적으로 StringBuilder 생성 → 기존 문자열 byte[] 복사 → append → toString()에서 다시 byte[] 복사

---

## 📊 주요 메서드

| 메서드 | 반환 | 설명 |
|-------|-----|------|
| `append(x)` | StringBuilder | 뒤에 추가 |
| `insert(idx, x)` | StringBuilder | 위치에 삽입 |
| `delete(start, end)` | StringBuilder | 범위 삭제 [start, end) |
| `deleteCharAt(idx)` | StringBuilder | 문자 삭제 |
| `reverse()` | StringBuilder | 뒤집기 |
| `substring(start, end)` | String | 부분 문자열 [start, end) |
| `toString()` | String | String으로 변환 |
| `length()` | int | 길이 |
| `charAt(idx)` | char | 문자 조회 |
| `setCharAt(idx, ch)` | void | 문자 수정 |

---

## 🧱 자주 쓰는 패턴

**문자열 뒤집기**
```java
String reversed = new StringBuilder(str).reverse().toString();
```

**구분자로 연결**
```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < arr.length; i++) {
    if (i > 0) sb.append(",");
    sb.append(arr[i]);
}
```

**출력 최적화**
```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < N; i++) {
    sb.append(result[i]).append("\n");
}
System.out.print(sb);
```
