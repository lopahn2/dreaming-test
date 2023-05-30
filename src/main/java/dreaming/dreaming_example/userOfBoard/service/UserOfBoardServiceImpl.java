package dreaming.dreaming_example.userOfBoard.service;

import dreaming.dreaming_example.board.entity.Board;
import dreaming.dreaming_example.board.repository.BoardRepository;
import dreaming.dreaming_example.userAuth.entity.UserAuth;
import dreaming.dreaming_example.userAuth.repository.UserAuthRepository;
import dreaming.dreaming_example.userOfBoard.dto.UserOfBoardFilteredDto;
import dreaming.dreaming_example.userOfBoard.entity.UserOfBoard;
import dreaming.dreaming_example.userOfBoard.repository.UserOfBoardRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class UserOfBoardServiceImpl implements UserOfBoardService{

    private final UserOfBoardRepository userOfBoardRepository;
    private final BoardRepository boardRepository;
    private final UserAuthRepository userAuthRepository;
    @Override
    public UserOfBoard enrolment(Long userAuthId, Long boardId) {

        UserAuth resultOfFindUserAuth = userAuthRepository.findById(userAuthId).orElseThrow(
                () -> new RuntimeException("존재하지 않는 사용자 아이디입니다.")
        );

        Board resultOfFindBoard = boardRepository.findById(boardId).orElseThrow(
                () -> new RuntimeException("존재하지 않는 보드 아이디입니다.")
        );

        UserOfBoard userOfBoard = UserOfBoard.builder()
                        .userAuth(resultOfFindUserAuth)
                        .board(resultOfFindBoard)
                        .build();

        userOfBoardRepository.save(userOfBoard);
        return userOfBoard;
    }

    @Override
    public UserOfBoard cancle(Long userAuthId, Long boardId) {

        CheckValidator cv = new CheckValidator(userAuthId, boardId);

        userOfBoardRepository.delete(cv.userOfBoard);

        return cv.userOfBoard;
    }

    @Override
    public List<UserOfBoardFilteredDto> getAllEnrolment(Long boardId) {


        Board resultOfFindBoard = boardRepository.findById(boardId).orElseThrow(
                () -> new RuntimeException("존재하지 않는 보드 아이디입니다.")
        );

        List<UserOfBoardFilteredDto> userOfBoardFilteredDtos = new ArrayList<>();

        for (UserOfBoard uob :userOfBoardRepository.findByBoard(resultOfFindBoard)) {
            userOfBoardFilteredDtos.add(uob.toFilteredDto());
        }

        return userOfBoardFilteredDtos;
    }


    public class CheckValidator {
        private UserAuth userAuth;
        private Board board;
        private UserOfBoard userOfBoard;
        public CheckValidator(Long userAuthId, Long boardId) {
            this.userAuth = userAuthRepository.findById(userAuthId).orElseThrow(
                    () -> new RuntimeException("존재하지 않는 사용자 아이디입니다.")
            );
            this.board = boardRepository.findById(boardId).orElseThrow(
                    () -> new RuntimeException("존재하지 않는 보드 아이디입니다.")
            );
            this.userOfBoard = userOfBoardRepository.findByUserAuthAndBoard(this.userAuth, this.board).orElseThrow(
                    () -> new RuntimeException("신청 내역이 존재하지 않습니다.")
            );
        }


    }
}
