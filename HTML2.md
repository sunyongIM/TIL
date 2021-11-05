> HTML5 웹 프로그래밍 입문 `3판` - <저자 : 윤인성>, <출판사 : 한빛아카데미>

# 4장 HTML5 입력 양식 태그와 구조화 태그

> GUI를 기반으로 만든 HTML 특성상 유저 인터페이스는 모두 화면으로 돼 있다
>
> p95 의 그림을 참고할 것



## `<form>` 태그

> 입력 양식 태그 (사용자에게 정보를 입력받는 요소)

- 입력 양식의 시작과 끝을 표시한다.

  - name : key값 (map방식으로 데이터를 서버로 전달)

  - action : 전송 위치를 지정하는 속성 (url 연결, 데이터 전송)

  - method : 전송 방식을 지정하는 속성

    - method 방식에는 get과 post가 존재

      - 데이터를 전달하는 방식의 차이

      - get : 주소에 데이터를 직접 입력해 전달

        > url에 데이터를 입력하기에 데이터 크기에 제한이 있고
        >
        > url에 데이터가 나타나지만, 빠르고 편함

      - post : 별도의 방법을 사용해 데이터를 해당 주소로 전달

        > url에 나타면 안되는 정보를 가릴 수 있고
        >
        > 데이터 크기에 제한이 없다

```html
<body>
    <form method="get">
        <input type="text" name="search">
        <input type="submit">
    </form>
</body>
```



### `<input>` 태그 

> **`(닫는 태그 없음)`**
>
> 각 속성마다 구현되는 모양이 다르다.
>
> 화면으로 표시되는 과정을 렌더링(rendering)이라 하고
>
> 브라우저마다 적용되는 모양이 다르다
>
> > 공통적으로 사용하는 속성 : name, value, size
> >
> > name : 서버에 전달 할 데이터 이름 (키값)
> >
> > value : 서버에 전달 할 데이터 값 (입력받을 값)
> >
> > - 직접 작성시 디폴트처럼 활용가능 (ex. 홍길동)
> >
> > size : 공간의 크기 결정

- **type 속성**

  > 기본 입력 양식을 지정해주는 속성

  - text : 글자 입력 양식 생성
  - button : 버튼 생성
  - checkbox : 체크 박스 생성 (다중선택, 네모박스)
    - name을 통일 해줘야 한다
      - checked 속성 : 디폴트 값으로 선택되어있는 박스 지정
  - file : 파일 입력 양식 생성
  - hidden : 해당내용 표시 안 함
  - image : 이미지 형태 생성
  - password : 비밀번호 양식 생성
  - radio : 라디오 버튼 생성 (단일선택or배타적 선택을 위한 동그라미 선택지)
    - name을 통일 해줘야 한다
      - checked 속성 : 디폴트 값으로 선택되어있는 선택지 지정
  - reset : 초기화 버튼 생성 (페이지 새로고침)
    - 디폴트 값 : "원래대로"
  - submit : 제출 버튼 생성 (서버로 전달)
    - 디폴트 값 : "쿼리 전송"

```html
<body>
    <form>
        <input type="text" name="text" value="sunyong"><br>
        <input type="password" name="password" value="1234"><br>
        <input type="file" name="file" value="sunyong.html"><br>
        <input type="checkbox" name="checkbox" value="sunyong"><br>
        <input type="radio" name="radio" value=""><br>
    </form>
</body>
```



> 번외 : `<label>` 태그
>
> label 태그의 for속성에 input 태그의 id속성을 입력해서 두 값을 묶어줌



### `<select>` 태그

> 목록에서 선택할 수 있게 해준다

- multiple 속성 : 여러 목록을 선택하게 해주지만 웹에선 UI가 별로라서 지양하는 편

#### `<option>` 

> select 태그의 목록작성

- selected 속성 : 디폴트 값으로 선택되어있는 목록을 지정한다



