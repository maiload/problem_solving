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
| compareTo(String anotherString)                        | int          |
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
> 교환법칙, 결합법칙이 성립하며 역원이 존재하는 연산은 복원이 가능합니다. 
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
- 중간 값을 기준으로 크기를 비교해 탐색 범위를 절반씩 줄여가며 찾는 방법 </br>

**Case 1. 일치하는 값**
  <details>
  <summary>code 보기</summary>
  
  - api
    ```
    int idx = Arrays.binarySearch(arr, x);
    // 값이 존재하면 index, 없으면 -1 반환
    ```
  
  - 구현  
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
  </details></br>
  
  > 일치하는 값의 경우 이진 탐색보다 HashSet 자료구조의 contains()를 사용하는 것이 더 빠르다 -> 평균 O(1)
  </br>
   
**Case 2. lowerBound, upperBound**
  | 내가 원하는 구간 | 경계 함수            |
  | --------- | ---------------- |
  | `x < n`   | `lower_bound(n)` |
  | `x ≤ n`   | `upper_bound(n)` |
  | `x ≥ n`   | `lower_bound(n)` |
  | `x > n`   | `upper_bound(n)` |

  - lowerBound와 upperBound 둘 다 **목표 구간의 다음 위치**를 반환하도록 설계해야 에러 처리가 쉽다.
    - 다음 위치(경계)는 항상 존재하는 값이기 때문에, **없음**도 0이나 N으로 자연스럽게 표현할 수 있다
    - 따라서 항상 `r = 마지막 인덱스 + 1` 로 설정

  ```
  static int search(int n, int[] arr) {
      int l = 0, r = arr.length;
      while (l < r) {
          int m = (l + r) / 2;
          if (원하는 구간) {
              l = m + 1;
          } else {
              r = m;
          }
      }
      return l;
  }

  static int search(int n, int[] arr, int l, int r) {
      while (l < r) {
          int m = (l + r) / 2;
          if (원하는 구간) {
              l = m + 1;
          } else {
              r = m;
          }
      }
      return l;
  }
  ```

<br>

## Parametric Search
최적값 문제를 `값 X가 답이 될 수 있는가?` 라는 결정 문제로 바꾼 뒤, 그 값을 Binary Search를 사용하여 찾는 방법
> 기존의 Binary Search와 다른 점은 처음 주어진 배열 arr의 원소 중에서 최적값을 찾는 것이 아닌, 별도의 구하고자 하는 값의 최적값을 찾아야 하는 점입니다.
> 따라서 l과 r의 범위를 직접 설정해야 합니다.
> - ex. 백준 2805: 주어진 나무의 높이 배열에서의 최적값이 아닌, 절단기에 설정할 수 있는 높이(h)의 최적값을 구하는 문제
- 문제 접근 방법
  1. 구하고자 하는 값의 범위를 설정: `[l, 마지막 인덱스 + 1)`
  2. 최소값: `lowerBound`, 최대값: `upperBound - 1`

<br>

## Two Pointer
배열이나 리스트 같은 연속된 자료구조에서 두 개의 인덱스를 관리하여 특정 조건을 만족하는 부분집합이나 특정 값을 찾는 알고리즘
- 시간 복잡도를 보통 O(N²)에서 `O(N)`으로 최적화 가능
- 문제 접근 방법
  1. 두 포인터(인덱스)를 배열의 시작/끝, 또는 같은 출발점에서 초기화
     - l = 0, r = 0;
     - l = 0, r = N - 1;
  2. 규칙에 따라 포인터를 이동
     - 같은 배열에서 동일한 방향으로 이동
     - 같은 배열에서 마주보는 방향으로 이동
     - 서로 다른 배열에서 이동
  3. 두 포인터 중 하나 혹은 둘 다 끝에 도달할 때까지 반복

