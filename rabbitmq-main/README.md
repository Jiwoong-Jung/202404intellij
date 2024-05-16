# rabbitmq
#### # 개발 환경
- mac os catalina
- java 15
- rabbitmq client 5.10.0
- rabbitmq server 3.8.9
- spring boot 2.4.0
- gradle 6.6.1

#### # 모듈 소개
- producer : 메세지 큐에 넣는 모듈
- consumer : 메시지를 읽는 모듈 (읽으면 출력 하도록 함)

#### # rabbitmq mac 설치
$ brew install rabbitmq

#### # rabbitmq start
$ /usr/local/sbin/rabbitmq-server

#### # rabbitmq manager ui
- http://localhost:15672
- 기본 계정 : guest / guest

#### # rabbitmq 계정 생성
$ /usr/local/sbin/rabbitmqctl add_user admin admin

#### # admin 권한 부여
$ /usr/local/sbin/rabbitmqctl set_user_tags admin administrator

#### # 계정 보기
$ /usr/local/sbin/rabbitmqctl list_users

#### # vhost 생성
$ /usr/local/sbin/rabbitmqctl add_vhost vhost-01

#### # 유저 vhost 권한 부여
예) rabbitmqctl list_permissions [-p vhost ] <user> <conf> <write> <read>
$ /usr/local/sbin/rabbitmqctl set_permissions -p vhost-01 admin ".*" ".*" ".*"
