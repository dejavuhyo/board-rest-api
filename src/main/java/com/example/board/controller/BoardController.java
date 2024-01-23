package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.dto.Message;
import com.example.board.dto.StatusEnum;
import com.example.board.service.BoardService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Message message = new Message();

        try {
            List<BoardDto> getBoardList = boardService.getBoardList();
            if (CollectionUtils.isNotEmpty(getBoardList)) {
                message.setStatus(StatusEnum.OK);
                message.setData(getBoardList);
                message.setMessage("목록 조회 성공");
            } else {
                message.setStatus(StatusEnum.BAD_REQUEST);
                message.setMessage("fail");
            }
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
     * @param boardDto
     * @return
     */
    @GetMapping("/board/search")
    public ResponseEntity<Message> searchBoardList(@RequestBody BoardDto boardDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Message message = new Message();

        try {
            List<BoardDto> searchBoardList = boardService.searchBoardList(boardDto);
            if (CollectionUtils.isNotEmpty(searchBoardList)) {
                message.setStatus(StatusEnum.OK);
                message.setData(searchBoardList);
                message.setMessage("검색 성공");
            } else {
                message.setStatus(StatusEnum.BAD_REQUEST);
                message.setMessage("fail");
            }
            return new ResponseEntity<>(message, httpHeaders, HttpStatus.OK);
        } catch (Exception e) {
            message.setStatus(StatusEnum.INTERNAL_SERVER_ERROR);
            message.setMessage("fail");
            return new ResponseEntity<>(message, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 상세 조회
     *
     * @param id
     * @return
     */
    @GetMapping("/board/{id}")
    public ResponseEntity<Message> findBoardById(@PathVariable Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Message message = new Message();

        try {
            BoardDto findBoardById = boardService.findBoardById(id);
            if (findBoardById.getId() != null) {
                message.setStatus(StatusEnum.OK);
                message.setData(findBoardById);
                message.setMessage("상세 조회 성공");
            } else {
                message.setStatus(StatusEnum.BAD_REQUEST);
                message.setMessage("fail");
            }
            return new ResponseEntity<>(message, httpHeaders, HttpStatus.OK);
        } catch (Exception e) {
            message.setStatus(StatusEnum.INTERNAL_SERVER_ERROR);
            message.setMessage("fail");
            return new ResponseEntity<>(message, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 등록
     *
     * @param boardDto
     * @return
     */
    @PostMapping("/board")
    public ResponseEntity<Message> registerBoard(@RequestBody BoardDto boardDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Message message = new Message();

        try {
            int registerBoard = boardService.registerBoard(boardDto);
            if (registerBoard == 1) {
                message.setStatus(StatusEnum.OK);
                message.setData(boardDto);
                message.setMessage("등록 성공");
            } else {
                message.setStatus(StatusEnum.BAD_REQUEST);
                message.setMessage("fail");
            }
            return new ResponseEntity<>(message, httpHeaders, HttpStatus.CREATED);
        } catch (Exception e) {
            message.setStatus(StatusEnum.INTERNAL_SERVER_ERROR);
            message.setMessage("fail");
            return new ResponseEntity<>(message, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 수정
     *
     * @param boardDto
     * @return
     */
    @PutMapping("/board")
    public ResponseEntity<Message> updateBoard(@RequestBody BoardDto boardDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Message message = new Message();

        try {
            int updateBoard = boardService.updateBoard(boardDto);
            if (updateBoard == 1) {
                message.setStatus(StatusEnum.OK);
                message.setData(boardDto);
                message.setMessage("수정 성공");
            } else {
                message.setStatus(StatusEnum.BAD_REQUEST);
                message.setMessage("fail");
            }
            return new ResponseEntity<>(message, httpHeaders, HttpStatus.CREATED);
        } catch (Exception e) {
            message.setStatus(StatusEnum.INTERNAL_SERVER_ERROR);
            message.setMessage("fail");
            return new ResponseEntity<>(message, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 삭제
     *
     * @param id
     * @return
     */
    @DeleteMapping("/board/{id}")
    public ResponseEntity<Message> deleteBoard(@PathVariable Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Message message = new Message();

        try {
            int deleteBoard = boardService.deleteBoard(id);
            if (deleteBoard == 1) {
                message.setStatus(StatusEnum.OK);
                message.setData(deleteBoard);
                message.setMessage("삭제 성공");
            } else {
                message.setStatus(StatusEnum.BAD_REQUEST);
                message.setMessage("fail");
            }
            return new ResponseEntity<>(message, httpHeaders, HttpStatus.OK);
        } catch (Exception e) {
            message.setStatus(StatusEnum.INTERNAL_SERVER_ERROR);
            message.setMessage("fail");
            return new ResponseEntity<>(message, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
