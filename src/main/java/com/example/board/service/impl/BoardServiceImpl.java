package com.example.board.service.impl;

import com.example.board.mapper.BoardMapper;
import com.example.board.service.BoardService;
import com.example.board.vo.BoardVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Resource
    private BoardMapper boardMapper;

    @Override
    public List<BoardVO> getBoardList() {
        return boardMapper.getBoardList();
    }

    @Override
    public List<BoardVO> searchBoardList(BoardVO boardVO) {
        return boardMapper.searchBoardList(boardVO);
    }

    @Override
    public BoardVO findBoardById(BoardVO boardVO) {
        return boardMapper.findBoardById(boardVO);
    }

    @Override
    public int registerBoard(BoardVO boardVO) {
        return boardMapper.registerBoard(boardVO);
    }

    @Override
    public int updateBoard(BoardVO boardVO) {
        return boardMapper.updateBoard(boardVO);
    }

    @Override
    public int deleteBoard(BoardVO boardVO) {
        return boardMapper.deleteBoard(boardVO);
    }

}
