# ps
- - -
## Part 1.
### String
- java.lang 패키지
- immutable object
- StringBuilder(변경 가능한 문자열)
``` 
String str1 = new String("Hello");
String str2 = "Hello"; 
```
Literal로 생성한 문자열은 constant String pool에 저장되고, new로 생성한 문자열은 heap영역에 저장된다.
> Literal 문자열은 공통 pool에 같은 값이 있으면 연결, 없으면 생성하고, heap 영역 문자열은 매번 새로 생성한다.

| Method name                                            | Return value |
|--------------------------------------------------------|--------------|
| charAt(int index)                                      | char         | 
| length()                                               | int          |
| equals(Object anObject)                                | boolean      |
| compareTo(String anotherString                         | int          |
| toCharArray()                                          | char[]|
| toLowerCase(), to UpperCase()                          | String|
| contains(CharSequence s)                               | boolean|
| replace(CharSequence target, CharSequence replacement) | String|
| split(String regex)                                    |String[]|
| substring(int beginIndex, int endIndex)                | String|
| indexOf(int ch, int fromIndex)                         | int|
<br>

### Time Complexity
- 시간 복잡도: 입력 크기에 비해 수행 시간이 얼마나 걸리는지
  - 주로 `Big-O` 표기법 사용
  - 정의된 입력 데이터 중 가장 최악의 상황을 포함한 시간의 상한선
  - 편의상 1초에 약 1억번의 연산을 기준으로 소요시간 가늠

```
int N = str.length();
for (int i = 0; i < N; i++) {
    int alphabetIndex = str.charAt(i) - 'A';
    count[alphabetIndex]++;
}
```
> 시간 복잡도 분석
> - 반복문 조건식 검사: N + 1 번 <br>
> - 반복문 증감식: N 번 <br>
> - 반복문 내부 식: 2 * N <br>
> 
> 총합: O(4N + 2)  --[상수 제거]-->  O(N) 
<br>

> 시간 복잡도 추론
> - 1 < logN < $\sqrt{N}$ < N < NlogN < $N^2$ < N!

<br>

### Array
- 생성과 동시에 크기가 고정
- 데이터가 메모리상에 일렬로 저장

**배열의 연산**
1. get
   - 메모리가 연속적이기 때문에 배열의 시작 주소로부터 떨어진 원소의 주소를 계산
   - `시작 주소 + index * 자료형` -> `O(1)`
2. change
   - `시작 주소 + index * 자료형` -> `O(1)`
3. append
   - 배열이 꽉 차있을 경우에는 더 이상 추가 불가
   - `배열 길이 검사 + 값 추가` -> `O(1)`
4. insert
   - 배열의 중간에 값을 추가
     - 원하는 인덱스부터 끝 인덱스까지 인덱스를 뒤로 한 칸씩 이동 후 추가
   - `최악의 경우 모든 인덱스를 이동` -> `O(N)`
5. erase
   - 배열의 중간 값을 삭제
     - 원하는 인덱스를 삭제 후 삭제된 인덱스 뒤부터 앞으로 한 칸씩 이동
   - `최악의 경우 모든 인덱스를 이동` -> `O(N)`

<br>

### Brute Force, Simulation
- 완전 탐색: 모든 경우의 수를 시도
  - 정답률 100% 보장
- 시뮬레이션
  - 요구사항을 확실히 분석

<br>

### Sort
- 데이터 집합을 적합한 순서로 배치하는 것

**정렬 알고리즘**
- $N^2$ 정렬 알고리즘
  - Bubble Sort, Selection Sort, Insertion Sort
- NlogN 정렬 알고리즘
  - Quick Sort, Merge Sort, Heap Sort
- 그외 알고리즘
  - Counting Sort, Radix Sort, Bucket Sort ...

**Arrays.sort**
- java.util 패키지
- 자료형
  - primitive[]
    - 오름차순 정렬
    - `un-stable`
    - `in-place`: 추가적인 메모리 공간을 거의 사용 X
    - Dual-Pivot Quick Sort -> 평균(NlogN), 최악($N^2$)
  - Object[]
    - 사전순 정렬
    - `stable`: 값이 같은 원소들의 기존 상대적 순서가 정렬 후에도 유지
    - Tim Sort(Merge Sort 기반) -> 평균(NlogN), 최악(NlogN)

**Set**
- java.util 패키지
- 중복된 원소를 가지지 않는 Collection
- add(), remove(), contains()
- 구현체
  - **HashSet**
    - Hash Table 기반의 un-ordered Collection
    - 삽입, 삭제, 조회 연산 -> 평균 O(1), 최악 O(n) 
    - null 저장 가능
  - **TreeSet**
    - Binary Search Tree 기반의 ordered Collection
    - 삽입, 삭제, 조회 연산 -> 항상 O(logN)
    - null 저장 X

**Map**
- java.util 패키지
- 중복된 key를 가지지 않고, <key, value> 쌍을 담는 Collection
- put(), remove(), containsKey()
- 구현체
  - **HashMap**
    - Hash Table 기반의 un-ordered Collection
    - 삽입, 삭제, 조회 연산 -> 평균 O(1), 최악 O(n)
    - null 저장 가능
    - key 순서가 보장 X
  - **TreeMap**
    - Binary Search Tree 기반의 ordered Collection
    - 삽입, 삭제, 조회 연산 -> 항상 O(logN)
    - null 저장 X
    - key가 `정렬된 순서`로 보장
  - **LinkedHashMap**
    - Hash Table + Double Linked List 기반의 ordered Collection
    - 삽입, 삭제, 조회 연산 -> 평균 O(1), 최악 O(n)
    - null 저장 가능
    - key가 `삽입된 순서`로 보장

<br>

### Prefix Sum
누적합 배열은 구간합 연산뿐만 아니라 [L, R] 구간의 연산 결과를 구하기 위해 [1, R] 연산에서 [1, L-1] 구간의 연산을 제거하는 복원작업이 가능한 다른 종류의 연산에도 적용할 수 있습니다.
> 교환법칙, 결합벅칙이 성립하며 역원이 존재하는 연산은 복원이 가능합니다. 
>  - 항등원: 연산에서 모든 원소와 연산해도 그 원소를 그대로 돌려주는 특별한 원소
>  - 역원: 어떤 원소와 연산했을 때 항등원을 만들어주는 원소

- **XOR(^) 연산**
  - 항등원: 0
  - 역원: 자기 자신
      > a ^ 0 = a <br>
        a ^ a = 0 <br>
        a ^ b ^ b = a
- **덧셈(+) 연산**
  - 항등원: 0
  - 역원: -a
- **곱셈(*) 연산**
  - 항등원: 1
  - 역원: 1/a

<br>

### 