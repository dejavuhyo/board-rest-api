package com.example.board.service.impl;

import com.example.board.mapper.BoardMapper;
import com.example.board.service.BoardService;
import com.example.board.dto.BoardDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Resource
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> getBoardList() {
        return boardMapper.getBoardList();
    }

    @Override
    public List<BoardDto> searchBoardList(BoardDto boardDto) {
        return boardMapper.searchBoardList(boardDto);
    }

    @Override
    public BoardDto findBoardById(Long id) {
        return boardMapper.findBoardById(id);
    }

    @Override
    public int registerBoard(BoardDto boardDto) {
        return boardMapper.registerBoard(boardDto);
    }

    @Override
    public int updateBoard(BoardDto boardDto) {
        return boardMapper.updateBoard(boardDto);
    }

    @Override
    public int deleteBoard(Long id) {
        return boardMapper.deleteBoard(id);
    }

}
