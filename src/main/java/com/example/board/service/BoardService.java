package com.example.board.service;

import com.example.board.dto.BoardDto;

import java.util.List;

public interface BoardService {

    List<BoardDto> getBoardList();

    List<BoardDto> searchBoardList(BoardDto boardDto);

    BoardDto findBoardById(Long id);

    int registerBoard(BoardDto boardDto);

    int updateBoard(BoardDto boardDto);

    int deleteBoard(Long id);

}
