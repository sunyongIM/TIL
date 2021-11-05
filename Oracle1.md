# CRUD

## 테이블 CRUD

### C : CREATE

```
CREATE TABLE 테이블이름 (
	필드1	필드타입(메모리) 제약조건,
	필드2	필드타입(메모리) 제약조건,
	필드3	필드타입(메모리) 제약조건
);
```

- 스키마 설계시 제약 조건
  - PRIMARY KEY(FK, 기본키)
    - NOT NULL+UNIQUE = 비어있거나 중복되면 안된다.
  - FOREIGN KEY(PK, 외래키)
    - PRIMARY KEY를 참조하여 만든 자식 제약조건
    - 제약조건 마지막에 **REFERENCES ** `테이블이름(열이름)` 를 추가한다.
    - FK에 있지 않은 정보는 CRUD 할 수 없다.
  - UNIQUE
    - 중복이 있으면 안된다.
  - CHECK
    - 입력되는 데이터를 점검한다.
      - CHECK (`열이름`>0);
      - 0초과인 값들만 입력가능하다.
  - DEFAULT
    - NULL일 경우 들어갈 값이다.
    - INSERT대신 UPDATE를 사용가능하게 해준다.

  

  - NULL
    - 비어있어도 되는 값.
  - NOT NULL
    - 비어있으면 안 되는 값.

- 다른 제약조건은 해당하지 않으면 기입하지 않지만 NULL은 NOT NULL을 입력해줘야한다.



### R : 



### U : ALTER

- (테이블의 수정은 상당히 까다롭기에 차라리 DROP하고 새로 CREATE하는게 편하다.)

RENAME COLUMN

- 열의 이름변경

MODIFY

- 열의 데이터 형식 변경



### D : DROP

- DROP TABLE `테이블이름`



## 데이터 CRUD

### C : INSERT INTO

> INSERT는 테이블에 데이터를 삽입하는 명령어이다.
>
> 값들의 순서에 맞게 (데이터 타입과 메모리에 맞게) INSERT 해야한다.

- **INSERT INTO** `테이블이름(열1, 열2,...)` **VALUES**`(값1, 값2,...)`;
  - 열과 값의 개수와 타입이 같아야한다. (입력되지 않은 값은 NOT NULL이 아니어야한다.)
    - **INSERT INTO**  `tallTBL(userName, height)` **VALUES**`'sunyong',182` ;
- **INSERT INTO** `테이블이름` **VALUES**`(값1, 값2,...)`;
  - 테이블이름 다음의 (열) 생략가능
  - 생략시 모든 VALUES를 입력해줘야한다.



#### SEQUENCE

> 값을 자동으로 증가시켜주는 변수로 사용한다.

- CREATE SEQUENCE `sequen`

  START WITH 1

  INCREMENT BY 1;

  - sequen변수는 1부터 시작해서 하나씩 커지는 변수이다.
  - 주로 인덱스 번호와 같이 순서대로 중복되지 않는 값을 입력하고 싶을때 사용한다.





### R : SELECT... FROM

> SELECT는 데이터베이스 내의 테이블에서 원하는 정보를 추출하는 명령어이다.
>
> 정보의 선택적 **출력**에 사용

- **SELECT** `열 이름` **FROM** `테이블이름` **WHERE** `조건`;

``` 
SELECT 열 이름1, 열 이름2,...
FROM 테이블이름
WHERE 조건;
```

- **SELECT * FROM** `테이블이름`; : 테이블에 있는 모든 데이터값을 불러옴



#### BETWEEN...AND와 IN() 그리고 LIKE

> BETWEEN...AND는 연속적인 값(숫자)의 사이값을 편하게 확인하기 위해 사용
>
> IN은 연속적인 값이 아닌 이산적인 값을 조회하기 위해 사용
>
> LIKE는 원하는 값이 포함된 데이터들을 조회하기 위해 사용

- **SELECT** `열 이름` **FROM** `테이블이름` **WHERE**  `height>=180` **AND** `height<=183;`
- **SELECT** `열 이름` **FROM** `테이블이름` **WHERE** `height` **BETWEEN**`180` **AND** `183`;
  - height이 180이상이고 183이하인 조건
- **SELECT** `열 이름` **FROM** `테이블이름` **WHERE**  `height` **IN** (`180, 181, 185 `);
- **LIKE `연산자 % _`**
  - **SELECT** `열 이름` **FROM** `테이블이름` **WHERE** `userName` **LIKE**`'김%'` ;
    - userName이 '김'이 제일 앞글자이기만 하면 추출
  - **SELECT** `열 이름` **FROM** `테이블이름` **WHERE** `userName` **LIKE**`'_김'` ;
    - userName이 제일 뒤 한글자가 '김'인 것을 추출 



