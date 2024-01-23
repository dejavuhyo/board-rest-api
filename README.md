# Board Rest API

## 1. 설명
게시판(Board) Rest API CRUD 예제이다. 포트는 8081을 사용한다.

## 2. 개발환경

* OpenJDK 11

* spring-boot 2.6.1

* PostgreSQL 13.5

* MyBatis 2.2.0

## 3. DB (PostgreSQL)

* /db/table.sql

## 4. Rest API 실행

### 1) 목록 조회

* GET

```text
http://localhost:8081/board
```

### 2) 상세 조회

* GET

```text
http://localhost:8081/board/1
```

### 3) 검색

* GET

```text
http://localhost:8081/board/search
```

* Params
  - searchType: t (제목)
  - searchType: c (내용)

```json
{
	"searchType": "t",
	"searchWord": "제목"
}
```

### 4) 등록

* POST

```text
http://localhost:8081/board
```

* Params
  - title: 제목
  - contents: 내용
  - writer: 작성자

```json
{
	"title": "제목",
	"contents": "내용",
  "writer": "작성자"
}
```

### 5) 수정

* PUT

```text
http://localhost:8081/board
```

* Params
  - title: 수정 제목
  - contents: 수정 내용
  - writer: 수정 작성자

```json
{
	"title": "수정 제목",
	"contents": "수정 내용",
  "writer": "수정 작성자"
}
```

### 6) 삭제

* DELETE

```text
http://localhost:8081/board/1
```
