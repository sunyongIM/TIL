# 1일차 Git/GitHub

## 마크다운 문법

> 마크다운 : 문서를 구조화 하기 위한 간단한 문법을 가지고 있음
>
> 데이터를 정리하기 좋고 특히 코드를 삽입하기 편하기에 개발자들이 많이 사용

### 1. Heading

- #의 개수에 따라 h1~h6까지 표현가능
- 문서의 구조를 위해 작성되며 글자 크리를 조절하기 위해 사용해서는 안됨
- `실수로 발견했는데 ctrl+1~6으로도 됨`
- 보기-> 개략을 활용하기 쉬워짐 (ctrl+shift+1)



### 2. List

- List는  순서가 있는 리스트(ol)과 순서가 없는 리스트(ul)로 구성
- Tip) Typora에서 tab으로 하위항목, shift+tab으로 상위항목
- `<-- 이게 -를 활용한 (ul)리스트` (-이후 스페이스)
  - tab을 입력하면 하위 리스트가 만들어진다

1. 순서가 있는 리스트(ol)

2. 순서가 있는 리스트(ol)



### 3. Fenced Code block

- 코드 블록은 backtick 기호 3개를 활용하여 작성(```)
- backtick 기호는 키보드에서 1왼편에 있음 (shift와 누르면 ~물결무늬가 나옴)
- 코드 블록에 특정 언어를 명시하면 Syntax Highlight 적용가능

```java
System.out.println("hello");
```

```json
{
    "firstName": "Json",
    "lastName": "Smith"
}
```



### 4. Inline Code block

- 한줄 코드 블록은 backtick 기호 1개를 인라인에 활용하여 작성(`)

- 코드가 아니더라도 분리/강조하고 싶을때 사용가능

  `생각보다 많이 쓰일듯`

### 5. Link

- `[문자열](url)` 을 통해 링크를 작성 가능
- [Naver](https://naver.com) == `[Naver](https://naver.com)`
- ctrl+좌클릭으로 링크된 사이트로 이동가능

### 6. Image

- `![문자열](url)`을 통해 이미지 사용가능

- `![문자열](` 이후에 알아서 이미지파일 삽입 화면이 나옴

- 드래그앤드롭으로도 이미지 삽입 가능

  ![문자열](md-images/markdown_image-16328822537142.jpg)

  ![markdown_image](md-images/markdown_image-16328789865031.jpg)

### 7. Blockquotes (인용문)

- `>` 를 통해 인용문 작성
- 강조하거나 요약시 사용가능

> 인용문 내에서도 다양한 기능들 사용 가능 ex) [naver](https:naver.com)

### 8. Table (표)

- ctrl + t로 생성가능

- |과 ---를 통해서도 표 생성가능 (활용도 낮음)

  | ctrl+t 이후 열과 행을 선택     | tab과 엔터로도 이동가능 |
  | ------------------------------ | ----------------------- |
  | 최상단 열은 자동으로 굵은 글씨 |                         |

  

### 9. text 강조

- 굵게(bold), 기울임(Italic)을 통해 특정 글자들 강조
- *로 글자나 문장을 감싸면 됨
- *==> 기울임, **==>굵게

I just love **bold text**

Italicized text is the *cat's meow*.

A*cat*meow

### 10. 수평선

- 3개 이상의 asterisks (***), dashes (---), underscores(___) 사용

- 경계를 나눌때 사용하면 좋을듯

  

---



## Git

> **분산버전관리시스템 DVCS** (<==> 중앙집중식버전관리시스템)
>
> **파일 전체가 아닌 변경사항에 대한 버전관리**를 통한 효율화



![Git 작업공간](md-images/git%EC%9D%98%20%ED%9D%90%EB%A6%84.jpg)

> Git에서의 작업 공간은 Working directory - staging area - HEAD(version) 로 구성된다
>
> created / modified / deleted : Working directory에서 파일이 수정된 상태
>
> add : Working directory => staging area
>
> commit : staging area => HEAD
>
> 
>
> `commit시에는 반드시 작업자와 작업내용이 들어가야한다`
>
> <작업자 입력방법>
>
> $ git config --global user.email "이메일주소"
>
> $ git config --global user.name "이름"



### git 저장소 만들기

```bash
$ git init
Initialized empty Git repository in C:/Users/student/Desktop/test/.git/

(master) $
```

* `.git` 폴더가(숨김 항목으로) 생성되며, 버전이 관리되는 저장소
* git bash에서는 `(master)` 로 브랜치가 표기 된다.

### 파일 생성하기

```bash
$ touch a.txt
```

- `a.txt` 파일이 생성된다.
- 다른 확장자와 폴더 기타등등 생성가능

### 버전 만들기

#### `add`

> staging area 업데이트

```bash
$ git add <파일/폴더/디렉토리>
$ git add . # 현재 디렉토리 변경 모두
$ git add a.txt   # 특정 파일
$ git add folder/ # 특정 폴더 
$ git add *.png   # 특정 확장자
```

