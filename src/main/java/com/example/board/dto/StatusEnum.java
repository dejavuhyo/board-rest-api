package com.example.board.dto;

/**
 * Auto generated class
 * <p>
 * 자동생성 프로그램 버전 : 1.0.0
 * 생성일시 :  2022-11-11 13:25:57.787
 *
 * @FileName : 클래스에 대한 한글 명칭
 * Change history
 * @수정날짜;SCR_NO;수정자;수정내용
 * @2022-11-11 13:25:57.787;00000;홍길동;최초생성
 */

public enum StatusEnum {
    OK(200, "OK"),
    BAD_REQUEST(400, "BAD REQUEST"),
    NOT_FOUND(404, "NOT FOUND"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL SERVER ERROR");

    int code;
    String message;

    StatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
