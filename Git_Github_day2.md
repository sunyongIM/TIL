# 브랜치 Branch

> 독립된 작업 흐름을 만들기 위하여 `branch`를 사용
>
> 작업이 완료가 되면 `merge` 를 통해 병합한다.

## 브랜치 생성

```bash
$ git branch <브랜치이름>
```

## 브랜치 이동

```bash
$ git checkout test
Switched to branch 'test'
(test) $
```

## 브랜치 생성 및 이동

```bash
$ git checkout -b test-1
Switched to a new branch 'test-1'
(test-1) $
```

## 브랜치 목록

```bash
$ git branch
* master
  test
```

## 브랜치 병합

```bash
(master) $ git merge test 
```

* 메인이 되는 브랜치로 이동한 이후 특정 작업 브랜치를 병합!

## 브랜치 삭제

```bash
$ git branch -d test
Deleted branch test (was 139169d).
```



## 브랜치 조작 연습

- **준비**

> 반드시 Root commit이 있는 상태에서 브랜치를 조작해야 합니다.

* 폴더를 만들고, README.md 파일을 만든 후 커밋을 해주세요.

### 상황 1. fast-foward

> fast-foward는 feature 브랜치 생성된 이후 master 브랜치에 변경 사항이 없는 상황

1. feature/index branch 생성 및 이동

   ```bash
   $ git checkout -b feature/index
   Switched to a new branch 'feature/index'
   (feature/index) $
   ```

2. 작업 완료 후 commit

   ```bash
   $ touch index.html
   $ git add .
   $ git commit -m 'Complete index page'
   $ git log --oneline
   15e4ff5 (HEAD -> feature/index) Complete index page
   139169d (master) Add README.md
   ```


3. master 이동

   ```bash
   $ git checkout master
   ```


4. master에 병합

   ```bash
   $ git merge feature/index
   Updating 139169d..15e4ff5
   Fast-forward
    index.html | 0
    1 files changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 index.html
   ```


5. 결과 -> fast-foward (단순히 HEAD를 이동)

   ```bash
   $ git log --oneline
   15e4ff5 (HEAD -> master, feature/index) Complete index page
   139169d Add README.md
   ```

6. branch 삭제

   ```bash
   $ git branch -d feature/index
   Deleted branch feature/index (was 15e4ff5).
   ```

---

### 상황 2. merge commit

> 서로 다른 이력(commit)을 병합(merge)하는 과정에서 다른 파일이 수정되어 있는 상황
>
> git이 auto merging을 진행하고, commit이 발생된다.

1. feature/style branch 생성 및 이동

   ```bash
   $ git checkout -b feature/style
   ```

2. 작업 완료 후 commit

   ```bash
   $ touch index.css
   $ git add .
   $ git commit -m 'complete index css'
   $ git log --oneline
   19e5346 (HEAD -> feature/style) Complete index css
   15e4ff5 (master) Complete index page
   139169d Add README.md
   ```

3. master 이동

   ```bash
   $ git checkout master
   ```

4. *master에 추가 commit 발생시키기!!*

   * **다른 파일을 수정 혹은 생성하세요!**

   ```bash
   $ touch hotfix.txt
   $ git add .
   $ git commit -m 'Hotfix'
   $ git log --oneline
   398e6c7 (HEAD -> master) Hotfix
   15e4ff5 Complete index page
   139169d Add README.md
   ```

5. master에 병합

   ```bash
   $ git merge feature/style
   ```

   

6. 결과 -> 자동으로 *merge commit 메시지창*

   * vim / vs code 편집기 화면이 나타납니다.
   * 자동으로 작성된 커밋 메시지를 확인하고, `esc`를 누른 후 `:wq` 엔터 입력하여 저장 및 종료를 합니다.
     * `w` : write
     * `q` : quit
   * 커밋  확인 해봅시다.

   ```bash
   $ git merge feature/style
   Merge made by the 'recursive' strategy.
    index.css | 0
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 index.css
   ```

