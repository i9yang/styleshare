실행방법 :
docker build -t test https://raw.githubusercontent.com/i9yang/styleshare/master/Dockerfile
docker run -p 8080:8080 test

웹서버 : http://localhost:8080
디비서버 : http://localhost:8080/db

사용 기술 :
springboot, kotlin, h2, jpa

