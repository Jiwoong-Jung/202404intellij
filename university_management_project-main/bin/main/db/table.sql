-- 단과대
CREATE TABLE college_tb
(
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR (10) NOT NULL UNIQUE
);

-- 학과
CREATE TABLE department_tb
(
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR (10) NOT NULL UNIQUE,
   college_id INT NOT NULL COMMENT '단과대 id',
   FOREIGN KEY (college_id) REFERENCES college_tb (id) ON DELETE CASCADE
);
ALTER TABLE department_tb AUTO_INCREMENT = 101;

-- 사용자
CREATE TABLE user_tb
(
   id INT PRIMARY KEY,
   password VARCHAR (255) NOT NULL,
   user_role VARCHAR (10) NOT NULL
);

-- 학생
CREATE TABLE student_tb
(
   id INT PRIMARY KEY AUTO_INCREMENT COMMENT '학번',
   name VARCHAR (30) NOT NULL,
   birth_date DATE NOT NULL,
   gender CHAR (2) NOT NULL COMMENT '남성, 여성',
   address VARCHAR (100) NOT NULL,
   tel VARCHAR (13) NOT NULL,
   email VARCHAR (30) NOT NULL,
   dept_id INT NOT NULL COMMENT '학과',
   grade INT NOT NULL DEFAULT 1 COMMENT '학년',
   semester INT NOT NULL DEFAULT 1 COMMENT '학기',
   entrance_date DATE NOT NULL,
   graduation_date DATE,
   FOREIGN KEY (dept_id) REFERENCES department_tb (id) ON DELETE CASCADE
);
ALTER TABLE student_tb AUTO_INCREMENT = 2023000001;

-- 교직원
CREATE TABLE staff_tb
(
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR (30) NOT NULL,
   birth_date DATE NOT NULL,
   gender CHAR (2) NOT NULL COMMENT '남성, 여성',
   address VARCHAR (100) NOT NULL,
   tel VARCHAR (13) NOT NULL,
   email VARCHAR (30) NOT NULL,
   hire_date DATE DEFAULT (current_date)
);
ALTER TABLE staff_tb AUTO_INCREMENT = 230001;

-- 교수
CREATE TABLE professor_tb
(
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR (30) NOT NULL,
   birth_date DATE NOT NULL,
   gender CHAR (2) NOT NULL COMMENT '남성, 여성',
   address VARCHAR (100) NOT NULL,
   tel VARCHAR (13) NOT NULL,
   email VARCHAR (30) NOT NULL,
   dept_id INT NOT NULL,
   hire_date DATE DEFAULT (current_date),
   FOREIGN KEY (dept_id) REFERENCES department_tb (id) ON DELETE CASCADE
);
ALTER TABLE professor_tb AUTO_INCREMENT = 23000001;

-- 강의실
CREATE TABLE room_tb
(
   id VARCHAR (5) PRIMARY KEY,
   college_id INT NOT NULL,
   FOREIGN KEY (college_id) REFERENCES college_tb (id) ON DELETE CASCADE
);

-- 강의
CREATE TABLE subject_tb
(
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR (20) NOT NULL,
   professor_id INT NOT NULL,
   room_id VARCHAR (5),
   dept_id INT NOT NULL,
   type VARCHAR (2) NOT NULL COMMENT '강의 구분 (전공, 교양)',
   sub_year INT NOT NULL COMMENT '연도',
   semester INT NOT NULL COMMENT '학기',
   sub_day VARCHAR (1) NOT NULL COMMENT '요일',
   start_time INT NOT NULL COMMENT '시작 시간',
   end_time INT NOT NULL COMMENT '종료 시간',
   grades INT NOT NULL COMMENT '이수 학점',
   capacity INT NOT NULL COMMENT '수강 정원',
   num_of_student INT NOT NULL DEFAULT 0 COMMENT '현재 신청 인원',
   FOREIGN KEY (professor_id) REFERENCES professor_tb (id) ON DELETE CASCADE,
   FOREIGN KEY (room_id) REFERENCES room_tb (id) ON DELETE CASCADE,
   FOREIGN KEY (dept_id) REFERENCES department_tb (id) ON DELETE CASCADE
);
-- 과목 id 10000부터
ALTER TABLE subject_tb AUTO_INCREMENT = 10000;

