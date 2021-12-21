package com.example.board.mapper;

import com.example.board.vo.BoardVO;

import java.util.List;

public interface BoardMapper {

    List<BoardVO> getBoardList();

    List<BoardVO> searchBoardList(BoardVO boardVO);

    BoardVO findBoardById(BoardVO boardVO);

    int registerBoard(BoardVO boardVO);

    int updateBoard(BoardVO boardVO);

    int deleteBoard(BoardVO boardVO);

}