#### ANY/ALL/SOME 그리고 서브쿼리(SubQuery, 하이쿼리)

> 서브쿼리란 쿼리문 안에 또 쿼리문이 들어있는 것을 얘기한다.

- **SELECT**  `userName, height` **FROM** `userTBL` **WHERE** `height  > 177`;

- **SELECT**  `userName, height` **FROM** `userTBL` 

  **WHERE** `height  > (SELECT height FROM userTBL WHERE userName = '김경호')`;

  - userName이 '김경호'인 사람의 height이 177이라면 두 문장은 같은 의미이다.
  - 괄호내의 조건이 하나의 값만을 가르키는게 아니라면 오류가 생긴다.

- **SELECT**  `userName, height` **FROM** `userTBL` 

  **WHERE** `height > ANY (SELECT height FROM userTBL WHERE userName = '김경호')`;

  - 괄호 앞에 ANY나 ALL을 SOME을 사용해야한다.
    - ANY = SOME = OR
    - ALL = AND




#### ORDER BY

> 원하는 순서대로 정렬하여 출력

- **SELECT**  `userName, height` **FROM** `userTBL` **ORDER BY** `height`;
  - height을 기준으로 오름차순으로 정렬된 userName과 height을 출력한다.
- **SELECT**  `userName, height` **FROM** `userTBL` **ORDER BY** `height`**DESC**;
  - height을 기준으로 내림차순으로 정렬된 userName과 height을 출력한다.



#### DISTINCT

> 중복된 것을 하나만 남긴다.

- **SELECT**  **DISTINCT** `height` **FROM** `userTBL` ;
  - 중복을 제거한 height을 출력



#### ROWNUM열과 SAMPLE문

> 조회하는 데이터 양을 조작하기 위하여 사용

- **SELECT**  `userName, height` **FROM** `userTBL` **ORDER BY** `height` **WHERE ROWNUM<=5**;
  - height을 기준으로 오름차순으로 정렬된 userName과 height을 5줄 미만으로 출력한다.
    - 원하는 등수까지만 출력하고 싶거나 데이터가 필요이상으로 많을때 사용한다.
- **SELECT**  `userName, height` **FROM** `userTBL` **ORDER BY** `height` **SAMPLE(10)**;
  - height을 기준으로 오름차순으로 정렬된 userName과 height 데이터의 10퍼센트를 출력한다.
    - SAMPLE(A)의 A값은 퍼센트이므로 A는 0초과 100미만의 값이어야 한다.



#### CREAT TABLE...AS SELECT

> 테이블을 복사해서 사용할 경우에 사용한다.

- **CREATE TABLE**  `새로운 테이블이름` **AS SELECT** `복사할 컬럼데이터` **FROM**`복사할 테이블이름`;



#### GROUP BY와 HAVING(WHEREx)

> 집계함수 **SUM**과 함께 여러행에 퍼져있는 값을 집계할때 사용한다.

- **SELECT**`userID` **SUM**(`amount`) **FROM** `테이블이름` **GROUP BY** `userID`;
  - userID의 여러 amount의 합을 출력한다.

- **SELECT**`userID` **SUM**(`amount`) **FROM** `테이블이름` **GROUP BY** `userID`

  **HAVING SUM**(`amount`) >100;

  - HAVING은 WHERE와 같게 조건을 제한하는데 쓰이는데 GROUP BY에선 HAVING을 사용하여야 한다.
  - WHERE를 사용하면 오류가 생기며, HAVING은 GROUP BY절 다음에 나와야한다.



#### ROLLUP(), GROUPING_ID(), CUBE() 함수

> 언급이 없으셔서 넘어감





### U : UPDATE... SET

>  기존에 입력되어 있는 값을 변경하기 위해서 UPDATE문 사용한다. 행단위로 변경한다.

```
UPDATE 테이블이름
	SET 열1=값1, 열2=값2,...
	WHERE 조건 ;
```

- 테이블 전체의 행을 변경할 시 WHERE 조건은 생략가능
  - **UPDATE** `buyTBL` **SET** `price` = `price` * 1.5;
    - buyTBL 테이블의 모든 price열의 값들을 1.5배한다.

### D : DELETE... FROM

> DELETE는 UPDATE와 거의 비슷한 개념으로, 행단위의 삭제를 실행한다.

- **DELETE FROM** `테이블이름` **WHERE** `FirstName = 'Peter'`;
  - FirstName이 'Peter'인 데이터를 모두 삭제한다.
- **DELETE FROM** `테이블이름` ;
  - 전체 데이터를 삭제한다. (테이블은 남아있음)