7. 그래프 확인하기

   ```bash
   $ git log --oneline --graph
   *   c0023be (HEAD -> master) Merge branch 'feature/style'
   |\
   | * 19e5346 (feature/style) Complete index css
   * | 398e6c7 Hotfix
   |/
   * 15e4ff5 Complete index page
   * 139169d Add README.md
   
   ```

8. branch 삭제

   ```bash
   $ git branch -d feature/style
   ```

---

### 상황 3. merge commit 충돌

> 서로 다른 이력(commit)을 병합(merge)하는 과정에서 동일 파일이 수정되어 있는 상황
>
> git이 auto merging을 하지 못하고, 해당 파일의 위치에 라벨링을 해준다.
>
> 원하는 형태의 코드로 직접 수정을 하고 merge commit을 발생 시켜야 한다.

1. feature/about branch 생성 및 이동

   ```bash
   $ git checkout -b feature/about
   ```

2. 작업 완료 후 commit *추가적으로 README.md에 내용을 추가해주세요*

   ```bash
   # README.md 수정 후 저장
   $ touch about.html
   $ git status
   On branch feature/about
   Changes not staged for commit:
     (use "git add <file>..." to update what will be committed)
     (use "git restore <file>..." to discard changes in working directory)
           modified:   README.md
   
   Untracked files:
     (use "git add <file>..." to include in what will be committed)
           about.html
   
   no changes added to commit (use "git add" and/or "git commit -a")
   ```

   ```bash
   $ git add .
   $ git commit -m 'Update README ...'
   $ git log --oneline
   26d43b6 (HEAD -> feature/about) Update README & Complete about
   c0023be (master) Merge branch 'feature/style'
   398e6c7 Hotfix
   19e5346 Complete index css
   15e4ff5 Complete index page
   139169d Add README.md
   ```


3. master 이동

   ```bash
   $ git checkout master
   ```


4. *master에 추가 commit 발생시키기!!*

   * **동일 파일을 수정 혹은 생성하세요! (README에 내용을 아까와 다르게 작성해주세요) **

   ```bash
   # README 수정!
   $ git status 
   On branch master
   Changes not staged for commit:
     (use "git add <file>..." to update what will be committed)
     (use "git restore <file>..." to discard changes in working directory)
           modified:   README.md
   
   no changes added to commit (use "git add" and/or "git commit -a")
   
   ```

   ```bash
   $ git add .
   $ git commit -m 'Update README'
   $ git log --oneline
   83457a5 (HEAD -> master) Update README
   c0023be Merge branch 'feature/style'
   398e6c7 Hotfix
   19e5346 Complete index css
   15e4ff5 Complete index page
   139169d Add README.md
   ```

5. master에 병합

   ```bash
   $ git merge feature/about
   Auto-merging README.md
   # Confict!!!!!!
   # README.md에서 conflict!
   CONFLICT (content): Merge conflict in README.md
   # 자동 머지 실패; 충돌 고치고 커밋해
   Automatic merge failed; fix conflicts and then commit the result.
   (master|MERGING) $
   ```

   


6. 결과 -> *merge conflict발생*

   ```bash
   $ git status
   On branch master
   You have unmerged paths.
     (fix conflicts and run "git commit")
     (use "git merge --abort" to abort the merge)
   
   Changes to be committed:
           new file:   about.html
   # 충돌 파일!!
   Unmerged paths:
     (use "git add <file>..." to mark resolution)
           both modified:   README.md
   ```

   


7. 충돌 확인 및 해결

   ```
   <<<<<<< HEAD
   # 플젝
   
   * index
   
     * 스타일
   
   * 핫픽스
   
     
   =======
   # 프로젝트
   
   * about 작업
   >>>>>>> feature/about
   ```


8. merge commit 진행

   <add를 하여 commit할 준비를 하자>

   <merge commit은 comment를 쓰지 않는다>

   <visual studio code실행 ==> commit메시지가 있다는 뜻>

   ```bash
   $ git commit
   ```

   * vim 편집기 화면이 나타납니다.
   * 자동으로 작성된 커밋 메시지를 확인하고, `esc`를 누른 후 `:wq`를 입력하여 저장 및 종료를 합니다.
     * `w` : write
     * `q` : quit
   * 커밋을  확인 해봅시다.

   

