package dreaming.dreaming_example.userAuth.controller;

import dreaming.dreaming_example.board.dto.BoardDto;
import dreaming.dreaming_example.board.entity.Board;
import dreaming.dreaming_example.responseEntity.Message;
import dreaming.dreaming_example.responseEntity.StatusEnum;
import dreaming.dreaming_example.userAuth.dto.UserAuthDto;
import dreaming.dreaming_example.userAuth.entity.UserAuth;
import dreaming.dreaming_example.userAuth.service.UserAuthService;
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
@RequestMapping(path = "/userAuth")
public class UserAuthController {

    private final UserAuthService userAuthService;

    @GetMapping(path="/")
    @ResponseBody
    public ResponseEntity<Message> getAllUserAuth() {
        List<UserAuth> userAuthsReadResult = userAuthService.getAllUserAuthInfo();

        Message responseMessage = new Message(StatusEnum.OK, "Get All Boards Success!", userAuthsReadResult);
        HttpHeaders headers = getHeader("application","json","UTF-8");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);

    }

    @PostMapping(path="/create")
    @ResponseBody
    //form data 받을 땐 DTO
    public ResponseEntity<Message> signUpUserAuth(@RequestBody UserAuthDto userAuthDto) {
        UserAuth userAuthCreateResult = userAuthService.signUp(userAuthDto);

        Message responseMessage = new Message(StatusEnum.OK,"Create Success!", userAuthCreateResult);
        HttpHeaders headers = getHeader("application","json","UTF-8");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @PostMapping(path="/delete/{id}")
    @ResponseBody
    public ResponseEntity<Message> signOutUserAuth(@PathVariable Long id) {
        UserAuth userAuthDeleteResult = userAuthService.signOut(id);

        Message responseMessage = new Message(StatusEnum.OK,"Delete Success!",userAuthDeleteResult);
        HttpHeaders headers = getHeader("application","json","UTF-8");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }


    public static HttpHeaders getHeader(String type, String subtype, String charsetName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(type, subtype, Charset.forName(charsetName)));

        return headers;
    }

}