- Pattern
  1. 같은 출발점
      ```
      int r = 0;
      for (int i = 0; i < N; i++) {
          while (r < N && 조건식) {
              // 코드
              r++;     
          }
      }
      ```
     > **Point.**
     > - 주로 이상/이하 조건에서 사용 (슬라이딩 윈도우)
     > 1. for문으로 인덱스(`int i`)로 `int l`을 대체하고, `int r = 0;`만 선언
     > 2. while 조건식: `r < N`, while문 내부에서 r값 증가: `r++`
  2. 시작/끝
      ```
      int l = 0, r = N - 1;
      while (l < r) {
          if (조건식) r--;
          else if (조건식) l++;
          else break;
      }
      ```
     > **Point.**
     > - 주로 정확한 매칭 조건에서 사용 (수렴 패턴)
     > 1. l과 r 모두 직접 선언: `int l = 0, r = N - 1;`
     > 2. while 조건식: `l < r`, while문 내부에서 l값 증가, r값 감소: `l++`, `r--`

<br>

## List
동일한 타입의 여러 원호를 선형 집합으로 관리하는 동적 데이터 구조
- 원소가 추가/삭제됨에 따라 크기가 변경될 수 있다.
- 구현체
  - **ArrayList**: index를 통한 원소 접근이 빠르지만, 원소의 삽입/제거가 느림
  - **LinkedList**: index를 통한 원소 접근이 느리지만, 원소의 삽입/제거가 빠름
  - Vector: ArrayList와 비슷하며 thread-safe 하기에 비교적 느릴 수 있음
- 순서가 있는 Collection 인덱스를 통한 원소 접근 가능
- 동일한 원소 저장 가능
- List Iterator 제공

