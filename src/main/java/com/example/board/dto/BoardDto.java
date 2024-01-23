package com.example.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {

    private Long id;
    private String title;
    private String contents;
    private String writer;
    private Date regDate;
    private Long viewCnt;
    private String searchType;
    private String searchWord;

}
