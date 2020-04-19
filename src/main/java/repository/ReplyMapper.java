package repository;

import dto.BoardDTO;
import dto.ReplyDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ReplyMapper {
    @Select(value = "SELECT rno, content, writer, regDate FROM tbl_reply WHERE bno = ${bno}")
    public List<ReplyDTO> readReply(@Param("bno") int bno);

    @Select(value = "SELECT * FROM tbl_reply WHERE rno = #{rno}")
    public ReplyDTO viewReply(@Param("rno") int rno);

    @Select(value = "SELECT bno FROM tbl_reply WHERE rno=#{rno}")
    public int getBno(@Param("rno") int rno);

    @Insert(value = "INSERT INTO tbl_reply(bno, writer, content) VALUES(#{bno}, #{writer}, #{content})")
    public void writeReply(@Param("bno") int bno, @Param("writer") String writer, @Param("content") String content);

    @Update(value = "UPDATE tbl_reply set content = #{content}, writer = #{writer} WHERE rno = #{rno}")
    public void modifyReply(@Param("rno") int rno, @Param("writer") String writer, @Param("content") String content);

    @Delete(value = "DELETE FROM tbl_reply WHERE rno = #{rno}")
    public void delteReply(@Param("rno") int rno);

}
