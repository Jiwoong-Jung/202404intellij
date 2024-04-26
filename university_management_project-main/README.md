# 대학 학사정보시스템  University Management Project


<img src="https://github.com/seoyounglee0105/university_management_project/assets/122020520/289ddbbb-08ae-4cd3-80e5-a5e3661819b6">


## 🖥️ 프로젝트 소개
대학교에서 사용하는 학사정보시스템을 
CRUD 중심으로 가볍게 구현한 프로젝트입니다

* 시연 영상 (유튜브) : https://youtu.be/5GB5ImXzgPw

<br>

## 🕰️ 개발 기간
* 23.04.21 - 23.05.02 (총 12일)

<br>

## ⚙️ 개발 환경
- BackEnd :  `Java ee`  `JSP`  `SpringBoot`  `MySQL`
- FrontEnd :  `HTML5`  `CSS`  `JavaScript`
- Collaboration : `Git` `GitHub` `Collabee`

<br>

#### 의존성

    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.apache.tomcat.embed:tomcat-embed-jasper' 
    implementation 'javax.servlet:jstl' 
    implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.3.0'  
    runtimeOnly 'com.mysql:mysql-connector-j'
    runtimeOnly 'com.h2database:h2'
    implementation 'org.springframework.security:spring-security-crypto'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'

<br>

## 📝 테이블 명세서
https://docs.google.com/spreadsheets/d/1V0dfMHmOkO4njbHW736hQsvbJKE78YOYO9BSMa8UZVU/editgid=0

<br>

## 📌 주요 기능

#### 예비 수강 신청 (수강 장바구니)
- 대상 : 현재 학기에 재학 상태가 되는 학생
- 신청/취소할 때마다 강의 현재 인원 변경
- 신청 강의의 정원 초과 가능
- 최대 수강 가능 학점 초과 불가능 (최대 18학점)
- 신청자 본인의 시간표와 겹치는 강의 신청 불가능
- 페이징 처리, 검색 기능

#### 예비 수강 신청 → 수강 신청
- 수강 신청 기간이 되면 예비 수강 신청 목록을 확인함 <br>
  → 정원 >= 신청인원인 강의 : 예비 수강 신청 내역이 수강 신청 내역으로 자동으로 이월됨 <br>
  → 정원 < 신청인원인 강의 : 신청인원이 0으로 초기화되며, 학생이 직접 신청하도록 함
- 예비 수강 신청 내역이 있는 경우, 수강 신청 탭에 가장 먼저 출력되도록 함

#### 수강 신청
- 대상 : 현재 학기에 재학 상태가 되는 학생
- 신청/취소할 때마다 강의 현재 인원 변경
- 신청 강의의 정원 초과 불가능
- 최대 수강 가능 학점 초과 불가능 (최대 18학점)
- 신청자 본인의 시간표와 겹치는 강의 신청 불가능
- 페이징 처리, 검색 기능

<br>

<table>

<tr>
  <td>예비 수강 신청</td>
  <td>수강 신청</td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/5343ee54-d34e-461e-abaf-407f2b033599/img.gif"></td>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/edf7586b-1a7b-44f7-b014-0a49e92d40de/img.gif"></td>
</tr>
</table>

<br>

## 📖 기능 - 공통

#### 로그인
- 세션 처리
- 아이디 찾기
- 비밀번호 찾기
- 아이디 저장 (쿠키 활용)

#### 개인 정보
- 개인 정보 조회
- 개인 정보 변경
- 비밀번호 변경

#### 공지사항 및 학사일정
- 공지사항 조회
- 학사일정 조회

<br>

<table>
<tr>
  <td>아이디/비밀번호 찾기</td>
  <td>개인 정보 변경</td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/8faacd26-1acd-4834-b89f-3e5bd684555d/img.gif"></td>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/8148aa3c-53ad-4981-8b5d-f0cce1c05a0a/img.gif"></td>
</tr>
</table>

<br>

## 👨🏻‍💼 기능 - 교직원

