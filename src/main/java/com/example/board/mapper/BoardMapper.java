package com.example.board.mapper;

import com.example.board.dto.BoardDto;

import java.util.List;

public interface BoardMapper {

    List<BoardDto> getBoardList();

    List<BoardDto> searchBoardList(BoardDto boardDto);

    BoardDto findBoardById(Long id);

    int registerBoard(BoardDto boardDto);

    int updateBoard(BoardDto boardDto);

    int deleteBoard(Long id);

}