-- 환산 점수
CREATE TABLE grade_tb
(
   grade VARCHAR (2) PRIMARY KEY COMMENT '학점 (평점)',
   grade_value FLOAT NOT NULL COMMENT '환산 점수'
);

-- 수강 신청
CREATE TABLE pre_stu_sub_tb
(
   student_id INT,
   subject_id INT,
   PRIMARY KEY
   (
      student_id,
      subject_id
   ),
   FOREIGN KEY (student_id) REFERENCES student_tb (id) ON DELETE CASCADE,
   FOREIGN KEY (subject_id) REFERENCES subject_tb (id) ON DELETE CASCADE
);

-- 수강 내역
CREATE TABLE stu_sub_tb(
	id INT PRIMARY KEY  AUTO_INCREMENT,
   student_id INT,
   subject_id INT,
   grade VARCHAR (2) COMMENT '신청 학점 (평점)',
   complete_grade INT COMMENT '이수 학점',
   FOREIGN KEY (student_id) REFERENCES student_tb (id) ON DELETE CASCADE,
   FOREIGN KEY (subject_id) REFERENCES subject_tb (id) ON DELETE CASCADE,
   FOREIGN KEY (grade) REFERENCES grade_tb (grade)
);

-- 단과대별 등록금
CREATE TABLE coll_tuit_tb
(
   college_id INT PRIMARY KEY,
   amount INT NOT NULL,
   FOREIGN KEY (college_id) REFERENCES college_tb (id) ON DELETE CASCADE
);

-- 장학금
CREATE TABLE scholarship_tb
(
   type INT PRIMARY KEY COMMENT '장학금 유형',
   max_amount INT NOT NULL COMMENT '최대 지원 금액'
);

-- 학생별 장학금 유형
CREATE TABLE stu_sch_tb
(
   student_id INT NOT NULL,
   sch_year INT NOT NULL COMMENT '지원 연도',
   semester INT NOT NULL COMMENT '지원 학기',
   sch_type INT COMMENT '장학금 유형',
   PRIMARY KEY
   (
      student_id,
      sch_year,
      semester
   ),
   FOREIGN KEY (sch_type) REFERENCES scholarship_tb (type)
);

-- 등록금
CREATE TABLE tuition_tb
(
   student_id INT,
   tui_year INT NOT NULL COMMENT '등록 연도',
   semester INT NOT NULL COMMENT '등록 학기',
   tui_amount INT NOT NULL COMMENT '등록금',
   sch_type INT COMMENT '장학금 유형',
   sch_amount INT COMMENT '장학금',
   status BOOLEAN DEFAULT false COMMENT '납부 여부',
   PRIMARY KEY
   (
      student_id,
      tui_year,
      semester
   ),
   FOREIGN KEY (student_id) REFERENCES student_tb (id) ON DELETE CASCADE,
   FOREIGN KEY (sch_type) REFERENCES scholarship_tb (type)
);

-- 공지사항
CREATE TABLE notice_tb
(
   id INT PRIMARY KEY AUTO_INCREMENT,
   category VARCHAR (10) NOT NULL,
   title VARCHAR (255) NOT NULL,
   content TEXT NOT NULL,
   created_time TIMESTAMP DEFAULT now(),
   views INT NOT NULL DEFAULT 0 COMMENT '조회수'
);

-- 공지사항 첨부 파일
CREATE TABLE notice_file_tb
(
   notice_id INT NOT NULL,
   origin_filename VARCHAR (100) COMMENT '기존 파일명' NOT NULL,
   uuid_filename VARCHAR (255) COMMENT '랜덤 문자열 포함 파일명' NOT NULL,
   FOREIGN KEY (notice_id) REFERENCES notice_tb (id) ON DELETE CASCADE
);

