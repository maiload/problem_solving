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



