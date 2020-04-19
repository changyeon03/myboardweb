package service;

import dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> getBoardList();
    public void write(String title, String content, String writer);
    public BoardDTO view(int bno);
    public void modify(String title, String content, String writer, int bno);
    public void delete(int bno);
    public void upView(int bno);
}
