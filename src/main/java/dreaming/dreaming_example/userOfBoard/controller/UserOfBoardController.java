package dreaming.dreaming_example.userOfBoard.controller;

import dreaming.dreaming_example.responseEntity.Message;
import dreaming.dreaming_example.responseEntity.StatusEnum;
import dreaming.dreaming_example.userAuth.entity.UserAuth;
import dreaming.dreaming_example.userOfBoard.dto.UserOfBoardDto;
import dreaming.dreaming_example.userOfBoard.dto.UserOfBoardFilteredDto;
import dreaming.dreaming_example.userOfBoard.entity.UserOfBoard;
import dreaming.dreaming_example.userOfBoard.service.UserOfBoardService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping(path = "/userOfBoard")
public class UserOfBoardController {

    private final UserOfBoardService userOfBoardService;


    @GetMapping(path="/{boardId}")
    @ResponseBody
    public ResponseEntity<Message> getAllEnrolment(@PathVariable Long boardId) {
        List<UserOfBoardFilteredDto> userOfBoardFilteredDtosReadResult = userOfBoardService.getAllEnrolment(boardId);

        Message responseMessage = new Message(StatusEnum.OK, "Get All UserOfBoards Success!", userOfBoardFilteredDtosReadResult);
        HttpHeaders headers = getHeader("application","json","UTF-8");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @PostMapping(path="/enrolment/{userId}/{boardId}")
    @ResponseBody
    public ResponseEntity<Message> enrolmentUserOfBoard(@PathVariable Long userId, @PathVariable Long boardId) {

        UserOfBoard userOfBoardEnrolmentResult = userOfBoardService.enrolment(userId, boardId);

        Message responseMessage = new Message(StatusEnum.OK,"Create Success!", userOfBoardEnrolmentResult);
        HttpHeaders headers = getHeader("application","json","UTF-8");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @PostMapping(path="/delete/{studentId}/{boardId}")
    @ResponseBody
    public ResponseEntity<Message> dropStudent(@PathVariable Long studentId, @PathVariable Long boardId) {

        UserOfBoard boardDeleteResult = userOfBoardService.cancle(studentId, boardId);

        Message responseMessage = new Message(StatusEnum.OK,"Delete Success!",boardDeleteResult);
        HttpHeaders headers = getHeader("application","json","UTF-8");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    public static HttpHeaders getHeader(String type, String subtype, String charsetName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(type, subtype, Charset.forName(charsetName)));

        return headers;
    }



}