#### 학사관리
- 학생, 교수, 직원 계정 생성
- 학생, 교수 명단 조회
- 등록금 고지서 발송
- 휴학 처리(승인)
- 수강 신청 기간 설정
- 공지 CRUD
- 학사일정 CRUD

#### 등록관리
- 단과대학 CRUD
- 학과 CRUD
- 강의 CRUD
- 강의실 CRUD
- 등록금 CRUD

<br>

<table>
<tr>
  <td>학생/교수/직원 등록</td>
  <td>학생/교수 조회</td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/191e54e6-c249-4508-a1f1-070c556c8612/img.gif"></td>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/c4663c40-f909-43a4-a890-b0c43d420c01/img.gif"></td>
</tr>
<tr>
  <td>휴학 처리</td>
  <td>공지사항 CRUD</td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/855eb4be-d063-454e-8cde-2ee20cb89658/img.gif"></td>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/b10212db-facb-4740-8c18-77b66bb487a7/img.gif"></td>
</tr>
<tr>
  <td>학사일정 CRUD</td>
  <td>강의 CRUD</td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/d7dfc5df-bbbe-4949-96e0-1276276ec9cb/img.gif"></td>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/07eadf9a-c7e5-4e94-95b6-da872672236c/img.gif"></td>
</tr>
<tr>
  <td>단과대학 CRUD</td>
  <td>학과 CRUD</td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/369a91fa-5162-42b0-bd01-06c224cca2ce/img.gif"></td>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/12dd4364-804c-454f-bd8e-63b6b4f244ba/img.gif"></td>
</tr>
<tr>
  <td>등록금 CRUD</td>
  <td>강의실 CRUD</td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/1211897d-02e8-4f28-a919-404e24a09bba/img.gif"></td>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/987112c1-ff90-4023-aa34-e6244f82407f/img.gif"></td>
</tr>
</table>

<br>

## 👩🏻‍🎓 기능 - 학생

#### 등록 및 휴학
- 등록금 납부
- 등록금 납부 내역 조회
- 휴학 신청
- 휴학 신청 내역 조회

#### 수강 신청
- 강의 시간표 조회
- 예비 수강 신청
- 수강 신청
- 수강 신청 내역 조회

#### 성적
- 금학기 성적 조회
- 학기별 성적 조회
- 누계 성적

<br>

<table>
<tr>
  <td>등록금 납부</td>
  <td>휴학 신청</td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/1f356815-7a91-479c-b3bd-34f7448e2374/img.gif"></td>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/e3f6c575-b6ec-4654-9a17-ac195c768db0/img.gif"></td>
</tr>
<tr>
  <td>강의 시간표 조회</td>
  <td>예비 수강 신청</td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/9d7922f0-cfe1-452e-8975-7bc994dfa03f/img.gif"></td>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/4ed50753-be17-4028-aef1-0667b502562b/img.gif"></td>
</tr>
<tr>
  <td>수강 신청</td>
  <td>강의 평가</td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/15cd8477-a49f-4f34-9f33-fe968821cec7/img.gif"></td>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/d2bf1f2d-1451-47b4-9a69-12bc6b3166e5/img.gif"></td>
</tr>
<tr>
  <td>성적 조회</td>
  <td></td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/7a0a8623-0910-4f6b-a3d6-5817534d917b/img.gif"></td>
  <td></td>
</tr>
</table>

<br>

## 👨🏻‍🏫 기능 - 교수

#### 강의
- 내 강의 학기별 조회
- 강의계획서 수정
- 강의별 학생리스트 조회, 출결 및 성적 기입
- 강의평가 확인

<br>

<table>
<tr>
  <td>성적 입력</td>
  <td>강의 평가 조회</td>
</tr>
<tr>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/b9d917ca-5f3d-4366-ac1e-c9e4d791ee02/img.gif"></td>
  <td><img src="https://github.com/seoyounglee0105/university_management_project/assets/106488607/3073e61f-cdea-403e-8582-aa1883cb4a0e/img.gif"></td>
</tr>
</table>

<br>
