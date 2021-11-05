> HTML5 웹 프로그래밍 입문 `3판` - <저자 : 윤인성>, <출판사 : 한빛아카데미>

# 5장 CSS3 기초: 선택자, 단위

> p125
>
> CSS : Cascade Style Sheets	(현재 버전: css3)
>
> 레이아웃 작업과 웹 디자인할때 사용
>
> **태그를 찾아가는 기술이 중요**



## CSS3 블록의 구조

`선택자`{ `스타일 속성` : `스타일 값`;}

```css
	table {
		border : solid 1px black;
		border-collapse : collapse;
	}
```

> 선택자 =  table
>
> 스타일 속성 = border, border-collapse
>
> 스타일 값 = solid 1px black, collapse





## CSS3 선택자 종류

> 선택자는 태그를 기준으로 작동한다
>
> **HTML에 입력한 CSS선택자는 js와 jquery도 공유하여 사용한다.** 
>
> cf) jsp에서만 name 선택자 사용
>
> id와 class와 name의 선택자 이름은 겹쳐도 상관없다.



### 기본 선택자

- 전체 선택자 : `*`

- 태그 선택자 : `태그 이름`

  > 선택된 태그가 중복해서 여러번 쓰였다면, 해당 태그들은 모두 선택된다

- 아이디 선택자 : `#아이디`

  > 특정한 태그 하나만 선택한다

  - 선택자는 목표한 태그 속에 기입한다.

- 클래스 선택자 : `.클래스`

  > 여러번 사용할 수 있으며, 기입된 태그들을 선택한다

  - 선택자는 목표한 태그 속에 기입한다.



### 속성 선택자

> 조건에 맞는 속성을 선택

- `선택자[속성]`, `선택자[속성=값]`, `선택자[속성~=값]` 등...



### 후손, 자손 선택자

- 후손 선택자 : `선택자 선택자`

  > `header h1` ==> header내의 모든 h1값

  - **여러개의 후손 선택자를 함께 사용할 시 주의사항**

  - header태그의 후손인 h1과, 일반태그 h2 선택 (실수할 경우)

    - ```css
      #header h1, h2{ color : red; }
      ```

  - header태그의 후손인 h1과, h2 선택

    - ```css
      #header h1, #header h2{ color : red; }
      ```

- 자손 선택자 : `선택자 > 선택자`

  > 태그 블록들이 다중일 경우 사용
  >
  > `header > h1` ==> header에 바로 아래 직계인 h1값



> 번외 : 반응, 상태, 구조 선택자
>
> 반응 선택자 : 마우스의 상태에 반응
>
> 상태 선택자 : 입력 양식의 상태 선택
>
> 구조 선택자 : 특정한 위치에 있는 태그 선택





## CSS3 단위



### 키워드 단위

> W3C에서 미리 정의한 단어



### 크기 단위

- % : 백분율 단위
- em : 배수 단위
- px : 픽셀 단위



### 색상 단위

- GRB 색상
  - rgb(red, green, blue)
  - 0~255사이의 숫자 입력
- RGBA 색상
  - rgba(red, green, blue, alpha)
  - RGB값에 투명도 추가 (alpha는 0.0에서 1.0이고 숫자가 커질수록 불투명도가 커짐)
- HEX 코드
  - #000000
  - RGB색상 단위를 짧게 입력하는 방식
  - 16진수로 입력 (디자이너들이 선호하는 방식)



### URL 단위

> 이미지나 자료 파일을 불러옴





# 6장 CSS3속성



## 박스 속성



### 박스의 크기와 여백

- width 속성 : 글자를 감싸는 영역의 가로크기

- height 속성 : 글자를 감싸는 영역의 세로크기

- border 속성 : 테두리

  - 테두리 둥글게 : border-radius (왼쪽 위 모서리부터 시계방향 )

- margin 속성 : 테두리와 다른 태그 사이의 **테두리 바깥쪽 여백**

- padding 속성 : 테두리와 글자 사이의 **테두리 안쪽 여백** (배경색은 padding영역에 적용)

  > margin과 padding, border의 공통 특징
  >
  > 1. `margin, padding, border`-`방향`
  >
  >    > 방향 설정가능 (방향 : left, right, top, bottom)
  >
  > 2. `margin, padding, border`: 10px 20px 30px 40px;
  >
  >    > 방향 설정없이 네 방향의 값을 입력하면 위쪽부터 시계방향으로 설정된다.
  >
  >    (top : 10px, right : 20px, bottom : 30px, left : 40px)
  >
  > 3. `margin, padding` : 10px 20px;
  >
  >    > 두 값만 입력했다면, 자동으로 첫번째 값은 (위+아래), 두번째 값은 (왼쪽+오른쪽)
  >    >
  >    > (top+bottom : 10px), (left+right : 20px)



## 가시 속성

> **display** 속성
>
> 태그가 화면에 보이는 방식을 지정

- none : 화면에 보이지 않음
- block : 블록 박스 형식으로 지정
- inline : 인라인 박스 형식으로 지정
- inline-block : 블록과 인라인의 중간 형태로 지정

```css
li{
    display: none;
}
```



## 배경 속성

> 생략

## 글자 속성

> 생략



## 위치 속성

> **position** 속성
>
> 요소의 위치 지정 형식을 설정

- 절대 위치 좌표
  - absolute : 절대 위치 좌표 설정
  - fixed : 화면을 기준으로 절대 위치 좌표 설정
- 상대 위치 좌표
  - relative : 초기 위치에서 상하좌우로 위치 이동
  - static : 위쪽에서 아래쪽으로 순서대로 배치

```css
.box{
    width: 100px;
    hight: 100px;
    position: absolute;
}
```

> 요소가 겹친다면, 기본적으로 뒤쪽에 작성한 태그가 상위에 올라간다.

- z-index 속성
  - 요소가 겹칠 때 아래로 내려갈 순서를 정한다. (z-index가 작을수록 뒤에 위치)



### **위치 속성 공식**

> p196참고



## 유동 속성

> **float** 속성
>
> 정렬, 배치를 통한 웹 페이지의 레이아웃 설계
>
> 한글파일에서 이미지의 '어울림' 기능과 같이 글과 이미지를 자연스럽게 배치 할 수 있다



## 그림자와 그레이디언트 속성

> 생략



# CSS 파일 연결 방법

- `<link rel="stylesheet" href="주소">`

```html
<link rel="stylesheet" href="../css/mystyle.css">
```





> JSP맛보기

클라이언트와 미들웨어의 통신

동적 처리를 위해 html에서 jsp를 사용

jsp의 

