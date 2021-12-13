package com.example.board.controller;

import com.example.board.service.BoardService;
import com.example.board.vo.BoardVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BoardController {

    @Resource
    private BoardService boardService;

    /**
     * 목록 조회
     *
     * @return
     */
    @GetMapping("/board")
    public ResponseEntity getBoardList() {

        List<BoardVO> getBoardList = boardService.getBoardList();

        if (getBoardList == null) {
            return new ResponseEntity("조회 실패", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(getBoardList, HttpStatus.OK);
    }

    /**
     * 상세 조회
     *
     * @param boardVO
     * @return
     */
    @GetMapping("/board/{id}")
    public ResponseEntity findBoardById(BoardVO boardVO) {

        BoardVO findBoardById = boardService.findBoardById(boardVO);

        if (findBoardById == null) {
            return new ResponseEntity("조회 실패", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(findBoardById, HttpStatus.OK);
    }

    /**
     * 등록
     *
     * @param boardVO
     * @return
     */
    @PostMapping("/board")
    public ResponseEntity registerBoard(BoardVO boardVO) {

        int registerBoard = boardService.registerBoard(boardVO);
        if (registerBoard == 0) {
            return new ResponseEntity("등록 실패", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity("등록 완료", HttpStatus.OK);
    }

    /**
     * 수정
     *
     * @param boardVO
     * @return
     */
    @PutMapping("/board")
    public ResponseEntity updateBoard(BoardVO boardVO) {

        int updateBoard = boardService.updateBoard(boardVO);
        if (updateBoard == 0) {
            return new ResponseEntity("수정 실패", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity("수정 완료", HttpStatus.OK);
    }

    /**
     * 삭제
     *
     * @param boardVO
     * @return
     */
    @DeleteMapping("/board/{id}")
    public ResponseEntity deleteBoard(BoardVO boardVO) {

        int deleteBoard = boardService.deleteBoard(boardVO);
        if (deleteBoard == 0) {
            return new ResponseEntity("삭제 실패", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity("삭제 완료", HttpStatus.OK);
    }

}
