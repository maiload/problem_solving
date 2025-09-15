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
  - 주로 Big-O 표기법 사용
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
   - `시작 주소 + index * 자료형` -> O(1)
2. change
   - `시작 주소 + index * 자료형` -> O(1)
3. append
   - 배열이 꽉 차있을 경우에는 더 이상 추가 불가
   - `배열 길이 검사 + 값 추가` -> O(1)
4. insert
   - 배열의 중간에 값을 추가
     - 원하는 인덱스부터 끝 인덱스까지 인덱스를 뒤로 한 칸씩 이동 후 추가
   - `최악의 경우 모든 인덱스를 이동` -> O(N)
5. erase
   - 배열의 중간 값을 삭제
     - 원하는 인덱스를 삭제 후 삭제된 인덱스 뒤부터 앞으로 한 칸씩 이동
   - `최악의 경우 모든 인덱스를 이동` -> O(N)

<br>

### Brute Force, Simulation
- 완전 탐색: 모든 경우의 수를 시도
  - 정답률 100% 보장
- 시뮬레이션
  - 요구사항을 확실히 분석

<br>

### 