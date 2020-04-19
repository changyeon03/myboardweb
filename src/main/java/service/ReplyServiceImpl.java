package service;

import dto.ReplyDTO;
import org.springframework.stereotype.Service;
import repository.ReplyMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    ReplyMapper replyMapper;

    @Override
    public List<ReplyDTO> readReply(int bno) {
        return replyMapper.readReply(bno);
    }

    @Override
    public void writeReply(int bno, String writer, String content) {
        replyMapper.writeReply(bno, writer, content);
    }

    @Override
    public void modifyReply(int rno, String writer, String content) {
        replyMapper.modifyReply(rno, writer, content);
    }

    @Override
    public ReplyDTO viewReply(int rno) {
        return replyMapper.viewReply(rno);
    }

    @Override
    public void deleteReply(int rno) {
        replyMapper.delteReply(rno);
    }

    @Override
    public int getBno(int rno) {
        return replyMapper.getBno(rno);
    }
}
