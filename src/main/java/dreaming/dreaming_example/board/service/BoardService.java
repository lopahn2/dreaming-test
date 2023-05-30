package dreaming.dreaming_example.board.service;

import dreaming.dreaming_example.board.dto.BoardDto;
import dreaming.dreaming_example.board.entity.Board;

import java.util.List;

public interface BoardService {

    public Board create(BoardDto boardDto);
    public Board delete(Long id);
    public Board renewal(Long id, BoardDto boardDto);

    public List<Board> viewAllBoard();
}
