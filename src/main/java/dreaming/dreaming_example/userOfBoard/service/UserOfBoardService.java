package dreaming.dreaming_example.userOfBoard.service;

import dreaming.dreaming_example.userOfBoard.dto.UserOfBoardFilteredDto;
import dreaming.dreaming_example.userOfBoard.entity.UserOfBoard;

import java.util.List;

public interface UserOfBoardService {
    public UserOfBoard enrolment(Long userAuthId, Long boardId);
    public UserOfBoard cancle(Long userAuthId, Long boardId);
    public List<UserOfBoardFilteredDto> getAllEnrolment(Long boardId);
}