```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data Collection</title>
<style type="text/css">
	table {
		border : solid 1px black;
		border-collapse : collapse;
	}
	

	td {
		border : solid 1px black;
		border-collapse : collapse;
	}

</style>
</head>
<body>
<!-- 3(column) X 10(row) 테이블 생성-->
<form action="" method="get">
	<table>
		<tr><td colspan="3">데이터수집</td></tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="user_name" value="kim"></td>
			<td></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="user_id" value="admin"></td>
			<td><input type="button" value="id검사"></td>
		</tr>
		<tr>
			<td rowspan="2">패스워드</td>
			<td><input type="password" name="pwd1" value="1234"></td>
			<td></td>
		</tr>
		<tr>
			<td><input type="password" name="pwd2" value="1234"></td>
			<td>
				<button>패스워드확인</button>
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<!-- <input type="text" size="3" name="phone_no1"> -->
				<select name="phone_no1">
					<option>--선택--</option>
					<option selected="selected">010</option>
					<option>051</option>
					<option>02</option>
				</select>
				-
				<input type="text" size="3" name="phone_no2">-
				<input type="text" size="3" name="phone_no3">
			</td>
			<td></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" size="10" name="email1">@
				<input type="text" size="12" name="email2">
			</td>
			<td>
				<select name="email">
					<option>--이메일 선택--</option>
					<option selected="selected">nate.com</option>
					<option>naver.com</option>
					<option>google.com</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>사용언어</td>
			<td>
				<input type="checkbox" name="langs" checked="checked">자바
				<input type="checkbox" name="langs" >파이썬
				<input type="checkbox" name="langs" >자바스크립트
				<input type="checkbox" name="langs" >C#
			</td>
			<td><button>다중선택확인</button></td>
		</tr>
		<tr>
			<td>사용툴</td>
			<td>
				<input type="radio" name="tools">이클립스
				<input type="radio" name="tools" checked="checked">메모장
				<input type="radio" name="tools">VSC
			</td>
			<td><button>단일선택확인</button></td>
		</tr>
		<tr>
			<td>비고</td>
			<td>
				<textarea rows="5" cols="30" name="etc"> 입력바랍니다
                </textarea>
			</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="전송">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
```



## 공간 분할 태그

> 레이아웃 구성을 위한, 웹 페이지의 공간 구분에 쓰이는 태그

### `<div>` 태그

> 블록 형식으로 공간 분할
>
> `<div>` 태그는 한 행을 모두 차지

블록 형식 태그의 다른 예시 

- `<h1>~<h6>` 제목 태그
- `<p>` 본문 태그
- `<ol>, <ul>, <li>` 목록 태그
- 테이블 태그

### `<span>` 태그

> 인라인 형식으로 공간분할
>
> `<span>` 태그는 내용물 만큼의 공간만 차지

인라인 형식 태그의 다른 예시 

- `<a>` 하이퍼링크 태그
- `<input>` 삽입 태그 (입력 양식 태그)
- `<b>, <i>, 등등` 글자형식 태그
- 입력 양식 태그



## 시맨틱 태그

> semantic-의미론적인
>
> 시맨틱 웹은 컴퓨터 프로그램이 코드를 읽고 의미를 인식할 수 있는 지능형 웹
>
> p110

**태그마다 위치와 목적이 정해져 있다.**

- `<header>` : 머리말 (페이지 제목, 페이지 소개)
- `<nav>` : 하이퍼링크들을  모아 둔 내비게이션
- `<aside>` : 본문 흐름에 벗어나는 노트나 팁 (광고가 있기도 함)
- `<section>` : 문서의 장이나 절에 해당하는 내용
- `<article>` : 본문과 독립적인 콘텐츠 영역
- `<footer>` : 꼬리말 (저자나 저작권 정보)

*HTML5 이전에는 시맨틱 태그 없이 div로 모든 정보를 처리하였다.*

*따라서 위치나 크기 목적을 구별하여 원하는 div를 찾아 넣어야해서 불편했다.*