9. 그래프 확인하기

   ```bash
   $ git log --oneline --graph
   *   0e37ffb (HEAD -> master) Merge branch 'feature/about'
   |\
   | * 26d43b6 (feature/about) Update README & Complete about
   * | 83457a5 Update README
   |/
   *   c0023be Merge branch 'feature/style'
   |\
   | * 19e5346 Complete index css
   * | 398e6c7 Hotfix
   |/
   * 15e4ff5 Complete index page
   * 139169d Add README.md
   
   ```


10. branch 삭제

    ```bash
    $ git branch -d feature/about
    ```

    



# undoing

## 1. add 취소

### 첫번째

```bash
$ git status
On branch master

No commits yet

Changes to be committed:
	# unstage 위해서..
	# git rm --cached <file>
  (use "git rm --cached <file>..." to unstage)
        new file:   README.md
        new file:   a.txt
```

```bash
$ git rm --cached a.txt
$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   README.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        a.txt

```

### 두번째

```bash
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   README.md
        modified:   a.txt

```

```bash
$ git restore --staged a.txt
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   README.md

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   a.txt
```

### 첫번째 두번째 다른 이유

> untracked vs changes not staged for commit

```bash
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   README.md
# 변경사항인데
# staged가 아닌 애들 (WD O)
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   a.txt

# untracked 파일들 (WD O)
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        sori.txt
```

## 2. Working directory 

> 작업 내용을 이전 버전 상태로 되돌리고 싶을 때

> 주의!!!! 해당 명령어를 실행한 이후 **절대로 다시 복원 불가능!!!**

```bash
$ git status
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  # 변경사항을 버리기 위해서는...
  # WD 있는거..
  (use "git restore <file>..." to discard changes in working directory)
        modified:   a.txt

no changes added to commit (use "git add" and/or "git commit -a")

```

```bash
$ git restore a.txt
```



## 3. 커밋 메시지 수정

> **공개된 저장소에 push 된 커밋은 절대 메시지 수정하지 말라!**
>
> => 커밋 해시값이 변경되기 때문에

```bash
$ git commit -m 'Adddd no.txt'
[master 7a81b6c] Adddd no.txt
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 no.txt

$ git commit --amend
hint: Waiting for your editor to close the file..[master c01f908] Add no.txt
 Date: Fri Jun 4 17:21:43 2021 +0900
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 no.txt

```

* visual studio code나 vim 등 커밋 메시지 작성 화면이 나온다.
* 여기에서 수정하고 저장하면 반영된다.

### 빠진 파일을 추가 커밋할 때..

```bash
student@M503INS MINGW64 ~/Desktop/last (master)
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   real.txt

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        omit.txt


student@M503INS MINGW64 ~/Desktop/last (master)
$ git commit -m 'omit & real'
[master ce16ecb] omit & real
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 real.txt

student@M503INS MINGW64 ~/Desktop/last (master)
$ git status
On branch master
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        omit.txt

nothing added to commit but untracked files present (use "git add" to track)

```

#### 해결!!

```bash
$ git add .
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   omit.txt
$ git commit --amend
hint: Waiting for your editor to close the file..[master ce77c2d] omit & real
 Date: Fri Jun 4 17:29:22 2021 +0900
 2 files changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 omit.txt
 create mode 100644 real.txt

```



# reset vs revert

## reset

> 커밋 히스토리 사라지니 주의 할 것

* `--hard` : reset 하기전 SA, WD 모든 작업 리셋
* `--mixed` : (기본) SA reset. WD 작업은 남겨둠
* `--soft` : reset 하기전까지 했던 SA, WD 작업은 남겨둠

```bash
$ git log --oneline
ce77c2d (HEAD -> master) omit & real
c01f908 Add no.txt
d547a8a !!!
d6109cf Add a.txt
585183f Add README

$ git reset --hard d547a8a
HEAD is now at d547a8a !!!

$ git log --oneline
d547a8a (HEAD -> master) !!!
d6109cf Add a.txt
585183f Add README

```

