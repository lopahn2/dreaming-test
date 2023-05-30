package dreaming.dreaming_example.board.service;

import dreaming.dreaming_example.board.dto.BoardDto;
import dreaming.dreaming_example.board.entity.Board;
import dreaming.dreaming_example.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public Board create(BoardDto boardDto) {
        if (boardDto.getApplyLimit()==0) {
            throw new RuntimeException("수강인원 수는 1명 이상만 가능합니다.");
        }

        boardRepository.save(boardDto.toEntity());
        return boardDto.toEntity();
    }

    @Override
    public Board delete(Long id) {
        Board resultOfFindBoard = boardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("존재하지 않는 게시글의 id 입니다.")
        );

        boardRepository.delete(resultOfFindBoard);
        return resultOfFindBoard;
    }

    @Override
    public Board renewal(Long id, BoardDto boardDto) {

        Board resultOfFindBoard = boardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("존재하지 않는 게시글의 id 입니다.")
        );
        resultOfFindBoard.updateBoard(boardDto);

        return resultOfFindBoard;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> viewAllBoard() {
        return boardRepository.findAll();
    }

}
