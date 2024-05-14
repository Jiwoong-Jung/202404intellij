-- delete from lecture;
-- delete from major;
-- delete from college;
-- delete from campus;

--
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

insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Aerified', 'Erica', 1, 33, 'MONDAY', 'TEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Temp', 'Chaddie', 3, 12, 'MONDAY', 'SIX_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Rank', 'Cate', 1, 8, 'TUESDAY', 'FIVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Regrant', 'Carol-jean', 2, 2, 'TUESDAY', 'FOUR_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Matsoft', 'Garrett', 1, 38, 'MONDAY_AND_WEDNESDAY', 'TEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Cookley', 'Hugues', 1, 26, 'WEDNESDAY', 'FIVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Cardguard', 'Barbi', 2, 22, 'TUESDAY', 'THREE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Aerified', 'Arlinda', 1, 21, 'MONDAY', 'TEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Pannier', 'Philbert', 2, 25, 'TUESDAY', 'TWELVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Biodex', 'Hattie', 2, 40, 'TUESDAY_AND_THURSDAY', 'TWELVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Stim', 'Linnea', 2, 23, 'MONDAY', 'FIVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Keylex', 'Kiley', 2, 6, 'FRIDAY', 'FIVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Redhold', 'Ches', 3, 26, 'TUESDAY', 'TEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Duobam', 'Arvy', 1, 45, 'MONDAY', 'ONE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Cardguard', 'Phylys', 3, 13, 'TUESDAY_AND_THURSDAY', 'SEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Andalax', 'Greer', 3, 34, 'WEDNESDAY', 'SEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Y-Solowarm', 'Borg', 2, 11, 'TUESDAY', 'TEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Biodex', 'Jedd', 2, 7, 'THURSDAY', 'ELEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Andalax', 'Mitchel', 3, 32, 'MONDAY', 'NINE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Fix San', 'Maggy', 1, 30, 'WEDNESDAY', 'ZERO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Namfix', 'Karlyn', 3, 41, 'THURSDAY', 'ONE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Solarbreeze', 'Carie', 1, 25, 'MONDAY', 'ELEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Voltsillam', 'Ashleigh', 1, 31, 'WEDNESDAY', 'TEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Flexidy', 'Laure', 1, 24, 'FRIDAY', 'TWELVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Zoolab', 'Reggie', 2, 7, 'FRIDAY', 'THREE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Stringtough', 'Reba', 3, 12, 'MONDAY', 'SIX_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Y-find', 'Rocky', 2, 15, 'FRIDAY', 'ONE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Sonsing', 'Darrick', 1, 4, 'FRIDAY', 'TWELVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Fixflex', 'Moses', 2, 25, 'MONDAY', 'FOUR_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Zoolab', 'Magdalene', 2, 11, 'TUESDAY_AND_THURSDAY', 'SEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Regrant', 'Tami', 3, 31, 'TUESDAY', 'THREE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Ventosanzap', 'Barton', 3, 21, 'FRIDAY', 'ZERO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Tampflex', 'Dennet', 2, 21, 'MONDAY', 'EIGHT_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Treeflex', 'Theadora', 3, 19, 'MONDAY_AND_WEDNESDAY', 'NINE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Stim', 'Saxe', 3, 26, 'WEDNESDAY', 'TEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Home Ing', 'Andee', 1, 9, 'TUESDAY', 'ZERO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Ventosanzap', 'Abner', 2, 29, 'MONDAY', 'THREE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Ventosanzap', 'Mattie', 1, 38, 'TUESDAY', 'FOUR_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Voyatouch', 'Laurice', 1, 12, 'MONDAY_AND_WEDNESDAY', 'ZERO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Opela', 'Harwell', 2, 27, 'FRIDAY', 'THREE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Bytecard', 'Britt', 3, 15, 'WEDNESDAY', 'ELEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Zontrax', 'Tracie', 3, 35, 'MONDAY_AND_WEDNESDAY', 'FOUR_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Fixflex', 'Kathi', 1, 9, 'MONDAY_AND_WEDNESDAY', 'ONE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Hatity', 'Angela', 3, 23, 'THURSDAY', 'EIGHT_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Tresom', 'Amandi', 2, 23, 'THURSDAY', 'TWO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Flowdesk', 'Itch', 3, 40, 'TUESDAY_AND_THURSDAY', 'TWO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Quo Lux', 'Hazel', 1, 10, 'MONDAY_AND_WEDNESDAY', 'FIVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Matsoft', 'Isac', 3, 3, 'FRIDAY', 'ZERO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Zathin', 'Gavin', 1, 18, 'THURSDAY', 'SIX_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Sub-Ex', 'Ignazio', 3, 6, 'TUESDAY_AND_THURSDAY', 'ELEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Otcom', 'Melina', 2, 29, 'THURSDAY', 'ZERO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Cookley', 'Crissie', 1, 15, 'MONDAY', 'FIVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Rank', 'Tailor', 3, 25, 'WEDNESDAY', 'NINE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Zoolab', 'Ingeborg', 3, 18, 'WEDNESDAY', 'ZERO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Veribet', 'Windham', 2, 27, 'WEDNESDAY', 'SIX_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Lotstring', 'Nananne', 3, 6, 'FRIDAY', 'ZERO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Domainer', 'Coletta', 1, 7, 'TUESDAY_AND_THURSDAY', 'TEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Greenlam', 'Theodor', 2, 6, 'WEDNESDAY', 'ZERO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Ronstring', 'Cobbie', 1, 5, 'WEDNESDAY', 'FOUR_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Quo Lux', 'Milli', 3, 16, 'MONDAY', 'ELEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Fintone', 'Giff', 3, 35, 'MONDAY', 'EIGHT_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Solarbreeze', 'Rudolf', 1, 6, 'WEDNESDAY', 'TWELVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Otcom', 'Pace', 1, 22, 'TUESDAY', 'TWELVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Stringtough', 'Carolee', 3, 13, 'TUESDAY_AND_THURSDAY', 'ELEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Biodex', 'Ezechiel', 3, 40, 'WEDNESDAY', 'ONE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Holdlamis', 'Ricky', 1, 5, 'TUESDAY_AND_THURSDAY', 'SIX_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Regrant', 'Wynny', 2, 24, 'MONDAY', 'ELEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Hatity', 'Eliot', 2, 2, 'WEDNESDAY', 'TWELVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Job', 'Myer', 1, 29, 'WEDNESDAY', 'ONE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Daltfresh', 'Mortimer', 3, 12, 'THURSDAY', 'TWO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Transcof', 'Julissa', 3, 21, 'MONDAY', 'SIX_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Opela', 'Dominica', 2, 23, 'MONDAY_AND_WEDNESDAY', 'SEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Otcom', 'Blaire', 3, 36, 'THURSDAY', 'FOUR_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Tempsoft', 'Maris', 3, 23, 'THURSDAY', 'NINE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Opela', 'Victoria', 1, 32, 'THURSDAY', 'TWO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Tempsoft', 'Ulrikaumeko', 3, 37, 'MONDAY', 'SEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Transcof', 'Fawn', 1, 8, 'TUESDAY_AND_THURSDAY', 'EIGHT_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Mat Lam Tam', 'Kev', 2, 9, 'WEDNESDAY', 'FIVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Prodder', 'Tilda', 2, 28, 'TUESDAY_AND_THURSDAY', 'SIX_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Tresom', 'Zahara', 2, 6, 'FRIDAY', 'ZERO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Alpha', 'Giacomo', 3, 26, 'TUESDAY_AND_THURSDAY', 'TWO_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('It', 'Langsdon', 1, 20, 'TUESDAY_AND_THURSDAY', 'SEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Regrant', 'Delmor', 1, 18, 'THURSDAY', 'SEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Konklab', 'Amye', 1, 27, 'MONDAY_AND_WEDNESDAY', 'SEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Rank', 'Otis', 2, 16, 'THURSDAY', 'THREE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Konklab', 'Nerissa', 3, 37, 'THURSDAY', 'TEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Zamit', 'Pier', 3, 24, 'TUESDAY', 'TEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Fintone', 'Avigdor', 3, 43, 'TUESDAY_AND_THURSDAY', 'ELEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Matsoft', 'Ichabod', 1, 23, 'THURSDAY', 'TWELVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Lotlux', 'Vinita', 3, 32, 'TUESDAY_AND_THURSDAY', 'ONE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Solarbreeze', 'Salomon', 2, 1, 'FRIDAY', 'TWELVE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Tres-Zap', 'Korry', 2, 8, 'THURSDAY', 'ELEVEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Greenlam', 'Michal', 2, 16, 'WEDNESDAY', 'THREE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Domainer', 'Catrina', 1, 40, 'FRIDAY', 'TEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Ronstring', 'Fran', 3, 41, 'WEDNESDAY', 'TEN_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Transcof', 'Stillmann', 3, 29, 'MONDAY', 'EIGHT_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Zaam-Dox', 'Wyatt', 1, 38, 'MONDAY', 'NINE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Holdlamis', 'Godart', 3, 44, 'FRIDAY', 'NINE_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Otcom', 'Barri', 3, 10, 'TUESDAY', 'SIX_PERIOD');
insert into lecture (name, lecturer, credit, major_id, day, period)
values ('Zaam-Dox', 'Donica', 3, 11, 'TUESDAY', 'ELEVEN_PERIOD');