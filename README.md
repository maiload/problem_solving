# ps
- - -
# Part 1.
## String
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

## Time Complexity
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

## Array
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

**check 배열**
- 방문(존재) 여부 / 상태를 기록하기 위해 사용하는 배열
- boolean[] 이나 int[] 을 주로 사용
- 수의 범위를 배열의 크기로 설정
  - 배열 요소의 접근은 O(1)
  - ex. 1 ~ N 이라면 [N+1]로 설정

<br>

## Brute Force, Simulation
### 완전 탐색: 모든 경우의 수를 시도
  - 정답률 100% 보장
  - N개 중에서 M개를 고르는 경우 M중 for문이 필요 -> 재귀함수를 사용하면 가독성 향상
### 시뮬레이션
  - 요구사항을 확실히 분석

<br>

## Sort
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
    - 삽입, 삭제, 조회 연산 -> 평균 O(1), 최악 O(N) 
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
    - 삽입, 삭제, 조회 연산 -> 평균 O(1), 최악 O(N)
    - null 저장 가능
    - key 순서가 보장 X
  - **TreeMap**
    - Binary Search Tree 기반의 ordered Collection
    - 삽입, 삭제, 조회 연산 -> 항상 O(logN)
    - null 저장 X
    - key가 `정렬된 순서`로 보장
  - **LinkedHashMap**
    - Hash Table + Double Linked List 기반의 ordered Collection
    - 삽입, 삭제, 조회 연산 -> 평균 O(1), 최악 O(N)
    - null 저장 가능
    - key가 `삽입된 순서`로 보장

<br>

## Prefix Sum
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

## Binary Search
Q. N개의 원소를 가진 배열에서 X라는 값이 있는지 알고 싶다면? <br>
(또는 해당 값보다 작은/큰 값의 개수는?) <br>
(또는 해당 값의 근삿값은?)

A1. 모든 원소를 차례로 탐색: O(N) <br>

A2. `정렬` 후 Binary Search(이진 탐색): O(logN)
- 중간 값을 기준으로 크기를 비교해 탐색 범위를 절반씩 줄여가며 찾는 방법 
- **일치하는 값**
  - 일치하는 값의 경우 이진 탐색보다 HashSet 자료구조의 contains()를 사용하는 것이 더 빠르다 -> 평균 O(1)
  ```
  int search(int[] arr, int X) {
     int l = 0, r = arr.length - 1;     // 폐구간 패턴 [l, r]
     while (l <= r) {         
         int m = (l + r) / 2;
         if (arr[m] < X) l = m + 1;
         else if (arr[m] > X) r = m - 1;
         else return m;
     }   
     return -1;
  }
  ```
  ```
  int idx = Arrays.binarySearch(arr, x);
  // 값이 존재하면 index, 없으면 -1 반환
  ```
- **lowerBound, upperBound**
  - lowerBound: x이상 중 최소값
  - upperBound: x초과 중 최소값
  - 중복 값이 없는 경우에는 TreeSet 자료구조의 메서드를 사용할 수도 있습니다.
    - ceiling(x): x 이상 중 최소값 → lowerBound(x)
    - floor(x): x 이하 중 최대값
    - higher(x): x 초과 중 최소값 → upperBound(x) 
    - lower(x): x 미만 중 최대값
  > 최적값(최소/최대)을 구하는 문제는 모두 최소값을 구하는 문제로 변환이 가능
  > - 최소값: lowerBound
  > - 최대값: upperBound - 1
  ```
  int lowerBound(int[] arr, int x) {
      int l = 0, r = arr.length;     // 반폐구간 패턴 [l, r)
      while (l < r) {          
          int m = (l + r) / 2;
          if (arr[m] >= x) r = m;
          else l = m + 1;
      }
      return l;
  }
  
  int upperBound(int[] arr, int x) {
      int l = 0, r = arr.length;     // 반폐구간 패턴 [l, r)
      while (l < r) {          
          int m = (l + r) / 2;
          if (arr[m] > x) r = m;
          else l = m + 1;
      }
      return l;
  }
  ```
    > 폐구간 패턴, 반폐구간 패턴 선택 방법
    > - 원하는 값이 범위 내에 있으면 폐구간 패턴
    >   - `[l, r]`
    >   - while (l `<=` r)
    >   - `r = m - 1`, l = m + 1
    > - 원하는 값이 범위끝 + 1이 될 수 있으면 반폐구간 패턴: 
    >   - `[l, r)`
    >   - while (l `<` r)
    >   - `r = m`, l = m + 1

<br>

## Parametric Search
최적값 문제를 `값 X가 답이 될 수 있는가?` 라는 결정 문제로 바꾼 뒤, 그 값을 Binary Search를 사용하여 찾는 방법
- 문제 접근 방법
  1. 최소값인지, 최대값인지 확인
  2. 폐구간인지 반폐구간인기 확인
> 기존의 Binary Search와 다른 점은 처음 주어진 배열 arr의 원소 중에서 최적값을 찾는 것이 아닌, 별도의 구하고자 하는 값의 최적값을 찾아야 하는 점입니다.
> 따라서 l과 r의 범위를 직접 설정해야 합니다.
> - ex. 백준 2805: 주어진 나무의 높이 배열에서의 최적값이 아닌, 절단기에 설정할 수 있는 높이(h)의 최적값을 구하는 문제
