-- delete from lecture;
-- delete from major;
-- delete from college;
-- delete from campus;

INSERT INTO campus (name)
VALUES ('인문캠퍼스');
INSERT INTO campus (name)
VALUES ('자연캠퍼스');
--
INSERT INTO college (name, campus_id)
VALUES ('교양', 1);
INSERT INTO college (name, campus_id)
VALUES ('ICT융합대학', 1);
INSERT INTO college (name, campus_id)
VALUES ('경영대학', 1);
INSERT INTO college (name, campus_id)
VALUES ('사회과학대학', 1);
INSERT INTO college (name, campus_id)
VALUES ('인문대학', 1);
INSERT INTO college (name, campus_id)
VALUES ('법학대학', 1);
INSERT INTO college (name, campus_id)
VALUES ('교양', 2);
INSERT INTO college (name, campus_id)
VALUES ('공과대학', 2);
INSERT INTO college (name, campus_id)
VALUES ('자연과학대학', 2);
INSERT INTO college (name, campus_id)
VALUES ('예술체육대학', 2);
INSERT INTO college (name, campus_id)
VALUES ('건축대학', 2);
--
INSERT INTO major (name, college_id)
VALUES ('영어교양', 1);
INSERT INTO major (name, college_id)
VALUES ('기초교양', 1);
INSERT INTO major (name, college_id)
VALUES ('선택교양', 1);
INSERT INTO major (name, college_id)
VALUES ('응용소프트웨어', 2);
INSERT INTO major (name, college_id)
VALUES ('경영학과', 3);
INSERT INTO major (name, college_id)
VALUES ('국제통상학과', 3);
INSERT INTO major (name, college_id)
VALUES ('경영정복학과', 3);
INSERT INTO major (name, college_id)
VALUES ('부동산학과', 3);
INSERT INTO major (name, college_id)
VALUES ('경영교육혁신센터', 3);
INSERT INTO major (name, college_id)
VALUES ('행정학과', 4);
INSERT INTO major (name, college_id)
VALUES ('경제학과', 4);
INSERT INTO major (name, college_id)
VALUES ('정치외교학과', 4);
INSERT INTO major (name, college_id)
VALUES ('디지털미디어학과', 4);
INSERT INTO major (name, college_id)
VALUES ('청소년지도학과', 4);
INSERT INTO major (name, college_id)
VALUES ('사회복지학과', 4);
INSERT INTO major (name, college_id)
VALUES ('국어국문학과', 5);
INSERT INTO major (name, college_id)
VALUES ('중어중문학과', 5);
INSERT INTO major (name, college_id)
VALUES ('일어일문학과', 5);
INSERT INTO major (name, college_id)
VALUES ('영어영문학과', 5);
INSERT INTO major (name, college_id)
VALUES ('사학과', 5);
INSERT INTO major (name, college_id)
VALUES ('문헌정보학과', 5);
INSERT INTO major (name, college_id)
VALUES ('미술사학과', 5);
INSERT INTO major (name, college_id)
VALUES ('철학과', 5);
INSERT INTO major (name, college_id)
VALUES ('아랍지역학과', 5);
INSERT INTO major (name, college_id)
VALUES ('문예창작학과', 5);
INSERT INTO major (name, college_id)
VALUES ('법학과', 6);
INSERT INTO major (name, college_id)
VALUES ('법무정책학과', 6);
INSERT INTO major (name, college_id)
VALUES ('영어교양', 7);
INSERT INTO major (name, college_id)
VALUES ('기초교양', 7);
INSERT INTO major (name, college_id)
VALUES ('선택교양', 7);
INSERT INTO major (name, college_id)
VALUES ('전기공학과', 8);
INSERT INTO major (name, college_id)
VALUES ('컴퓨터공학과', 8);
INSERT INTO major (name, college_id)
VALUES ('수학과', 9);
INSERT INTO major (name, college_id)
VALUES ('물리과', 9);
INSERT INTO major (name, college_id)
VALUES ('화학과', 9);
INSERT INTO major (name, college_id)
VALUES ('식품영양학과', 9);
INSERT INTO major (name, college_id)
VALUES ('생명과학정보학과', 9);
INSERT INTO major (name, college_id)
VALUES ('디자인학부', 10);
INSERT INTO major (name, college_id)
VALUES ('체육학부', 10);
INSERT INTO major (name, college_id)
VALUES ('음악학부', 10);
INSERT INTO major (name, college_id)
VALUES ('바둑학과', 10);
INSERT INTO major (name, college_id)
VALUES ('영화/뮤지컬학부', 10);
INSERT INTO major (name, college_id)
VALUES ('건축학부', 11);
INSERT INTO major (name, college_id)
VALUES ('공간디자인전공', 11);
INSERT INTO major (name, college_id)
VALUES ('디지털콘텐츠', 2);
--

INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('영어회화1', '다니엘', 1, '월수10:30-11:45', 1);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('글쓰기', '육민수', 3, '월수10:30-11:45', 2);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('발표와토의', '주민재', 3, '월수10:30-11:45', 2);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('한국근현대사의이해', '윤홍석', 3, '월수10:30-11:45', 3);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('민주주의와현대사회', '윤홍석', 3, '월수10:30-11:45', 3);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('콘텐츠디자인1', '김일주', 3, '화목10:30-11:45', 4);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('객체지향적사고와프로그래밍', '최성운', 3, '월수10:30-11:45', 2);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('중급회계', '김기영', 3, '화목15:00-16:15', 6);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('재무분석', '심명화', 3, '화목15:00-16:15', 6);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('정부회계', '박경진', 3, '화목15:00-16:15', 6);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('투자론', '변영훈', 3, '화목15:00-16:15', 6);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('브랜드관리', '이은정', 3, '화목15:00-16:15', 6);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('기업법2', '이종훈', 3, '화목15:00-16:15', 6);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('국제무역론', '조미진', 3, '화목15:00-16:15', 7);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('국제경제기구론', '김태황', 3, '화목15:00-16:15', 7);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('정보공학', '정동길', 3, '화목15:00-16:15', 8);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('법경제', '김호균', 3, '화목15:00-16:15', 8);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('정보보호입문', '정동길', 3, '화목15:00-16:15', 8);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('감정평가이론', '이수겸', 3, '토13:00-15:50', 9);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('부동산개발론', '조인창', 3, '수20:20-22:45', 9);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('부동산컨설팅', '권대중', 3, '토13:00-15:50', 9);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('교육관리학', '김성일', 3, '월13:00-15:50', 10);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('행정학의이해', '이현정', 3, '목12:00-14:45', 11);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('지방행정론', '임승빈', 3, '월수09:00-10:15', 11);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('정책학원론', '이시연', 3, '목09:00-11:45', 11);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('경제통계', '이명훈', 3, '수금13:30-14:45', 12);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('경제체제론', '홍제환', 3, '화09:00-11:45', 12);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('국제경제학', '안병창', 3, '금10:30-11:45', 12);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('정치학개론', '정희옥', 3, '월수13:30-14:45', 13);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('국제정치론', '정성철', 3, '수금13:30-14:45', 13);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('정치심리학', '김도종', 3, '화15:00-17:45', 13);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('미디어의이해', '이병혜', 3, '월수13:30-14:45', 14);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('커뮤니케이션이론', '김기태', 3, '금13:30-14:45', 14);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('디지털미디어기사회', '최선규', 3, '화목12:00-13:15', 14);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('청소년지도학2', '조미영', 2, '금10:00-11:50', 15);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('청소년문화', '권일남', 3, '월수13:30-14:45', 15);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('청소년심리및상담', '한영희', 3, '월09:00-11:45', 15);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('청소년활동', '권일남', 3, '목15:00-17:45', 15);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('청소년기관운영', '박대권', 3, '월수13:30-14:45', 15);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('성격심리', '이랑주', 3, '화목13:30-14:45', 15);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('사회복지행정론', '이재성', 3, '토16:00-18:35', 16);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('가족복지론', '김희진', 3, '토16:00-18:35', 16);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('사회복지현장실습', '김민아', 3, '토09:00-11:50', 16);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('영화와사회복지', '최인화', 3, '토16:00-18:35', 16);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('국어학의이해', '조남호', 3, '월10:30-13:15', 17);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('국문학개론', '남재철', 3, '월15:00-17:45', 17);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('고전소설론', '이창헌', 3, '월10:30-13:15', 17);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('국어문법론', '윤용선', 3, '월10:30-13:15', 17);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('중국어현장답사', '강연', 2, '화16:30-18:15', 18);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('중국어발음원와연습', '김보경', 3, '화16:30-18:15', 18);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('중국어회화2', '김명구', 3, '월15:00-17:45', 18);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('중국고문읽기', '김선희', 3, '화16:30-18:15', 18);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('중국소설의이해', '김선희', 3, '목16:30-18:15', 18);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('전공기초일본영어2', '이은미', 3, '월10:30-13:15', 19);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('중급일본어회화2', '사이코아사코', 3, '월10:30-13:15', 19);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('실용일본어작문', '신은진', 3, '월10:30-13:15', 19);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('초급일본어회화2', '스미유리카', 3, '목10:30-13:15', 19);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('일본어강독2', '이신혜', 3, '금10:00-12:45', 19);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('영문학개론', '이기한', 3, '수12:00-13:15', 20);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('영어듣기의이론과실제', '콜린워커', 3, '목12:00-13:15', 20);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('영미문학강독', '손일수', 3, '금12:00-13:15', 20);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('중급영어회화', '콜린워커', 3, '월수09:00-10:15', 20);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('영어교육론', '장지연', 3, '월16:30-17:45', 20);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('한국사강독', '박진훈', 3, '월16:30-17:45', 21);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('동양고대사', '최해별', 3, '월10:30-11:45', 21);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('서양고대사', '황원호', 3, '월15:00-17:45', 21);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('동양사강독', '정철웅', 3, '화16:30-17:44', 21);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('정보학입문', '김현희', 3, '월13:30-14:45', 22);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('도서관정보센터경영론', '배창섭', 3, '월15:00-17:45', 22);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('정보문화사', '송승섭', 3, '화10:30-11:45', 22);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('참고정보봉사론', '권나현', 3, '화13:30-14:45', 22);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('한국미술사', '이주현', 3, '월09:00-10:15', 23);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('서양미술사', '이지은', 3, '월09:00-10:15', 23);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('동양미술사', '이태호', 3, '월09:00-10:15', 23);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('일본미술사', '최선아', 3, '월09:00-10:15', 23);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('한국공예사', '박정민', 3, '월09:00-10:15', 23);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('인식론', '김준성', 3, '월09:00-10:15', 24);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('철학원론', '강순전', 3, '월09:00-10:15', 24);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('논리학', '김윤구', 3, '월09:00-10:15', 24);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('합리론', '임석진', 3, '월09:00-10:15', 24);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('정의론', '김한상', 3, '월09:00-10:15', 24);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('기초아랍어', '안정국', 3, '월수09:00-10:15', 25);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('아랍어문법', '이종화', 3, '월수09:00-10:15', 25);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('중급아랍어', '조희선', 3, '화목12:00-13:15', 25);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('시의이해', '박상수', 3, '목10:30-13:15', 26);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('소설의이해', '김종욱', 3, '월15:00-17:45', 26);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('시창작연구', '남진우', 3, '금15:00-17:45', 26);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('저작권과소프트웨어', '김선주', 3, '월수09:00-10:15', 27);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('정치학개론', '정희옥', 3, '월수09:00-10:15', 28);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('국제정치론', '정성철', 3, '화목13:30-14:45', 28);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('정치심리학', '김도종', 3, '월수09:00-10:15', 28);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('영어1', '여인숙', 2, '월수10:30-11:45', 29);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('영어회화1', '다니엘', 1, '월수10:30-11:45', 29);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('글쓰기', '육민수', 3, '월수10:30-11:45', 30);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('발표와토의', '주민재', 3, '월수10:30-11:45', 30);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('한국근현대사의이해', '윤홍석', 3, '월수10:30-11:45', 31);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('민주주의와현대사회', '윤홍석', 3, '화목10:30-11:45', 31);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('전기전자2', '김민수', 3, '화목10:30-11:45', 32);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('C언어', '전종훈', 3, '화목18:00-19:50', 33);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('시스템과프로그래밍', '권동섭', 3, '월수18:00-19:50', 33);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('수학교재연구및지도법', '박진형', 2, '화13:00-14:50', 34);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('정수론', '소순태', 3, '월13:0-13:50', 34);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('해석학게론', '홍덕현', 3, '월14:00-14:50', 34);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('물리학', '김주학', 3, '월10:00-11:50', 35);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('화학2', '김선경', 3, '월수09:00-10:15', 36);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('식품학', '황지영', 3, '월13:00-13:50', 37);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('미생물학', '이상희', 4, '월09:00-15:50', 38);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('생화학', '권형진', 3, '화09:00-11:50', 38);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('산업미생물학', '홍순광', 3, '수09:00-11:50', 38);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('통합디자인연구', '신완식', 3, '월09:00-11:50', 39);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('디지털디자인', '조태형', 3, '화18:00-19:50', 39);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('제품디자인기초', '최종운', 3, '수18:00-19:50', 39);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('체력측정론', '김주학', 3, '목18:00-19:50', 40);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('운동을위한인체구조', '박종성', 3, '수09:00-11:50', 40);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('발육과노화', '박태섭', 3, '월09:00-11:50', 40);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('서양음악사', '김영옥', 2, '금09:00-11:50', 41);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('반주법', '장미경', 2, '금09:00-11:50', 41);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('음악통론', '정혜윤', 2, '금09:00-11:50', 41);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('포석과정석', '온소진', 3, '수09:00-11:50', 42);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('컴퓨터와바둑', '감동근', 3, '월09:00-11:50', 42);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('바둑학개론', '정수현', 3, '화09:00-11:50', 42);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('세계영화사', '장병원', 3, '금10:00-12:50', 43);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('현대영화의경향', '김영진', 3, '목14:00-16:50', 43);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('할리우드영화연구', '이길성', 3, '화14:0-16:50', 43);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('건축고고학실습', '최종규', 3, '금09:00-11:50', 44);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('목구조역학', '김영민', 3, '금09:00-11:50', 44);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('건축설계와표현', '이재인', 3, '월14:00-18:50', 45);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('건축설계', '남수현', 5, '금09:00-11:50', 45);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('영어1', '김혜수', 2, '화목12:30-13:45', 1);
INSERT INTO lecture (name, lecturer, credit, time, major_id)
VALUES ('전기전자1', '김민수', 3, '월수10:30-11:45', 32);