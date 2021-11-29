> HTML5 웹 프로그래밍 입문 `3판` - <저자 : 윤인성>, <출판사 : 한빛아카데미>

# HTML관련 단어

## URL

> Uniform Resource Locator

- **프로토콜 + 주소**
  - `jdbc:oracle:thin`:**(프로토콜)**@`localhost`**(사용자)**:`1521`**(포트번호)**:`xe`**(해당파일)**
- java에선 @로 프로토콜과 주소를 나눔
  - `http`:**(프로토콜)**//`localhost`**(주소)** :`9090`**(포트번호)**/`BasicWeb`**(웹 컨텍스트,서비스이름)**/`day16`**(파일위치)**/`welcome.html`**(해당파일)**



## URI

> Uniform Resource Identifier

- 웹에서 어떤 대상을 구분하는(해당 위치를 찾아가는) 방법의 총칭



## HTML

> Hipertext Markup Language

- 정보 구조를 다루는 웹 언어

- 현재 HTML표준은 HTML5이다



## CSS

> Cascading Style Sheets

- HTML페이지의 스타일을 지정하는 디자인 프로그램



### 브라우저(Browser)

> 웹 정보를 화면에 표시하는 소프트웨어

- 웹서버의 정보 조회 뿐 아니라, 하이퍼텍스트 문서 검색을 도와주는 응용 프로그램
- 기능 : 웹페이지 열기, 최근 방문한 URL목록 제공, 자주 방문하는 URL 기억 및 관리, 웹 페이지의 저장 및 인쇄 등



### WAS

> WEB Application Server

- Tomcat사용



# 2장 HTML5 기본 용어

## 요소와 태그

> 요소의 구분
>
> 내용을 가질 수 있는 요소 : <요소 이름> 컨텐츠(내용) </요소이름>
>
> - 여는태그(<`요소 이름`>) 와 닫는태그(</`요소 이름`>) 그리고 태그 사이에 컨텐츠를 가지고 있다.
>
> 내용을 가질 수 없는 요소 : <요소 이름/> or <요소 이름>  둘 다 같은 의미로 쓰인다
>
> - <img>, <hr>, <br/>
>
>   > 모두 닫는태그로 사용하는것이 원칙이다.

**HTML의 모든 동작이 태그를 기준으로 함**



## 속성

> **태그에 추가 정보나 부가 정보를 부여**할 때 사용하는 것
>
> p53참고

## 주석

> <!--주석-->



## HTML5 페이지 구조와 작성법



## HTML5페이지의 구조

```html
<!DOCTYPE html>			<!--웹 브라우저에 HTML5 문서라는 것을 알림, 반드시 첫 행에 나와야 함-->
<html>					<!--html이 가장 큰 바운더리의 태그이다, 이를 root라고 부른다-->
<head>					<!--body 태그에 필요한 스타일시트와 자바스크립트를 제공-->
<meta charset="UTF-8">
<title>Test</title>
</head>					<!--웹 브라우저에 표시하는 제목-->
<body>
						<!--사용자에게 실제로 보이는 부분-->
</body>
</html>
```



## 스타일시트 작성과 실행

> p58참고
>
> HTML5에선 같은 언어끼리 분리하여 코딩하는게 기본이며 (외부 작업 추천)
>
> 따라서	.html,	.css,	.js	파일이 별도로 생성된다

1. 내부 스타일시트 작성과 실행 - 추천하지 않음



2. 외부 스타일시트 작성과 실행

- link 태그를 사용하여 css를 html파일과 분리시킨다.



## 자바스크립트 작성과 실행

> p60참고

1. 내부 자바스크립트 작성과 실행 - 추천하지 않음



2. 외부 자바스크립트 작성과 실행 - 외부 스타일시트 작성 참조

- script 태그를 사용하여 js를 html파일과 분리시킨다.





# 3장 HTML5 기본 태그

> 마크다운 형식이 대부분 지원해주기에 많이 써본 기능들

## 글자 태그

> 제목과 본문 글자 태그

- `<h1>~<h6>` : 제목 태그 - head
- `<p>` : 본문 문단 생성 ;큰 엔터 - paragraph
- `<br>` : 줄 바꿈 (닫는 태그 없음) ;작은 엔터 - break
- `<hr>` : 수평 줄 삽입 (닫는 태그 없음) - horizontal rule
  - `<blockquote>` : 인용문을 넣는 태그
  - `<pre>` : 글자, 글꼴, 줄 바꿈을 입력한 그대로 출력하는 태그


> 글자모양 태그

- `<b>` : 굵은 글자 - bold
- `<i>` : 기울어진 글자 - italic
- `<small>` : 작은 글자
- `<sub>` : 아래 첨자 - subscript
- `<sup>` : 위 첨자 - superscirpt
- `<ins>` : 밑줄 글자 - insert
- `<del>` : 취소선이 그어진 글자 - delete



## 앵커 태그

### 하이퍼링크 생성(중요)

> HTML의 가장 중요한 기능인 하이퍼텍스트를 구현하는 태그

- a 태그이며 목적지를 알려주는 href(hyper reference)와 함께 사용한다.
- `<a href = "경로와 파일명"> 하이퍼링크의 이름 </a>`
- **경로를 나타내는 방법**
  - 현재 디렉토리 : `./`(생략가능)
  - 상위 디렉토리 : `../`
  - 윈도우 저장장치에선 **폴더**가 이동의 단위이다