1. **ArrayList**
- 동적 배열을 사용한 List 구현체
- [ArrayList 구현 예제](https://github.com/Acka1357/codingtest-java-20/blob/main/%EC%9A%94%EC%95%BD%EB%85%B8%ED%8A%B8/%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC_%EA%B5%AC%ED%98%84%EC%98%88%EC%A0%9C/MyArrayList.java)

2. **LinkedList**
- 차례로 연결된 Node를 사용한 구현체
- [SingleLinkedList 구현 예제](https://github.com/Acka1357/codingtest-java-20/blob/main/%EC%9A%94%EC%95%BD%EB%85%B8%ED%8A%B8/%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC_%EA%B5%AC%ED%98%84%EC%98%88%EC%A0%9C/MySingleLinkedList.java)
- [DoubleLinkedList 구현 예제](https://github.com/Acka1357/codingtest-java-20/blob/main/%EC%9A%94%EC%95%BD%EB%85%B8%ED%8A%B8/%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC_%EA%B5%AC%ED%98%84%EC%98%88%EC%A0%9C/MyDoubleLinkedList.java)

| Operations            | Array | ArrayList | LinkedList |
|-----------------------|-------|-----------|------------|
| get(int idx)          | O(1)  | O(1)      | O(N)       |
| add(E e)              | O(1)  | O(1)      | O(1)       |
| insert(int idx, E e)  | O(N)  | O(N)      | O(N)       |
| insert(Iter it, E e)  | O(N)  | O(N)      | O(1)       |
| remove(int idx)       | O(N)  | O(N)      | O(N)       |
| remove(int it)        | O(N)  | O(N)      | O(1)       |

- 실제 구현체에서는 insert() 대신 add()의 오버로딩 메서드로 제공됩니다.
> ArrayList의 add는 capacity가 다 찼을 경우 O(N)이나, 평균적인 복잡도는 O(1)로 볼 수 있습니다.

<br>

## Queue
먼저 넣은 데이터가 먼저 나오는 `선입선출` 자료구조 (`First-In First-Out`)
- 대기열의 가장 뒤에 원소가 추가되고, 가장 앞의 원소부터 처리
- 요청의 입력/도달 순서대로 처리하는 상황에 유용
- ex) 티켓팅 대기열, 프린터 출력 처리, 운영체제 스케줄링, 메세지 큐 등등

- Operations
  - **Insert**
    - add(e): 원소를 큐에 추가 (큐에 공간이 없다면 Exception 발생)
    - offer(e): 원소를 큐에 추가 (큐에 공간이 없다면 false 반환)
  - **Remove**
    - remove(): 큐의 head 원소를 제거하고 반환 (큐가 비었다면 Exception 반환)
    - poll(): 큐의 head 원소를 제거하고 반환 (큐가 비었다면 null 반환)
  - **Examine**
    - element(): 큐의 head 원소 반환 (큐가 비었다면 Exception 반환)
    - peek(): 큐의 head 원소 반환 (큐가 비었다면 null 반환)

1. LinkedList 기반의 Queue
   - enqueue: addLast를 사용해 리스트의 가장 마지막에 원소를 추가
   - dequeue: removeFirst를 사용해 리스트의 가장 앞 원소를 삭제
   - [구현 예제](https://github.com/Acka1357/codingtest-java-20/blob/main/%EC%9A%94%EC%95%BD%EB%85%B8%ED%8A%B8/%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC_%EA%B5%AC%ED%98%84%EC%98%88%EC%A0%9C/MyListQueue.java)
   - [사용 예제](https://github.com/Acka1357/codingtest-java-20/blob/main/%EC%9A%94%EC%95%BD%EB%85%B8%ED%8A%B8/%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC_%EC%82%AC%EC%9A%A9%EC%98%88%EC%A0%9C/Queue.java)
2. Array 기반의 Queue
   - enqueue: rearIndex에 원소를 추가하고, rearIndex를 이동
   - dequeue: firstIndex의 원소를 삭제하고, firstIndex를 이동
   - [구현 예제](https://github.com/Acka1357/codingtest-java-20/blob/main/%EC%9A%94%EC%95%BD%EB%85%B8%ED%8A%B8/%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC_%EA%B5%AC%ED%98%84%EC%98%88%EC%A0%9C/MyArrayQueue.java)

![img.png](img/img.png)

<br>

## Deque (Double Ended Queue)
양쪽 끝에 원소를 삽입/제거할 수 있는 양방향 Queue
- push/pop을 각각 addLast/removeFirst로만 이용하면 FIFO
- Queue는 단방향 List만으로 구현할 수 있지만, Deque는 prev/next를 모두 관리하는 양방향 List가 필요

- Operations
  - **Insert**
    - addFirst/addLast(E e): 원소를 덱의 대기열 앞/뒤에 추가 (덱에 공간이 없다면 Exception 발생)
    - offerFirst/offerLast(E e): 원소를 덱의 대기열 앞/뒤에 추가 (덱에 공간이 없다면 false 반환)
  - **Remove**
    - removeFirst/removeLast(): 덱의 대기열 가장 앞/뒤 원소를 제거하고 반환 (덱이 비었다면 Exception 발생)
    - pollFirst/pollLast(): 덱의 대기열 가장 앞/뒤 원소를 제거하고 반환 (덱이 비었다면 null 반환)
  - **Examine**
    - getFirst/getLast(): 덱의 대기열 가장 앞/뒤 원소 반환 (덱이 비었다면 Exception 발생)
    - peekFirst/peekLast(): 덱의 대기열 가장 앞/뒤 원소 반환 (덱이 비었다면 null 반환)

1. LinkedList 기반의 Deque
   - addFirst/addLast: 리스트의 가장 앞/뒤에 새 노드를 연결하여 추가
   - removeFirst/removeLast: 리스트의 가장 앞/뒤 노드에 대한 연결을 끊어 삭제
   - [구현 예제](https://github.com/Acka1357/codingtest-java-20/blob/main/%EC%9A%94%EC%95%BD%EB%85%B8%ED%8A%B8/%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC_%EA%B5%AC%ED%98%84%EC%98%88%EC%A0%9C/MyListDeque.java)
   - [사용 예제](https://github.com/Acka1357/codingtest-java-20/blob/main/%EC%9A%94%EC%95%BD%EB%85%B8%ED%8A%B8/%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC_%EC%82%AC%EC%9A%A9%EC%98%88%EC%A0%9C/Deque.java)
2. Array 기반의 Deque
   - addFirst/addLast: firstIndex/lastIndex에 원소를 추가하고 인덱스를 이동
   - removeFirst/removeLast: firstIndex/lastIndex의 원소를 삭제하고 인덱스를 이동
   - [구현 예제](https://github.com/Acka1357/codingtest-java-20/blob/main/%EC%9A%94%EC%95%BD%EB%85%B8%ED%8A%B8/%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC_%EA%B5%AC%ED%98%84%EC%98%88%EC%A0%9C/MyArrayDeque.java)

![img_1.png](img/img_1.png)

<br>

## Stack
마지막에 넣은 데이터가 먼저 나오는 `후입선출` 자료구조 (`Last-In First-Out`)
- java.util의 Vector를 상속받은 클래스
- 대기열의 가장 위에 원소가 추가되고, 가장 위의 원소부터 처리
- 기록을 쌓아가며 직전의 상태를 복원해야하는 상황에 유용
- ex) 웹 브라우저 뒤로 가기, 프로그램 실행 취소, 함수 호출 등등
> LIFO Stack의 경우 성능상 Deque 인터페이스를 사용하여 구현하는 것을 권장

- Operations
    - **Insert**
      - push(): 원소를 스택의 가장 위에 추가 (필요시 자동으로 크기 확장)
    - **Remove**
      - pop(): 스택의 가장 위의 원소를 제거하고 반환 (스택이 비었다면 Exception 발생)
    - **Examine**
      - peek(): 스택의 가장 위의 원소 반환 (스택이 비었다면 Exception 발생)

1. LinkedList 기반의 stack
   - push: addLast를 사용해 리스트의 가장 마지막에 원소를 추가
   - pop: removeLast를 사용해 리스트의 가장 뒷 원소를 삭제
2. Array 기반의 stack
   - push: topIndex를 증가시키고 원소를 추가
   - pop: topIndex의 원소를 삭제하고 topIndex를 감소
   - 사이즈를 따로 관리하지 않아도 topIndex를 통해 알 수 있다

![img.png](img/img_2.png)

> **Tip.** <br>
> 기본적으로 Queue, Deque, Stack에서 배열 기반의 `ArrayDeque` 구현체를 사용하는 것이 메모리 연속성 덕분에 메모리와 캐시 효율이 높고, 
> 포인터 오버헤드가 없어 LinkedList 기반의 구현체를 사용하는 것보다 빠릅니다.
> - Queue 메서드 제공: offer(), poll(), peek()
> - Deque 메서드 제공: addFirst(), addLast()
> - Stack 메서드 제공: push(), pop(), peek()
> 
> **주의할 점!** <br>
> ArrayDeque의 push()와 pop() 메서드는 Stack과 달리 head(앞쪽) 에서 요소를 추가하고 제거합니다.

<br>

## 재귀함수 (Recursion)
자기 자신을 호출하는 함수
- 사용 이유
  - 문제의 탐색 경로가 여러 갈래로 분기되어 트리(또는 그래프) 형태로 퍼지는 구조일 때
  - 하나의 커다란 문제를 작은 문제로 나누어 해결
  - 문제를 귀납적으로 생각하기 위해서
     - (i-1), (i-2)번째 결과를 활용하여 (i)번째 답을 구함
- **재귀함수의 인자**
  - 탐색해야할 위치 정보를 전달
  - 다음 분기가 시작되는 지점의 정보를 전달
  - 지금 내가 어디까지 왔는지 및 다음에 어디로 가야하는지
- 재귀함수 예시
  1. 재귀함수 이후 출력
     ![img.png](img/img_3.png)
  2. 재귀함수 이전 출력
     ![img_1.png](img/img_4.png)

> **Tip**. 재귀함수를 잘 설계하는 방법 <br>
> ![img.png](img/img_5.png) 
> - **Base Case**
>   - 일반적으로 재귀 호출이 필요 없는 마지막 입력값일 때의 케이스
>   - 재귀 호출을 멈추고 함수가 종료되는 조건으로, 적어도 하나 이상의 Base Case가 존재해야 한다
> - **Recursive Case**
>   - 재귀 호출이 일어나는 부분으로, 함수가 호출될수록 Base Case에 수렴해야 한다
>   - > 재귀 호출 인자에 ++, -- 연산을 하게되면 형제 분기들이 사용할 부모 상태값이 오염되어 오답이 발생하니 (++x) 대신에 (x + 1)을 인자로 전달
>   - > 재귀 호출 인자로 전달될 공통된 값들은 클래스 변수로 선언하여 사용 
> > 중복 계산 방지를 위해 동일한 계산이 반복될 가능성이 있다면 메모리에 저장
> ![img.png](img/img_6.png)

<br>

## BackTracking
- 재귀를 이용해 답을 찾는 도중에 최적해의 가능성이 없어지면 탐색을 중단
- 가능성이 있는 경우를 '유망하다' 라고 표현
- 최악의 경우 완전탐색이 되지만, 랜덤성이 있는 데이터에서는 평균적인 시간 소요가 낮아짐

<br>

## 분할 정복
하나의 커다란 문제를 작은 부분 문제로 나누어 해결하고, 결과를 결합하여 원래 문제의 해를 구하는 알고리즘
- 처리 과정
  1. 분할(Divide)
  2. 정복(Conquer)
  3. 조합(Combine)

<br>

## Tip.
1. 알바벳 문자 저장
   ```
   char[] ch = {'A', 'B', 'C'};
   
   // 'A':0, 'B':1, 'C':2
   int[] arr = new int[3];
   for (int i = 0; i < 3; i++) {
     arr[i] = ch[i] - 'A';
   }
   ```
2. 숫자 문자 저장
   ```
   String str = "101101";
   
   // '0':0, '1':1, '2':2 ...
   int[] arr = new int[6];
   for (int i = 0; i < 6; i++) {
     arr[i] = str.charAt(i) - '0';
   }
   ```
3. 2차원 행렬 탐색
   ![img.png](img/img_12.png)
    > `주의!` 탐색할 좌표가 배열의 범위를 벗어나는지 확인 필요
    ![img_1.png](img/img_13.png)
4. 비트마스크
   - boolean 배열을 int 자료형의 비트를 사용해 나타내는 방법
   - **사용법**
     - 조회: `& (1 << n)`
     - true 대입: `|= (1 << n)`
     - false 대입: `&= ~(1 << n)`
     - true 카운트: `Integer.bitCount()`
     - 출력: `Integer.toBinaryString()`

<br>

## 순열 (Permutation)
집합 안에서 가능한 모든 조합을 나열하는 것
- 특징
  - 중복이 없는 n개의 원소 집합에서는 n!개의 순열이 생성됨
  - 중복된 원소가 있는 경우에는 각 원소의 {중복횟수!}의 곱으로 나눈 값의 개수만큼 순열이 생성됨
  - ex) {1, 1, 2, 2, 2, 3}
    - 6! / (2! * 3! * 1!) = 60
      - 1의 중복 개수: 2
      - 2의 중복 개수: 3
      - 3의 중복 개수: 1

| 구분 | 중복 허용 | 순서 | 원소 중복 없음  | 원소 중복 있음                  |
| -- | ----- | -- | --------- | ------------------------- |
| ①  | ❌     | ❌  | nCr       | 중복 제거된 멀티셋 조합             |
| ②  | ❌     | ✅  | nPr       | n! / (a!b!c!... ) (중복 순열) |
| ③  | ✅     | ✅  | nʳ        | 원소별 최대 선택 수 제한 → 경우 나눔    |
| ④  | ✅     | ❌  | (n+r−1)Cr | 제한된 중복 조합 (원소별 개수 고려)     |


<br>

## 트리 (Tree)
- 특징
  - 그래프의 일종
  - 계층적인 자료 구조
  - 부모 - 자식 관계를 갖는 노드들의 집합
  - 최상위 노드가 루트
  - 사이클이 없는 비순환적인 구조
- 용어
  - **노드(Node)**: 트리를 구성하는 각각의 요소
  - **루트(Root)**: 트리의 최상위 노드
  - **부모 노드(Parent Node)**: 어떤 노드의 바로 위 노드
  - **자식 노드(Child Node)**: 어떤 노드의 바로 아래 노드들
  - **리프(Leaf)**: 자식 노드가 없는 노드
  - **서브 트리(Subtree)**: 트리 내에서 특정 노드를 루트로 하는 트리
  - **레벨(Level)**: 루트를 Level 1으로 하였을 때, 각 노드의 깊이

<br>

## 그래프
- 정의
  - ![img.png](img/img_7.png)
- 용어
  - **무방향 그래프**
    - 간선에 방향이 없는 그래프 (동일한 간선)
    - ![img_2.png](img/img_9.png)
  - **방향 그래프**
    - 간선에 방향이 있는 그래프 (서로 다른 간선)
    - ![img_1.png](img/img_8.png)
  - **정점의 차수(Degree)**
    - 정점에 연결된 간선의 수
    - 무방향 그래프: 정점의 차수와 간선의 수가 같음
    - 방향 그래프: **진입차수**(in-degree), **진출차수**(out-degree)로 나눠짐
  - **경로**
    - 정점을 연결된 간선을 따라 탐색하는 순서대로 나타낸 것
    - 사이클
      - 간선의 경로 중 시작 정점과 끝 정점이 동일한 경로
      - 사이클이 없는 그래프: 트리
        - > 그래프가 순환하지 않는다면 재귀호출(DFS) 시 별도의 baseCase가 필요 없다.
  - **가중치 그래프**
    - 간선에 가중치 혹은 비용이 할당된 그래프
    - 구현 시 객체(클래스)로 묶어서 표현하면 가독성이 좋다
      ```
      class Node {
        int node;  // 정점
        int cost;  // 간선 비용
      
        public Node(int node, int cost) {
          this.node = node;
          this.cost = cost;
        }
      }
      ```
  - **연결 요소**
    - 서로 도달할 수 있는 모든 정점들의 묶음

- 그래프 표현 방법
  1. **인접 행렬**
     - 일반적으로 2차원 배열을 이용하여 표현
       ```
       int[][] adj = new int[V+1][V+1];
       adj[src][dst] = 1;
       ```
     - 공간 복잡도
       - V개의 정점이 있다면, (V x V) 만큼의 공간을 사용
     - 시간 복잡도
       - 연결관계 조회/저장: O(1)
       - 정점에 연결된 모든 간선 조회: O(V)
     - ex)
       ![img_3.png](img/img_10.png)
 
  2. **인접 리스트**
     - 간선의 정보를 기반으로 저장하는 방법
       ```
       List<Node>[] graph = new List[V+1];
       for (...) {
         graph[i] = new ArrayList<Node>();
       }
       graph[src].add(dst);
       ```
     - 공간 복잡도
       - V개의 정점, E개의 간선이 있다면 (V + E) 만큼의 공간을 사용
     - 시간 복잡도
       - 연결관계 조회/저장: O(OutDegree(V))
       - 정점에 연결된 모든 간선 조회: O(OutDegree(V))
     - ex)
       ![img_4.png](img/img_11.png)
  > `인접 행렬` 방식은 정점의 수가 적고, 간선의 수가 많을 때 유리하고, <br>
  > `인접 리스트` 방식은 정점의 수가 많고, 간선의 수가 적을 때 유리하지만, <br>
  > 일반적인 상황에서는 간선이 밀집하게 있지 않기 때문에 **인접 리스트** 방식이 유리하다.

<br>

## DFS, BFS
- **DFS**
  - Depth-First Search
  - 한 방향으로 끝까지 탐색한 뒤, 막히면 되돌아가서 다른 길을 탐색하는 방식
  - 구현 방식
    - 재귀 호출
    - Stack
  - 특징
    - 경로 탐색, 백트래킹, 조합/순열 등에 자주 사용
- **BFS**: 
  - Breadth-First Search
  - 가까운 노드부터 차례대로 탐색하는 방식
  - 구현 방식
    - Queue
  - 특징
    - 최단 거리(가중치 없는 그래프) 탐색에 자주 사용
    - visited 배열을 사용해 `방문 여부`와 `Level(탐색 깊이)`를 확인
- **구분 방법**
  - 조기 종료 가능성이 있으면 BFS, 끝까지 다 확인해봐야하는 경우는 DFS

- `코드 예시`
  - **DFS (recursion)**
    ```
    static void dfsRecursion(int node) {
        visited[node] = true;
        for (int i = 0; i < n + 1; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfsRecursion(i);
            }
        }
    }
    ```
  - **DFS (stack)**
    ```
    static void dfsStack(int node) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.push(node);
        visited[node] = true;

        while (!ad.isEmpty()) {
            int now = ad.pop();
            for (int i = 1; i < n + 1; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    ad.push(i);
                    visited[i] = true;
                }
            }
        }
    }
    ```
  - **BFS (queue)**
    ```
    static void bfsQueue(int node) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.offer(node);
        visited[node] = true;

        while (!ad.isEmpty()) {
            int now = ad.poll();
            for (int i = 1; i < n + 1; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    ad.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    ```
    > **Tip. BFS와 visited** <br>
    visited는 미래 상태(정점)를 결정하기 위한 최소 정보 조합을 key로 갖습니다.
    > 1. 각 차원의 상한이 작고 확정: `다차원 배열`
    >   - 시간복잡도: O(1)
    >   - 공간복잡도: int[N][M][K] -> N x M x K x 4byte
    > 2. 상태가 집합 그 자체일 때: `비트마스크` + `다차원배열`
    >   - 비트연산으로 매우 빠르고 메모리 효율적
    >   - 비트마스크를 배열의 키로 사용
  
    > **Tip. BFS와 Level** <br>
    > 1. level이 미래 상태을 결정하기 위한 최소 정보일 때
    >    - 배열의 key로 사용
    >    - Queue에 level 정보를 같이 추가 (class 정의)
    > 2. level과 미래 상태가 무관할 때
    >    - 배열의 value로 사용
    >    - 시작점을 구분하기 위해 초기값을 -1로 설정
    >      - `Arrays.fill(visited, -1);`
    >    - 누적값 사용
    >      - `visited[next] = visited[cur] + 1;`
<br>

## DP (Dynamic Programming)
복잡한 문제를 작은 하위 문제로 나눠 해결하고, 그 결과를 조합하여 최종 해답을 얻는 알고리즘 설계 기법
- `핵심`
  - 현재 상태를 이전 상태들의 조합으로 표현하는 구조를 찾는 것 -> 점화식
    - 점화식이 한 눈에 보이지 않는 경우 n=1 부터 차례로 값을 구해보면서 그 규칙을 찾는다
- `특징`
  - 현재 결과 {i}가 이전 결과 {i-1},{i-2}등에 의존
    - Check: 현재 상태가 “최근 몇 개의 상태”로 표현되는가?
    - 현재 상태가 반드시 하나 이상의 이전 상태에 의존하는 형태로 표현되어야 한다
      - O: `dp[i] = Math.min(dp[i-1]+cost, dp[i-2]+cost2)`
      - X: `dp[i] = Math.min(dp[i-1]+cost, 독립적인 값)`
  - 최대 누적값, 최소 누적값, 경우의 수, 경로 수
    - 공통점: 이전 단계의 결과를 `누적`해서 현재를 만듦
  >최소/최대 누적값 문제의 경우 다음의 조건을 만족하면 DP가 아닌 그리디
  > - 이전 선택이 이후 결과에 영향을 미치는가?
  > - 현재의 최선이 전체의 최선이 될 수 있는가?
  > > 그리디 유형의 문제는 점화식을 사용하지 않고 주로 정렬(Sort) 하나로 해결이 된다
- 필수 조건
  - **최적 부분 구조**
    - 큰 문제의 최적 해가 작은 문제의 최적 해를 포함
    - ![img.png](img/img_14.png)
  - **중복 부분 문제**
    - 같은 부분 문제가 여러 번 반복되어야 함
    - ![img_1.png](img/img_15.png)
    > 부분 문제가 여러 번 반복되지 않는다면? <br>
    --> 반복되는 연산을 줄이는 목적에 부합하지 않는다

- 접근 방법
  1. **하향식 접근 (Memoization)**
     - 계산한 결과를 메모리에 저장하고 재사용
     - 재귀식 접근
     - 상대적으로 입력이 적은 경우에 사용
     - ex) ![img_2.png](img/img_16.png)
  2. **상향식 접근 (Tabulation)**
     - 하위 문제의 결과를 표에 저장
     - 입력이 많은 경우에 적합
     - 하위 문제가 한 번에 구해지지 않는 경우에 적합
     - ex1) ![img_3.png](img/img_17.png) 
     - ex2) ![img_5.png](img/img_19.png)![img_6.png](img/img_20.png)

> **Tip. DP 잘 짜는 법!**
> 1. 문제의 요구사항을 점화식의 결과가 되도록 유도
> 2. 문제를 작은 부분문제로 쪼갠다
>    - 단, {i} 번째 문제는 {i-k] 번째 부분문제로 활용할 수 있도록 쪼갠다
> 3. 동적 배열의 차원 수를 줄일 수 있는지 한 번 더 검토




