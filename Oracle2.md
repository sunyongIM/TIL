# Chapter 07

## PL/SQL고급

### ORACLE의 데이터 형식

> Database의 특징인 무결성을 지키기 위해 데이터들의 자릿수(n)를 정하고 
>
> 자릿수(메모리) 이상의 입력데이터는 받지 않는다.

- 숫자 데이터

  - NUMBER(p,s)
    - 전체 자릿수(p)와 소수점 이하 자릿수(s)를 가진 숫자형.
    - 정수만 사용할땐 s를 생략해도 된다.

- 문자 데이터

  - CHAR(n)

    > Character

    - 고정길이 문자형. (영문)
    - CHAR 만 사용하면 CHAR(1)과 동일하다.

  - NCHAR(n)

    > National Character

    - 유니코드 고정길이 문자형. (유니코드 : 영어뿐 아니라 다양한 언어를 저장할 수 있다.)
    - NCHAR 만 사용하면 NCHAR(1)과 동일하다.

  - VARCHAR2(n)

    > Variable Character

    - 가변길이 문자형. (영문)
    - CHAR(n)와 다르게, 입력데이터의 자릿수로 저장공간이 줄어든다.

  - NVARCHAR2(n)

    > National Variable Characer

    - 유니코드 가변길이 문자형.

  - CLOB

    > Character Long OBject

    - 대용량 텍스트 (영문)

  - NCLOB

    - 대용량 텍스트의 유니코드 데이터 타입

- 이진 데이터

  - BLOB
    - 대용량 이진(Binary) 데이터를 저장할 수 있는 데이터 타입

- 날짝와 시간 데이터 형식

  - DATE
    - 'YYYY/MM/DD HH:MM:SS' 와 같이 입력하면 2021/10/07 15:51:18 와 같이 출력된다.



### 데이터 형식의 변환

- 명시적 변환

  > CAST() ,TO_CHAR(), TO_NUMBER(), TO_DATE() 함수 사용
  >
  > FROM DUAL 은 형식을 맞추기 위한 **더미테이블**이다
  - SELECT TO_CHAR(12345, '$999,999') FROM DUAL;
    - '$12,345' 의 결과가 나온다,
  - SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MM:SS') FROM DUAL;
    -  2021/10/07 15:51:18 와 같이 현재시간이 출력된다.

- 암시적 변환

  - SELECT '100' + '200' FROM DUAL;	-- 문자+문자이지만 정수로 변환되서 연산 : 300
  - SELECT 100 || '200'  FROM DUAL;   -- 정수가 문자로 변환되어 처리된다 : 100200



## 조인

> 두개 이상의 테이블을 서로 묶어서 하나의 결과 집합으로 만들어 내는것.



#### INNER JOIN (내부 조인)

> 일반적으로 JOIN이라하면 INNER JOIN을 뜻한다.
>
> 여러테이블에 모두 존재하는 (NULL이 있는 데이터를 제외한)데이터들을 묶어준다. (무결성 유지)

- **SELECT** `열 목록`

  ​	**FROM** `첫 번째 테이블` 

  ​		**INNER JOIN** `두 번째 테이블`

  ​			**ON** `조인될 조건`

  **WHERE** `검색조건`;

  - `검색조건`에 맞는 `열 목록`을 조회하되,

     `첫 번째 테이블`과 `두 번째 테이블` 양쪽의 `조인될 조건`이 NULL이 없는 행만을 조회한다.

  - INNER JOIN을 그냥 JOIN으로 사용해도 된다.

- **SELECT** `열 목록`

  **FROM** `첫 번째 테이블` 

  ​	**INNER JOIN** `두 번째 테이블`

  ​	**ON** `조인될 조건`

  - (WHERE x) `열 목록`을 조회하되,  `첫 번째 테이블`과 `두 번째 테이블` 양쪽의 `조인될 조건`이 NULL이 없는 값만을 조회한다.

  > ON의 조인될 조건은 주로 PRIMARY KEY = FOREIGN KEY이다.

  

- 두 테이블의 열 이름이 같다면 소속테이블 표시를 해줘야한다.

```
SELECT buyTbl.userID, userName, prodName, addr
	FROM buyTbl
		INNER JOIN userTbl
			ON buyTbl.userID = userTbl.userID;
```

> buyTbl은 userID, prodName인 컬럼들을 가지고 있고
>
> userTbl은 userID, userName, addr인 컬럼들을 가지고있다.
>
> userID가 겹치기에 소속테이블을 buyTbl.userID로 정해주어야한다.
>
> > **실행결과**
> >
> > buyTbl테이블에 userTbl의 값을 추가하여 출력하는데,
> >
> > 출력값들은 buyTbl.userID, userName, prodName, addr 이며
> >
> > buyTbl.userID = userTbl.userID 인 조건들만 출력한다.

- 별칭(Alias)부여

> AS `별칭`  으로 사용하며 AS 생략가능
>
> 여러상황에 자주 사용한다.

```
SELECT B.userID, userName, prodName, addr
	FROM buyTbl AS B
		INNER JOIN userTbl AS U
			ON B.userID = U.userID;
```



#### OUTER JOIN (외부 조인)

> 조인의 조건에 만족되지 않는 행까지도 포함시키는 것 (NULL이 있는 행 포함)
>
> LEFT OUTER JOIN, RIGHT OUTER JOIN, FULL OUTER JOIN이 있으며 각각 좌측, 우측, 모든 테이블을
>
> 가르키며 그 테이블의 값은 NULL이라도 출력이 된다.

```
SELECT B.userID, userName, prodName, addr
	FROM buyTbl B
		LEFT OUTER JOIN userTbl U
			ON B.userID = U.userID;
```

- OUTER JOIN을 기준으로 `buyTbl`이 좌측 `userTbl`이 우측

---

`NULL값을 갖는 것` = NULL은 값이 없기에 비교가 불가능해 오류가 생기니,

`NULL값을 갖는 것` IS NULL 이라고 해야 논리 값이 나온다.