package com.example.board.service;

import com.example.board.vo.BoardVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> getBoardList();

    BoardVO findBoardById(BoardVO boardVO);

    int registerBoard(BoardVO boardVO);

    int deleteBoard(BoardVO boardVO);

    int updateBoard(BoardVO boardVO);

}
