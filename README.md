# spring-boot-rest-api

## 1. 개발환경

* OpenJDK 11

* PostgreSQL 13.5

## 2. DB (PostgreSQL)

* /db/table.sql

## 3. 설명
Rest API 게시판 CRUD 예제

## 4. Rest API 실행

### 1) 조회

* GET
  - 목록 조회: http://localhost:8080/board
  - 상세 조회: http://localhost:8080/board/1

### 2) 등록

* POST
  - http://localhost:8080/board

* Params
  - title=제목
  - contents=내용
  - writer=작성자

### 3) 수정

* PUT
  - http://localhost:8080/board

* Params
  - title=수정제목
  - contents=수정내용
  - writer=수정작성자

### 4) 삭제

* DELETE
  - http://localhost:8080/board/1