```html
<a href="http://localhost:9090/BasicWeb/day16/welcome.html">welcome페이지로 연결</a>
<a href="../day16/hi.html"> hi.html로 이동 </a>
<!--상위폴더에 있는 day16폴더의 hi.html을 하이퍼링크-->
<a href="./page2.html">page2.html로 이동</a>
<!--같은폴더에 있는 page2.html을 하이퍼링크-->
```

- 페이지 내부이동 (책갈피)
  - `<a href="#point 1"> 1번 단락이동 </a>`
    - `<a id = "point 1"> 1번 단락</a>`
- target 속성 : 지정된 href 주소를 보여줄 웹 브라우저의 위치를 지정함
  - `<a href="" target = "_self"></a>`
    - 속성을 지정하지 않았을 경우의 디폴트값
    - 현재 보고 있는 페이지에서 href로 지정한 사이트로 이동
  - `<a href="" target = "_blank"></a>`
    - 새로운 창이나 새탭으로 보여줌
  - `<a href="" target = "_top"></a>`
    - 사이트 상단으로 이동 (페이지 내부이동)
- download 속성 : 지정된 href 주소를 보여주지 않고 파일로 다운받게 해줌
  - `<a href="" target = "download"></a>`





## 목록 태그

> 주로 내비게이션 메뉴를 만들 때 사용하는 목록

- `<ul>` : 순서가 없는 목록 생성 - unordered list 
  - type

- <= disc
  - <= circle
    - <= square
- `<ol>` : 순서가 있는 목록 생성 - ordered list
  - type
    - 1 (1,2,3,4)
    - a (a,b,c,d)
    - A (A,B,C,D)
    - i (i,ii,iii,iv)
    - I (I,II,III,IV)

- `<li>` : 목록 요소 생성 - list item

```html
<body>
    <ul>
        <li>사과</li>
        <li>바나나</li>
        <li>오렌지</li>
    </ul>
    <ol>
        <li>깨끗한 물에 씻고</li>
        <li>껍질을 까서</li>
        <li>먹는다</li>
    </ol>
</body>
```





## 테이블태그

> 표를 만들 때 사용, 표의 모양은 주로 css로 다듬는다
>
> p82참고

### `<table>` : 표 삽입

> 표의 시작과 끝에 위치한다

- border 속성 : 표의 테두리 두께 지정



#### `<tr>` : 표에 행 삽입 - table row

#### `<th>` : 표에 제목 셀 생성 - table heading

> 제목 셀은 일반 셀보다 글자가 두껍고 가운데 정렬이 되어있다

- colspan 속성 : 셀의 너비 지정
- rowspan 속성 : 셀의 높이 지정

#### `<td>` : 표에 일반 셀 생성 - table data

- colspan 속성 : 셀의 너비 지정
- rowspan 속성 : 셀의 높이 지정

> 셀의 기본 너비와 높이는 "1"이 디폴트이다.



```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>table</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>1열 제목 셀</th>
			<td>2열 일반 셀</td>
			<th>3열 제목 셀</th>
			<td>4열 일반 셀</td>
        </tr>				<!--<tr>부터 </tr>까지가 첫 번째 행-->
		<tr>
			<th colspan="2">1~2열 제목 셀</th>
			<td>3열 일반 셀</td>
			<td>4열 일반 셀</td>
		</tr>				<!--<tr>부터 </tr>까지가 두 번째 행-->
        
        <tr><td>1열</td><td>2열</td><td>3열</td><td>4열</td></tr>
        <!--세 번째 행-->
        <tr><td>1열</td><td>2열</td><td>3열</td><td>4열</td></tr>
        <!--네 번째 행-->
	</table>
</body>
</html>
```



## 미디어태그

> 이미지, 오디오, 비디오 등 멀티미디어를 삽집하는 태그

- `<image>` : 이미지 삽입
  - alt : 이미지가 없을 때 나오는 글자
- `<audio>`,`<video>` : 오디오, 비디오 삽입
  - preload : 로딩 중 데이터를 모두 불러올지 설정
  - autoplay : 자동 재생 여부 설정
  - loop : 반복 여부 설정
  - controls : 재생 도구 출력 여부 설정

> **image, audio, video모두 적용되는 속성**
>
> - **src : 경로지정 - 하이퍼링크의 href와 같은 작동방식**
> - width : 데이터의 너비 지정
> - hight : 데이터의 높이 지정







# 3-tier 프로그래밍 (웹 어플리케이션 모델)

> 알아둬야 할 네트워크 프로그래밍의 구조

​			Client							S(Application Server)				Database(Server)

 		프론트엔드				미들웨어				백엔드

WEB기술(HTML,CSS,Java Script)		 java		 	  	  		 	oracle



> (**Model-View-Controller**) MVC프로그래밍이라고도 한다

- Client (Front End)
  - View (Interface)
  - 사용기술 : WEB (HTML, CSS, Java Script, JSP)
- Application Server (Middleware)
  - Controller
  - 사용기술 : Java, jsp(잘 안쓰임)
- DB Server (Back End)
  - Model
  - 사용기술 : DB (Oracle)







---

> WEB의 소통 방식 설명 (HTTP5 프로토콜)

`client`   ==request==>   `미들웨어(Server)`   ==request==>   `백엔드(DB Server)`   ==response==>   `미들웨어(Server)`   ==response==>   `client`

- java와 oracle의 request, response는 jdbc를 통해 구현

  > (미들웨어 Server와 백엔드 Database Server의 통신)



---

서버도 자기책임성의 원칙을 적용 받는다.

하나의 서버는 하나의 서비스를 한다. (전문적)





