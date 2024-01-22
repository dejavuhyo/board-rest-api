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
    public ResponseEntity<Message> getBoardList() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-type", "application/json;charset=UTF-8");
        Message message = new Message();

        try {
            List<BoardDto> getBoardList = boardService.getBoardList();
            message.setStatus(StatusEnum.OK);
            message.setData(getBoardList);
            message.setMessage("success");
            return new ResponseEntity<>(message, httpHeaders, HttpStatus.OK);
        } catch (Exception e) {
            message.setStatus(StatusEnum.INTERNAL_SERVER_ERROR);
            message.setMessage("fail");
            return new ResponseEntity<>(message, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 검색
     *
     * @param boardVO
     * @return
     */
    @GetMapping("/board/search")
    public ResponseEntity searchBoardList(BoardVO boardVO) {

        List<BoardVO> searchBoardList = boardService.searchBoardList(boardVO);

        if (searchBoardList == null) {
            return new ResponseEntity("검색 실패", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(searchBoardList, HttpStatus.OK);
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
