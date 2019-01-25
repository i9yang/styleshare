실행방법 :<br />
docker build -t test https://raw.githubusercontent.com/i9yang/styleshare/master/Dockerfile<br />
docker run -p 8080:8080 test<br />

상품리스트 : http://localhost:8080<br />
장바구니 : http://localhost:8080/cart<br />
디비서버 : http://localhost:8080/db<br />

사용 기술 :<br />
Springboot, kotlin, h2, Mybatis<br />

