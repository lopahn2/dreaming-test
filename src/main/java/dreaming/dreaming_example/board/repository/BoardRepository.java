package dreaming.dreaming_example.board.repository;

import dreaming.dreaming_example.board.dto.BoardDto;
import dreaming.dreaming_example.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findById(Long boardId);
//    @Transactional
//    @Modifying
//    @Query(value = "update Board set title = #(#paramBoard.title), content = #(#paramBoard.content), applyLimit = #(#paramBoard.applyLimit), dueDate = #(#paramBoard.dueDate)", nativeQuery=true)
//    Optional<Board> updateBoard(@Param(value = "paramBoard") BoardDto boardDto);
}
