package dreaming.dreaming_example.userOfBoard.repository;

import dreaming.dreaming_example.board.entity.Board;
import dreaming.dreaming_example.userAuth.entity.UserAuth;
import dreaming.dreaming_example.userOfBoard.entity.UserOfBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserOfBoardRepository extends JpaRepository<UserOfBoard, Long> {


    Optional<UserOfBoard> findByUserAuthAndBoard(UserAuth userAuth, Board board);

    List<UserOfBoard> findByBoard(Board board);
}
