# 🛜 Simple SNS

📝 **소개**

- Spring 백엔드 개발 역량과 대용량 트래픽 상황을 가정한 사이드 프로젝트

📆 **기간**

- 2023.08 - 2023.09

🧑‍💻 **역할**

- 1인 개인 프로젝트

⚙️ **개발 스택 및 사용 툴**

- 👾 Back

   <img src="https://img.shields.io/badge/Springboot-6DB33F?style=flat&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/Java-F37C20?style=flat&logo=&logoColor=white">
       
- 🐥 Front

   <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=white">
   
- ☁️ Cloud

   <img src="https://img.shields.io/badge/Heroku-430098?style=flat&logo=heroku&logoColor=white">
       
- 💾 DB / Cache

   <img src="https://img.shields.io/badge/Postgresql-4169E1?style=flat&logo=postgresql&logoColor=white"> <img src="https://img.shields.io/badge/Redis-DC382D?style=flat&logo=redis&logoColor=white">
   
- 🔩 Platform

   <img src="https://img.shields.io/badge/Apache Kafka-231F20?style=flat&logo=apachekafka&logoColor=white">
   
- ⚒️ Tool

   <img src="https://img.shields.io/badge/IntelliJ-6A5FBB?style=flat&logo=&logoColor=white"> <img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/Postman-FF6C37?style=flat&logo=postman&logoColor=white"> <img src="https://img.shields.io/badge/Gitkraken-179287?style=flat&logo=gitkraken&logoColor=white">

🌐 **URL**

Git : https://github.com/itavita08/sns

## 🧑‍🔧 주요 서비스

---

1. **회원가입 / 로그인**
    - Spring Security를 사용해 password 암호화
    - JWT 발급
    - 로그인 후 DB 과부하를 막기 위해 Redis에 캐싱
        
        ![1](https://github.com/itavita08/Deep-Story/assets/105635205/57447a39-0bb4-4180-b80a-4fe7b9e94aeb)
        
        ![2](https://github.com/itavita08/Deep-Story/assets/105635205/6f4cbaa6-f8cf-49ed-a0a5-70a7010b18a1)
        
        ![3](https://github.com/itavita08/Deep-Story/assets/105635205/efc2a933-d57a-4c0f-8c54-2ae5123337ca)

        
        ![4](https://github.com/itavita08/Deep-Story/assets/105635205/4da820b1-b68f-41f9-848e-6a6f467babb3)
        
2. **알람**
    - 기존 알람 기능은 새로고침을 하기 전까지는 새로운 알람이 오지 않음
    - 일정한 주기를 가지고 응답을 해주는 Pooling 방식을 고려했지만 알람이 업데이트가 되지 않아도 불필요한 응답을 해주는 단점이 있어서 SSE 방식을 사용
    - 알람 페이지 접속 시 자동으로 SSE 연결, 상대방이 댓글 작성 및 좋아요를 누를 시 자동으로 알람이 가도록 설정했지만 댓글 작성등과 같은 로직에 알람을 보내는 로직도 같이 포함되어 있어서 알람 로직에서 에러가 발생한다면 댓글 작성등과 같은 로직도 실행 지연이 된다.
    - 따라서, Kafka를 사용하여 비동기 방식으로 처리
    - SSE만 사용
        
        ![5](https://github.com/itavita08/Deep-Story/assets/105635205/11fd9fb0-228b-4504-a8a6-b95e2e0ff0d6)
        
    - Kafka, SSE 사용
        
        ![6](https://github.com/itavita08/Deep-Story/assets/105635205/3c50bfdb-cff1-4fe0-ac81-a9026e12aedf)
        
3. **Index**
    - DB에서는 데이터를 조회할 때 전체 탐색을 하므로 데이터 양이 많을 수록 DB에 부하가 발생
    - 따라서, 자주 조회되는 데이터는 `@Index` 를 사용하여 테이블을 조회하는 속도와 그에 따른 성능을 향상시키고 전반적인 시스템의 부화를 줄일 수 있다.
        
        ![7](https://github.com/itavita08/Deep-Story/assets/105635205/d0df98ce-be13-452e-a21e-9f23d16fbfd4)
        
        ![8](https://github.com/itavita08/Deep-Story/assets/105635205/340e8a7f-4799-45f8-b027-80fb4b05c9a9)
        

1. **Delete**
    - jpa에서 제공하는 delete를 사용할 경우 삭제할 데이터들을 다 가져온 후 하나씩 삭제하게 되므로 매우 비효율적이다.
    - 따라서, delete를 사용하는 것이 아닌 직접 쿼리문을 작성해서 데이터를 가져오지 않고 한번에 soft delete 되도록 했다.
    - JPA제공 delete 사용할 경우 select문으로 데이터를 가져온 후 삭제
        
        ![9](https://github.com/itavita08/Deep-Story/assets/105635205/ffac4615-e18b-408e-9f40-c4ac6fab4cd2)
        
        ![10](https://github.com/itavita08/Deep-Story/assets/105635205/d2f49c6a-9fde-4e10-8ea6-d2c1c70fe7ee)
        
        ![11](https://github.com/itavita08/Deep-Story/assets/105635205/5eaad508-ca2b-4896-b569-e08196f4bd67)
        
    - 직접 쿼리문을 사용해 불필요한 select문 삭제
        
        ![12](https://github.com/itavita08/Deep-Story/assets/105635205/6c4b82ce-81fc-48c0-ba50-0bd223aecaaa)
        
        ![13](https://github.com/itavita08/Deep-Story/assets/105635205/05f98b90-e4a0-4c2f-8308-167a8b46b2c0)
