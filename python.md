> 뇌를 자극하는 파이썬 3	<박상현>	[한빛미디어]



## 스크립트 언어



## 데이터 타입 자동

type(`데이터`) 으로 확인가능





## 연산자

> 자바의 연산자와 동일 +

제곱 : **

나눗셈의 몫 구하기 (소숫점 내림) : //



### 논리 연산자

bool (boolean 아님)

True (true 아님)

False (false 아님)

or (|| 아님)

and (&& 아님)

#### 튜플

> ()
>
> 리스트의 readonly 버전

#### 리스트

> []

#### 딕셔너리

> {}



## import

> from `폴더명` import `파일명`

```python
import math

from test import welcome
```

- math.pi : 원주율
- math.e : 자연상수
- pow() : 제곱 연산
- sqrt() : 제곱근 연산



## 텍스트

> 파이썬의 문자열은 문자의 배열로 취급한다.

배열의 슬라이싱(Slicing)

```python
s = 'Good Morning'
s[0:4]			# == s[:4]
```

> 'Good'

```python
s = 'Good Morning'
s[5:12]			# == s[5:]
```

> 'Morning'

- **파라메타의 (숨겨진) 디폴트값이 있음**



## 확장자

> .py



## 함수

>두줄띄고 작성
>
>**들여쓰기(tab)로 종속관계를 구분한다**

```python
def test():
    plus = 1+2
    print(plus)
```





## 주석

> #



### 8월 달력만들기

```python
def viewCalendar():
    print("8월 \n일\t월\t화\t수\t목\t금\t토")
    for i in range(1, 32):
        if i%7!=0:
            print(i, end="\t")
        else:
            print(i)
```



### 윤년확인

```python
def isLeapYear(year):
    flag = False
    condition1 = year%400==0
    condition2 = year%4==0 and year%100 !=0
    if condition1 or condition2:
        flag = True
    return flag
```



> else if 대신 elif 사용가능

