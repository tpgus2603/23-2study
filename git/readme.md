깃허브 툴 

git status 전체 로그 확인 git log git 저장소 생성하기

git init 저장소 복제 및 다운로드 git clone [https: ~~~~ ] 저장소에 코드 추가 git addgit add * 커밋에 파일의 변경 사항을 한번에 모두 포함 

git add -A 커밋 생성git commit -m "message" 변경 사항 원격 서버 업로드 (push)git push origin master 원격 저장소의 변경 내용을 현재 디렉토리로 가져오기

(pull)git pull 변경 내용을 merge 하기 전에 바뀐 내용 비교git diff [브랜치 이름] [다른 브랜치 이름]        Git Branch 관련 (생성, 브랜치 확인, push 까지의 과정 포함)

git init을 설정하면 해당 폴더에 .git 이라는 파일이 생성됨 git init github 주소와 연결 git remote add origin [github 주소] 브랜치 생성git branch [브랜치명] 해당 브랜치로 이동

git checkout [브랜치명] 브랜치를 생성하고 해당 브랜치로 바로 이동git branch -b [브랜치명] 원하는 브랜치로 이동했는지 확인 

git branch 모든 브랜치 확인 git brach -a 파일 및 폴더 addgit add . 커밋 git commit -m "commit message" 원하는 브랜치로 push하여 원격 서버에 전송

git push origin [브랜치명] 브랜치 삭제 git branch -d [브랜치 이름] 현재 브랜치에 다른 브랜치 수정사항 병합git merge [다른 브랜치 이름] 

Respository1

Folder1
Folder2
Folder3

이때 원격 저장소 Repository1의 Folder1에만 내 로컬 저장소를 연결하고 싶다면,
1. 로컬 저장소를 만들지 않았다면 생성하고 디렉토리로 이동한다.

$ mkdir algorithm
$ cd algorithm
2. 해당 디렉토리에서 git init으로 깃 초기화

$ git init
3. sparsecheckout 옵션 활성화

$ git config core.sparsecheckout true
4. 세부 디렉토리 추가

$ echo "Folder1/" >> .git/info/sparse-checkout
5. 원격 저장소 연결(추가)

$ git remote add origin 깃헙주소
6. pull 받기

$ git pull origin main
1~6번을 시행한 후에 내 로컬 저장소 algorithm에 들어가보면 원격저장소 Repository의 Folder1의 기존 파일이 저장되어있는 것을 확인할 수 있다.

이후 내 로컬저장소 algorithm에서 추가 작업한 내용을 원격저장소에 push하는 방법은 다음과 같다.

7. (add,commit은 완료되었다는 가정하에) push 하기

$ git push origin main
위와 같이 실행했더니 오류 발생해서 다음과 같이 진행

$ git push --set-upstream origin main
이렇게 push를 한 후 해당 원격저장소에 들어가보면 Repository1/Folder1에 해당 내용이 업데이트 되었음을 확인할 수 있다.

profile
졍