## revert

```bash
$ git log --oneline
d547a8a (HEAD -> master) !!!
d6109cf Add a.txt
585183f Add README

$ git revert d547a8a
Removing sori.txt
hint: Waiting for your editor to close the file..[master 6487ffd] Revert "!!!"
 3 files changed, 11 deletions(-)
 delete mode 100644 sori.txt

$ git log --oneline
6487ffd (HEAD -> master) Revert "!!!"
d547a8a !!!
d6109cf Add a.txt
585183f Add README

```

 # gitignore

> Git으로 추적하지 않을(무시할) 파일 또는 폴더를 설정
>
> 주로 개인정보가 있거나, 메모리가 높은 데이터베이스 파일을 무시

`.gitignore` 파일에 아래와 같이 설정

```bash
# 특정 파일
data.csv
user.xlsx
# 특정 폴더
secret/
# 특정 확장자
*.bmp
```

* 일반적으로 `OS(운영체제 - mac, windows)` , 특정 언어, 특정 개발 환경(파이참, vs code, eclipse, ...)

  * https://github.com/github/gitignore/blob/master/Python.gitignore

  * https://gitignore.io

    ![image-20210706111546066](md-images/image-20210706111546066.png)

  * 예시

    ```
    # Created by https://www.toptal.com/developers/gitignore/api/windows,python,pycharm
    # Edit at https://www.toptal.com/developers/gitignore?templates=windows,python,pycharm
    
    ### PyCharm ###
    # Covers JetBrains IDEs: IntelliJ, RubyMine, PhpStorm, AppCode, PyCharm, CLion, Android Studio, WebStorm and Rider
    # Reference: https://intellij-support.jetbrains.com/hc/en-us/articles/206544839
    
    # User-specific stuff
    .idea/**/workspace.xml
    .idea/**/tasks.xml
    .idea/**/usage.statistics.xml
    .idea/**/dictionaries
    .idea/**/shelf
    
    # AWS User-specific
    .idea/**/aws.xml
    
    # Generated files
    .idea/**/contentModel.xml
    
    # Sensitive or high-churn files
    .idea/**/dataSources/
    .idea/**/dataSources.ids
    .idea/**/dataSources.local.xml
    .idea/**/sqlDataSources.xml
    .idea/**/dynamic.xml
    .idea/**/uiDesigner.xml
    .idea/**/dbnavigator.xml
    
    # Gradle
    .idea/**/gradle.xml
    .idea/**/libraries
    
    # Gradle and Maven with auto-import
    # When using Gradle or Maven with auto-import, you should exclude module files,
    # since they will be recreated, and may cause churn.  Uncomment if using
    # auto-import.
    # .idea/artifacts
    # .idea/compiler.xml
    # .idea/jarRepositories.xml
    # .idea/modules.xml
    # .idea/*.iml
    # .idea/modules
    # *.iml
    # *.ipr
    
    # CMake
    cmake-build-*/
    
    # Mongo Explorer plugin
    .idea/**/mongoSettings.xml
    
    # File-based project format
    *.iws
    
    # IntelliJ
    out/
    
    # mpeltonen/sbt-idea plugin
    .idea_modules/
    
    # JIRA plugin
    atlassian-ide-plugin.xml
    
    # Cursive Clojure plugin
    .idea/replstate.xml
    
    # Crashlytics plugin (for Android Studio and IntelliJ)
    com_crashlytics_export_strings.xml
    crashlytics.properties
    crashlytics-build.properties
    fabric.properties
    
    # Editor-based Rest Client
    .idea/httpRequests
    
    # Android studio 3.1+ serialized cache file
    .idea/caches/build_file_checksums.ser
    
    ### PyCharm Patch ###
    # Comment Reason: https://github.com/joeblau/gitignore.io/issues/186#issuecomment-215987721
    
    # *.iml
    # modules.xml
    # .idea/misc.xml
    # *.ipr
    
    # Sonarlint plugin
    # https://plugins.jetbrains.com/plugin/7973-sonarlint
    .idea/**/sonarlint/
    
    # SonarQube Plugin
    # https://plugins.jetbrains.com/plugin/7238-sonarqube-community-plugin
    .idea/**/sonarIssues.xml
    
    # Markdown Navigator plugin
    # https://plugins.jetbrains.com/plugin/7896-markdown-navigator-enhanced
    .idea/**/markdown-navigator.xml
    .idea/**/markdown-navigator-enh.xml
    .idea/**/markdown-navigator/
    
    # Cache file creation bug
    # See https://youtrack.jetbrains.com/issue/JBR-2257
    .idea/$CACHE_FILE$
    
    # CodeStream plugin
    # https://plugins.jetbrains.com/plugin/12206-codestream
    .idea/codestream.xml
    
    ### Python ###
    # Byte-compiled / optimized / DLL files
    __pycache__/
    *.py[cod]
    *$py.class
    
    # C extensions
    *.so
    
    # Distribution / packaging
    .Python
    build/
    develop-eggs/
    dist/
    downloads/
    eggs/
    .eggs/
    lib/
    lib64/
    parts/
    sdist/
    var/
    wheels/
    share/python-wheels/
    *.egg-info/
    .installed.cfg
    *.egg
    MANIFEST
    
    # PyInstaller
    #  Usually these files are written by a python script from a template
    #  before PyInstaller builds the exe, so as to inject date/other infos into it.
    *.manifest
    *.spec
    
    # Installer logs
    pip-log.txt
    pip-delete-this-directory.txt
    
    # Unit test / coverage reports
    htmlcov/
    .tox/
    .nox/
    .coverage
    .coverage.*
    .cache
    nosetests.xml
    coverage.xml
    *.cover
    *.py,cover
    .hypothesis/
    .pytest_cache/
    cover/
    
    # Translations
    *.mo
    *.pot
    
    # Django stuff:
    *.log
    local_settings.py
    db.sqlite3
    db.sqlite3-journal
    
    # Flask stuff:
    instance/
    .webassets-cache
    
    # Scrapy stuff:
    .scrapy
    
    # Sphinx documentation
    docs/_build/
    
    # PyBuilder
    .pybuilder/
    target/
    
    # Jupyter Notebook
    .ipynb_checkpoints
    
    # IPython
    profile_default/
    ipython_config.py
    
    # pyenv
    #   For a library or package, you might want to ignore these files since the code is
    #   intended to run in multiple environments; otherwise, check them in:
    # .python-version
    
    # pipenv
    #   According to pypa/pipenv#598, it is recommended to include Pipfile.lock in version control.
    #   However, in case of collaboration, if having platform-specific dependencies or dependencies
    #   having no cross-platform support, pipenv may install dependencies that don't work, or not
    #   install all needed dependencies.
    #Pipfile.lock
    
    # PEP 582; used by e.g. github.com/David-OConnor/pyflow
    __pypackages__/
    
    # Celery stuff
    celerybeat-schedule
    celerybeat.pid
    
    # SageMath parsed files
    *.sage.py
    
    # Environments
    .env
    .venv
    env/
    venv/
    ENV/
    env.bak/
    venv.bak/
    
    # Spyder project settings
    .spyderproject
    .spyproject
    
    # Rope project settings
    .ropeproject
    
    # mkdocs documentation
    /site
    
    # mypy
    .mypy_cache/
    .dmypy.json
    dmypy.json
    
    # Pyre type checker
    .pyre/
    
    # pytype static type analyzer
    .pytype/
    
    # Cython debug symbols
    cython_debug/
    
    ### Windows ###
    # Windows thumbnail cache files
    Thumbs.db
    Thumbs.db:encryptable
    ehthumbs.db
    ehthumbs_vista.db
    
    # Dump file
    *.stackdump
    
    # Folder config file
    [Dd]esktop.ini
    
    # Recycle Bin used on file shares
    $RECYCLE.BIN/
    
    # Windows Installer files
    *.cab
    *.msi
    *.msix
    *.msm
    *.msp
    
    # Windows shortcuts
    *.lnk
    
    # End of https://www.toptal.com/developers/gitignore/api/windows,python,pycharm
    ```

    



