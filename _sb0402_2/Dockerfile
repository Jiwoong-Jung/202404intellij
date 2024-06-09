# Dockerfile

# jdk17 Image Start
#FROM --platform=linux/amd64 ubuntu:latest
FROM openjdk:17

# 인자 설정 - Jar_File
ARG JAR_FILE=build/libs/*.jar

# jar 파일 복제
COPY ${JAR_FILE} app.jar

# 인자 설정 부분과 jar 파일 복제 부분 합쳐서 진행해도 무방
#COPY build/libs/*.jar app.jar

# 실행 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]

# docker build --platform linux/amd64 -t philip2767/demo .

# 아래의 과정으로 CD과정을 구축한다.
# 새로운 이미지 풀받기 sudo docker pull [username]/github-actions-demo
# 실행중인 컨테이너 종료하기 sudo docker stop demo (demo라는 이름으로 실행할 예정)
# 새로 풀받은 이미지 실행 sudo docker run --name demo --rm -d -p 8080:8080 [username]/github-actions-demo
# 기존 이미지 정리 sudo docker system prune -f (모두 예로 강제함)

# 모든 컨테이너 한번에 종료 sudo docker stop $(sudo docker ps -qa)
# 실행중인 모든 컨테이너 종료(컨테이너 존재하지 않아도 오류발생 x) sudo docker stop $(sudo docker ps -q) 2>/dev/null || true
