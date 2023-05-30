package dreaming.dreaming_example.board.controller;


import dreaming.dreaming_example.board.dto.BoardDto;
import dreaming.dreaming_example.board.entity.Board;
import dreaming.dreaming_example.board.service.BoardService;
import dreaming.dreaming_example.responseEntity.Message;
import dreaming.dreaming_example.responseEntity.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping(path="/")
    @ResponseBody
    public ResponseEntity<Message> getAllBoards() {
        List<Board> boardsReadResult = boardService.viewAllBoard();

        Message responseMessage = new Message(StatusEnum.OK, "Get All Boards Success!", boardsReadResult);
        HttpHeaders headers = getHeader("application","json","UTF-8");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);

    }

    @PostMapping(path="/create")
    @ResponseBody
    //form data 받을 땐 DTO
    public ResponseEntity<Message> createBoard(@RequestBody BoardDto boardDto) {
        Board boardCreateResult = boardService.create(boardDto);

        Message responseMessage = new Message(StatusEnum.OK,"Create Success!", boardCreateResult);
        HttpHeaders headers = getHeader("application","json","UTF-8");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @PostMapping(path="/delete/{id}")
    @ResponseBody
    public ResponseEntity<Message> deleteBoard(@PathVariable Long id) {
        Board boardDeleteResult = boardService.delete(id);

        Message responseMessage = new Message(StatusEnum.OK,"Delete Success!",boardDeleteResult);
        HttpHeaders headers = getHeader("application","json","UTF-8");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @PostMapping(path="/update/{id}")
    @ResponseBody
    public ResponseEntity<Message> updateBoard(@PathVariable Long id, @RequestBody BoardDto boardDto) {
        Board boardUpdateResult = boardService.renewal(id, boardDto);

        Message responseMessage = new Message(StatusEnum.OK,"Update Success!",boardUpdateResult);
        HttpHeaders headers = getHeader("application","json","UTF-8");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);

    }


    public static HttpHeaders getHeader(String type, String subtype, String charsetName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(type, subtype, Charset.forName(charsetName)));

        return headers;
    }






}