-- 휴학 신청 내역
CREATE TABLE break_app_tb
(
   id INT PRIMARY KEY AUTO_INCREMENT,
   student_id INT NOT NULL,
   student_grade INT NOT NULL,
   from_year INT NOT NULL,
   from_semester INT NOT NULL,
   to_year INT NOT NULL,
   to_semester INT NOT NULL,
   type VARCHAR (10) NOT NULL COMMENT '일반, 임신·출산·육아, 질병, 창업, 군입대',
   app_date DATE DEFAULT (current_date) NOT NULL COMMENT '신청 일자',
   status VARCHAR (3) NOT NULL DEFAULT '처리중' COMMENT '처리중, 승인, 거부',
   FOREIGN KEY (student_id) REFERENCES student_tb (id) ON DELETE CASCADE
);

-- 학적 상태
CREATE TABLE stu_stat_tb
(
   id INT PRIMARY KEY AUTO_INCREMENT,
   student_id INT NOT NULL,
   status VARCHAR (3) NOT NULL DEFAULT '재학', -- 재학, 휴학, 졸업, 자퇴
   from_date DATE,
   to_date DATE, -- 현재 속한 상태인 경우 '9999-01-01'
   break_app_id INT,
   FOREIGN KEY (student_id) REFERENCES student_tb (id) ON DELETE CASCADE,
   FOREIGN KEY (break_app_id) REFERENCES break_app_tb (id) ON DELETE CASCADE
);

CREATE TABLE stu_sub_detail_tb
(
   id INT PRIMARY KEY,
   student_id INT NOT NULL,
   subject_id INT NOT NULL,
   absent INT COMMENT '결석 횟수',
   lateness INT COMMENT '지각 횟수',
   homework INT COMMENT '과제 점수',
   mid_exam INT COMMENT '중간고사 점수',
   final_exam INT COMMENT '기말고사 점수',
   converted_mark INT COMMENT '환산점수',
   FOREIGN KEY (id) REFERENCES stu_sub_tb(id) ON DELETE CASCADE,
   FOREIGN KEY (student_id) REFERENCES student_tb(id) ON DELETE CASCADE,
   FOREIGN KEY (subject_id) REFERENCES subject_tb(id) ON DELETE CASCADE
);

CREATE TABLE syllabus_tb
(
	subject_id INT PRIMARY KEY ,
	overview VARCHAR(255) COMMENT '수업 개요',
	objective VARCHAR(255) COMMENT '강의 목표',
	textbook VARCHAR(30) COMMENT '교재',
	program TEXT COMMENT '주별 계획',
	FOREIGN KEY (subject_id) REFERENCES subject_tb(id) ON DELETE CASCADE
);

-- 강의 평가 테이블
CREATE TABLE evaluation_tb
(
evaluation_id INT AUTO_INCREMENT,
student_id INT,
subject_id INT,
PRIMARY KEY
(
evaluation_id,
student_id,
subject_id
),
answer1 INT NOT NULL COMMENT '응답',
answer2 INT NOT NULL,
answer3 INT NOT NULL,
answer4 INT NOT NULL,
answer5 INT NOT NULL,
answer6 INT NOT NULL,
answer7 INT NOT NULL,
improvements VARCHAR(255) COMMENT '건의사항',
FOREIGN KEY (student_id) REFERENCES student_tb (id) ON DELETE CASCADE,
FOREIGN KEY (subject_id) REFERENCES subject_tb (id) ON DELETE CASCADE
);

-- 질문지 내용 테이블
CREATE TABLE question_tb
(
id INT PRIMARY KEY AUTO_INCREMENT,
question1 VARCHAR(100) NOT NULL COMMENT '질문 내용',
question2 VARCHAR(100) NOT NULL,
question3 VARCHAR(100) NOT NULL,
question4 VARCHAR(100) NOT NULL,
question5 VARCHAR(100) NOT NULL,
question6 VARCHAR(100) NOT NULL,
question7 VARCHAR(100) NOT NULL,
sug_content VARCHAR(255) NOT NULL
);

-- 학사일정
CREATE TABLE schedule_tb(
id INT PRIMARY KEY AUTO_INCREMENT,
staff_id INT,
start_day DATE NOT NULL,
end_day DATE NOT NULL,
information VARCHAR(50) NOT NULL,
FOREIGN KEY (staff_id) REFERENCES staff_tb(id) 
);