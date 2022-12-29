

# BookCommunityApp
안드로이드 스튜디오 코틀린을 이용한 독서기록 어플리케이션

---
## <목차>
### [1. 프로젝트 주제 및 개요](#프로젝트-주제-및-개요)
### [2. Wireframe](#wireframe)
### [3. 구현 요소](#구현-요소)
### [4. DB 설계](#DB-설계)
### [5. 구현 결과](#구현-결과)
### [6. 보완할 점](#보완할-점)
---

## 프로젝트 주제 및 개요

#### 1.1 주제

달력을 통한 독서기록과 익명 커뮤니티 App

#### 1.2 개요
 
 달력을 통한 간편한 독서기록과 익명 커뮤니티 게시판을 통해 책에 대한 정보를 공유하고 의사소통 할 수 있다. 
 
 <div align="center">
 
 ![image](https://user-images.githubusercontent.com/94541099/209927021-936d9608-dd13-4231-b1a1-0c73236ebba6.png)
 
 </div>
 
---

## Wireframe

<div align="center">
 
![image](https://user-images.githubusercontent.com/94541099/209928235-3bf5bec3-77ef-46c4-a13a-d20df1efe783.png)

</div>

---

## 구현 요소

1. 회원정보(회원, 비회원)에 대한 DB를 Firebase에 저장
2. Realtime Database를 이용해 콘텐츠 DB 연동
3. Realtime Database를 이용해 사용자의 북마크 DB 연동
4. Realtime Database를 이용해 사용자의 게시글 및 댓글 DB 연동
5. FirebaseStorage를 이용해 사용자의 게시글 사진 DB 연동

---

## DB 설계

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209933876-02fb7288-0e9e-42a6-9bc8-7b785c924034.png)

</div>

---

## 구현 결과

### 1. 회원가입 : 회원가입을 하면 Firebase에 회원정보가 저장되고 토스트 메시지와 함께 HomeFragment로 이동한다.
<br>

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209935235-59f65b46-e0e7-4224-ae44-c6716335fada.png)

</div>
<br><br>

### 2. 로그인 : 회원가입된 정보를 입력하면 토스트 메시지와 함께 HomeFragment로 이동
<br>

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209935352-81340e1b-806a-4236-afae-f64836b3c049.png)

</div>
<br><br>

### 3. 홈 화면 : 캘린더 밑에는 오늘의 추천 도서가 나오며 캘린더의 글쓰기 버튼을 누르면 나의 기록을 추가하는 액티비티로 이동한다.
<br>

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209935384-329e110b-607c-4f00-8355-be6409e533d0.png)

</div>
<br><br>

### 4. 캘린더 기록 : 기록을 원하는 날짜에 게시글을 적은 후 저장을 누르면 토스트 메시지와 함께 게시글이 저장된다.
<br>

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209935397-0c85548c-20b4-42c1-a9b5-d39b014240ca.png)

</div>
<br><br>

### 5. 캘린더 수정 : 저장된 기록에서 수정 버튼을 누르면 내용을 수정할 수 있다.
<br>

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209935425-6123202e-5a5e-4757-baf0-b3bb773f9fda.png)

</div>
<br><br>

### 6. 캘린더 삭제 : 저장된 기록에서 삭제 버튼을 누르면 내용을 삭제할 수 있다.
<br>

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209935456-c70103b8-0bfb-4880-b238-2528946673c6.png)

</div>
<br><br>

### 7. 커뮤니티 : 홈에서 게시판 네비게이션 클릭 시 BoardFragment로 이동되고 글쓰기 버튼으로 게시글 작성 가능
<br>

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209935483-a9dcb0fa-906e-4a36-8dfc-e0c34cb27467.png)

</div>
<br><br>

### 8. 게시글 작성 : 글쓰기 버튼 클릭 시 BoardWriteActivity로 이동하고 제목, 내용, 이미지 작성 후 입력 버튼을 누르면 토스트 메시지가 출력되고 RealtimeDatabase에 게시글 데이터가 저장된 후 게시글이 출력된다. FirebaseStorage에서 이미지 데이터를 업로드한다.
<br>

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209935509-596ba335-1e51-4d49-9457-58440f45f9d6.png)

</div>
<br><br>

### 9. 게시글 수정 : 본인이 작성한 게시글의 내용을 클릭 시 게시글 세부 내용에서 drawer menu클릭 후 게시글 수정 가능, 수정 버튼 클릭 시 토스트 메시지 출력 후 RealtimeDatabase에 데이터 변경
<br>

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209935544-9a8c1d2e-3350-471d-bfb9-e7ef62f33d5c.png)

</div>
<br><br>

### 10. 게시글 삭제 : drawer menu 클릭 후 삭제 버튼 클릭 시 해당 게시글 삭제, RealtimeDatabase에 해당 데이터 삭제
<br>

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209935580-b70ade0f-c53d-492a-b84c-75a7a5e2cd89.png)

</div>
<br><br>

### 11. 게시글 댓글 : 게시글 내용 클릭 시BoardIndiseActivity로 이동해 게시글 세부 내용 확인 가능, 댓글 입력란에 글 작성 후 글쓰기 버튼 클릭 시 RealtimeDatabase에 댓글 데이터가 저장 후 댓글 출력
<br>

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209935607-3322eb55-18ff-438f-b70b-45e16fb8c275.png)

</div>
<br><br>

### 12. 회원 정보 : 정보 네비게이션 버튼을 누르면 회원 이름과 이메일 등의 정보가 담겨있는 InfoFragment로 이동한다.
<br>

<div align="center">

![image](https://user-images.githubusercontent.com/94541099/209935644-0d2518b4-cb05-46f2-a95a-49053ed72918.png)

</div>
<br><br>

---

## 보완할 점

- UI/UX 수정하기
- 다양한 디자인 패턴을 고완해보기
- InfoFragment에서 내 정보(이름, 비밀번호 등) 변경하기
- InfoFragment에서 내가 원하는 이미지로 변경하기
- 회원 레벨, 귀여운 캐릭터를 키울 수 있는 기능 구현하기
- 게시판에 공지사항 작성할 수 있는 기능 추가 (관리자 기능)
- 달력에 쓴 내용을 ListView로도 보여줄 수 있도록 하는 버튼 추가, 구현하기
- 달력 메모, 게시판에서 원하는 검색어로 검색 구현하기
- 자잘한 버그 수정










