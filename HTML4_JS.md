> HTML5 웹 프로그래밍 입문 `3판` - <저자 : 윤인성>, <출판사 : 한빛아카데미>

# 9장 자바스크립트 기본 문법

> 프로그래밍 언어에는 일반 언어와 스크립트 언어가 있다
>
> 스크립트 언어는 특정한 환경에서만 사용하는 언어다
>
> 자바스크립트는 html, 브라우저에서만 사용하는 언어이다 (GUI가 기반)
>
> 자바와 C언어가 섞인 객체기반 언어

- 기본용어
- 기본자료형과 연산자
- 조건문과 반복문
- 함수 선언과 호출
- 객체의 속성(field)과 메서드



## 자바스크립트 기본 용어와 출력 방법



### 자바스크립트 기본용어

> java와 다른 점 위주

- 데이터타입이 하나밖에 없음 `var`

- function으로 함수 생성



### 자바스크립트 출력

> javascript의 가장 기본적인 출력 방법은 alert()함수를 사용해 웹 브라우저에
>
> 경고창(팝업창)을 띄운다

- alert("")





## 자료형과 변수

> java와 다른 점 위주



### 자료형

- 숫자

- 문자열

  - 큰따옴표("")와 작은따옴표('') 같은 용도로 사용

- 불 (=논리연산자) 

  > 참(true)과 거짓(false)을 표현할 때 사용하는 자료

  - `bool`



### 변수

> java와 같이 선언과 초기화 필요

- 타입이 `var`밖에 없다.



## 조건문과 반복문

- 조건문 : if, else, else if 형식이 모두 같다
- 반복문 : while, for 형식이 모두 같다
  - 다만 `for(var i=0; i<반복횟수; i++){}`로 int가 아닌 var



### 함수

> 함수는 코드의 집합

#### 선언과 호출

> method의 선언과 다르게, **리턴타입을 적지 않는다**



##### 선언

- 익명 함수

  - 변수에 할당해 사용


```js
var funct = function (){
    alert("함수_A");
}
func;
```



- 선언적 함수
  - 파라메타를 `var x`라고 선언할 필요 없다.

```js
function square(x){
    return x*x;
}
```





##### 호출

> method에서 같은 클래스 내의 method를 호출하는 (this.)`메서드이름` 
>
> 것과 같이 `함수이름()` 으로 호출

```js
function test(){}
test()
```



#### 매개변수와 반환 값

```js
function test(t1,t2,t3){
    return t1+t2+t3;
}
```





#### 콜백 함수

```js
function callTenTimes(callback){
    for(var i=0; i<10; i++){
        callback();
    }
}

var callback = function(){
    alert('함수 호출');
};

callTenTimes(callback);
```





### 객체

> 자료형 여러 개를 한 번에 저장
>
> 인덱스와 키를 기반으로 자료 저장



#### 객체 개요

> 배열 : java와 다르게 선언 (선언시 [] 없음)

1. 인덱스 기반 : `var array = [273, 32, 103, 57, 52];`

   결과값 : array[0]	==> 273

2. 키 기반 :

   ```js
   <script>
   	var product = {
           제품명: '7D 건조 망고',
           유형: '당절임',
           prod: '7D 건조 망고',
           type: '당절임'
       };
   </script>
   ```

   결과값 : 

   ```js
   product['제품명']	==> '7D 건조 망고'
   product['유형']	==> '당절임'
   또는
   product.prod	==> '7D 건조 망고'
   product.type	==> '당절임'
   ```

   > 식별자 사용 조건에 어긋나는 식별자는 []를 사용해야한다



#### 속성과 메서드

> 배열에 있는 값 : 요소(element)
>
> 객체에 있는 값 : 속성(property)
>
> 자바스크립트에선 요소와 속성이 같아 구분 할 필요는 없음

- 메서드 : 객체 속성 중 자료형이 함수인 속성을 특별히 메서드라고 부름

```js
<script>
    var person={
        name : '윤인성',
        eat : function(food){
            alert(this.name+'이'+food+"을/를 먹습니다.");
        }
    };
    person.eat('밥');
</script>
```

