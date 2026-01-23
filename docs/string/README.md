# 문자열 (String)

[← 메인으로 돌아가기](../../README.md)

---

## 📎 관련 문서
- [StringBuilder](./stringbuilder.md)

---

## 🔑 키워드
`문자열 처리` `파싱` `변환` `비교` `탐색`

## ❌ 실수 포인트
- `==` 대신 `equals()` 사용
- 인덱스 범위 초과 (charAt, substring)
- String은 immutable → 반복 연결 시 StringBuilder 사용

---

## 특징

- `java.lang` 패키지 (import 불필요)
- **immutable** (불변 객체) → 수정 시 새 객체 생성
- 문자열 연결이 많으면 **StringBuilder** 사용

---

## 문자열 생성

```java
String str1 = "Hello";              // 리터럴 (String Pool)
String str2 = new String("Hello");  // 힙 영역
```

- **리터럴**: String Pool에 저장, 같은 값이면 같은 참조
- **new**: 항상 새 객체 생성

> 비교 시 `==`는 참조 비교, `equals()`는 값 비교

---

## 📊 주요 메서드

| 메서드 | 반환 | 설명 |
|-------|-----|------|
| `charAt(i)` | char | i번째 문자 |
| `length()` | int | 문자열 길이 |
| `equals(str)` | boolean | 값 비교 |
| `compareTo(str)` | int | 사전순 비교 |
| `substring(start, end)` | String | 부분 문자열 [start, end) |
| `indexOf(ch/str)` | int | 문자/문자열 위치 (-1: 없음) |
| `contains(str)` | boolean | 포함 여부 |
| `startsWith(str)` | boolean | 접두사 확인 |
| `endsWith(str)` | boolean | 접미사 확인 |
| `split(regex)` | String[] | 구분자로 분리 |
| `replace(old, new)` | String | 문자열 치환 |
| `toCharArray()` | char[] | 문자 배열로 변환 |
| `toLowerCase()` | String | 소문자로 변환 |
| `toUpperCase()` | String | 대문자로 변환 |
| `trim()` | String | 앞뒤 공백 제거 |

---

## 🧱 자주 쓰는 패턴

**문자 → 숫자 변환**
```java
char c = '5';
int n = c - '0';  // 5
```

**알파벳 인덱스**
```java
char c = 'C';
int idx = c - 'A';  // 2
```

**문자열 → 숫자**
```java
int n = Integer.parseInt("123");
```

**숫자 → 문자열**
```java
String s = String.valueOf(123);
String s = Integer.toString(123);
```

**문자 배열 → 문자열**
```java
char[] arr = {'a', 'b', 'c'};
String s = new String(arr);
```
