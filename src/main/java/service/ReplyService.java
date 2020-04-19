package service;

import dto.ReplyDTO;

import java.util.List;

public interface ReplyService {
    public List<ReplyDTO> readReply(int bno);
    public ReplyDTO viewReply(int rno);
    public void writeReply (int bno, String writer, String content);
    public void modifyReply (int rno, String writer, String content);
    public void deleteReply (int rno);
    public int getBno(int rno);
}
