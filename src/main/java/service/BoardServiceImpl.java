package service;

import dto.BoardDTO;
import org.springframework.stereotype.Service;
import repository.BoardMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Resource
    BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getBoardList() {
        return boardMapper.getBoardList();
    }

    @Override
    public void write(String title, String content, String writer) {
        boardMapper.write(title, content, writer);
    }

    @Override
    public BoardDTO view(int bno) {
        return boardMapper.view(bno);
    }

    @Override
    public void modify(String title, String content, String writer, int bno) {
        boardMapper.modify(title, content, writer, bno);
    }

    @Override
    public void delete(int bno) {
        boardMapper.delete(bno);
    }

    @Override
    public void upView(int bno) {
        boardMapper.upView(bno);
    }
}