알림창 내용 : `윤인성이 밥을/를 먹습니다.`

> name과 eat은 person객체의 속성이고
>
> eat은 메서드이기도 하다
>
> 자바 스크립트에서는 같은 객체 내의 속성을 불러올 땐 `this.`를 **생략하면 안된다**.





# 10장 문서 객체 모델

> document



## 문서 객체 모델의 기본 용어와 개념



- 문서 객체 (document object) : HTML의 태그를 자바스크립트에서 사용할 수 있게 해주는 객체
  - 따라서 문서 객체를 조작한다는 것은 태그를 조작한다는 뜻이다

- 노드 (node) : 웹 브라우저는 문서 객체를 트리 형태로 구성하고, 트리의 각 요소를 노드라고 한다
  - 노드는 요소 노드(element node)와 텍스트 노드(text node)로 구분한다



- 정적 생성
  - 웹 페이지를 처음 실행할 때 HTML 태그로 적힌 문서 객체 생성 (client)
- 동적 생성
  - 웹 페이지를 실행 중에 자바스크립트를 사용해 문서 객체를 생성 (server)
- 문서 객체 모델
  - 웹 브라우저가 HTML 파일을 분석하고 출력하는 방식



## 문서 객체 선택

> 이미 존재하는 HTML 태그를 자바스크립트에서 문서 객체로 변환하는 것을 '문서 객체를 선택한다'고 표현한다



- 1개 선택

  - `document.getElementById` : 아이디로 1개 선택
  - `document.querySelector` : 선택자로 1개 선택

- 여러개 선택

  > 반환되는 값은 배열이다
  >
  > 하지만 아래 `var eles`와 같이, js에선 배열선언을 따로 하지 않는다

  - `document.getElementsByName` : name 속성으로 여러 개 선택
  - `document.getElementsByClassName` : class 속성으로 여러 개 선택
  - `document.querySelectorAll` : 선택자로 여러 개 선택

```js
function idId(){
		alert('아이디가 확인되었습니다');
	}
	function getId(){
		var ele = document.getElementById("user_id");
		if(ele.value==""){
			alert("아이디를 입력하세요");
		} else{
			alert(id);
		}
	}
	
	function compare_password(){
		var pw1 = document.getElementById("pw1");
		var pw2 = document.getElementById("pw2");
		if(pw1.value==pw2.value){
			alert("확인되었습니다.");
		} else{
			alert("암호가 일치하지 않습니다.");
		}
		return false;
	}
	function check_radio(){
		var eles = document.getElementsByClassName("tools");
		for(var i=0; i<eles.length; i++){
			if(eles[i].checked){
				alert(eles[i].value);
			}
		}
	}
	function check_checkbox(){
		var eles = document.getElementsByClassName("langs");
		for(var i=0; i<eles.length; i++){
			if(eles[i].checked){
				alert(eles[i].value);
			}
		}
	}
```

> day19폴더의 실습 data_collection.html 실습에 쓰인 js폴더의 validate.js





## 문서 객체 조작

> jQuery로 대신 할 것





## 이벤트

> GUI환경에서 명령을 내리는 방법

- 마우스 이벤트
- 키보드 이벤트
- HTML 프레임 이벤트
- HTML 입력 양식 이벤트
- 사용자 인터페이스 이벤트
- 구조 변화 이벤트
- 터치 이벤트













# 서버와 클라이언트의 요청과 응답

- 클라이언트가 서버에게 데이터를 받는 방법

`Client`가 `Server`에 브라우저의 `HTML프로토콜`을 통해, `url`로 데이터를 `request`하면

> url로 데이터를 request하는 방식에는 get과 post가 있음

`Server`가 데이터를 `stream`을 통해 `response`한다

> 서버의 응답 ex) jsp의 out객체



- 서버가 클라이언트에게 데이터를 받는 방법

`Server`가 `HTML프로토콜`로 `request`하면, `Client`가 웹 브라우저를 통해 데이터를 입력한다.

`Client`가 입력한 데이터는 `form`의 `get`이나 `post`방식으로 `stream`을 통해 `Server`로 전달된다