```bash
$ touch a.txt
$ git status
On branch master

No commits yet
# 트래킹되지 않는 파일 / Working directory
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        a.txt

nothing added to commit but untracked files present (use "git add" to track)
$ git add a.txt
$ git status
On branch master

No commits yet
# 커밋될 변경사항들!!! (Staging area)
Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   a.txt

```

#### `commit` 

> staging area를 HEAD로 업데이트 + 작업내역 알림 (version화)
>
> 작업자가 등록되어 있어야하고 작업내역을 입력해야한다.

```bash
$ git commit -m '작업내역'
```

```bash
$ git commit -m 'create a.txt'
[master (root-commit) 587c0cb] create a.txt
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 a.txt
```

작업내역 : 'create a.txt'



### 상태 관련 명령어



#### `status`

> Working directory와 staging area의 작업내역을 확인
>
> Git 저장소에 있는 파일의 상태를 확인하기 위하여 활용
>
> <파일의 상태>
>
> - Untracked files
> - Changed not staged for commit
> - Changes to be committed
> - **Nothing to commit, working tree clean**

```bash
$ git status
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        a.txt

nothing added to commit but untracked files present (use "git add" to track)
```

`$ git add a.txt 이전 :` => Untracked files에 **a.txt**는 붉은 글씨



```bash
$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   a.txt
```

`$ git add a.txt 이후 :` => Changes to be committed에 **new file:  a.txt**가 초록 글씨

Changes to be committed => 아직 committed되지 않은 변경사항



```bash
$ git commit -m 'create a.txt'
[master (root-commit) 587c0cb] create a.txt
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 a.txt
```

`$ git commit -m 'create a.txt' :` **'create a.txt'**라는 내용으로 HEAD에 commit

```bash
$ git status
On branch master
nothing to commit, working tree clean
```

`commit이후의 git status :` 모든게 업데이트 된 상태이므로 clean하다는 메시지

==>git status에 내용이 있다면 모든작업이 완료되지 않았다는 뜻



```bash
$ git status
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   a.txt

no changes added to commit (use "git add" and/or "git commit -a")
```

`a.txt을 수정한 이후 :`  Changes not staged for commit

수정사항 => staged(add) => commit 의 과정이 필요함



```bash
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   a.txt
```

`$ git add a.txt 이후 :` commit 과정이 필요함



```bash
$ git status
On branch master
nothing to commit, working tree clean
```

`$ git commit -m 'modify a.txt':` 'modify a.txt'의 내용으로 commit을 진행

다시 clean 하다는 메시지가 나온다.



#### `log`

> HEAD의 작업내역을 표시
>
> 현재 저장소에 기록된 commit을 조회 (commit 업데이트마다 생김)
>
> 다양한 옵션을 통해 로그를 조회할 수 있음

```bash
$ git log
$ git log -1
$ git log -oneline
$ git log -2 --oneline
```



### 기타문법

#### `ls` 

> 디렉토리의 파일/폴더 리스트 확인

#### `clear `

> 화면비우기
>
> `ctrl+l(알파벳 엘)`

#### `cd`

> 디렉토리 이동



## GitHub

> Git의 원격저장소
>
> 원격저장소는 GitHub사이트에서 직접 만들어야 한다

### 원격저장소 등록

`remote 추가 :` **$git remote add <이름> <url>**

```bash
$ git remote add origin https://github.com/sunyongIM/first.git
$ git push -u origin master
```

- git 원격저장소(remote)를 추가(add) 해줘. origin이란 이름(변수)에 url을 등록
- u : upstream 기본 원격/브랜치
  - 이후로는 git push만 해도 기본 원격/브랜치에 push 된다



### 원격저장소 확인

`remote 확인 : `**$ git remote -v**

 ```bash
 $ git remote -v
 origin  https://github.com/sunyongIM/first.git (fetch)
 origin  https://github.com/sunyongIM/first.git (push)
 ```



### 원격저장소 제거

`remote 제거 :` **$ git remote rm <이름>**

```bash
$ git remote rm origin
```



### push

> **commit**을 원격저장소에 업데이트
>
> (자동 push없음, 동기화 X )
>
> `버전이 일치하지 않을경우 :`(원격저장소의 업데이트가 반영되지 않았을경우) push 오류
>
> ==> pull하여 버전을 동기화 한 이후 다시 commit ==> push 해야한다 `= merge commit`

`remote 업데이트 :`**$ git push <원격저장소이름> <브랜치이름>**

```bash
$ git push 
```

### pull

> 원격 저장소로부터 변경된 내역을 받아와서 이력을 병합함
>
> commit 들만 받아온다

`remote 활용 :`**$ git pull <원격저장소이름> <브랜치이름>**



### clone

원격 저장소에서 zip파일로 다운로드 받으면 .git없이 파일만 받아짐(ver log가 없음)

`파일과 버전(.git) 가져오기 :` **$ git clone <url>**


