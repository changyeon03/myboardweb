package repository;

import dto.BoardDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BoardMapper {
    @Select(value = "select * from tbl_board")
    List<BoardDTO> getBoardList();

    @Insert(value = "INSERT INTO tbl_board(title, content, writer) VALUES(#{title}, #{content}, #{writer})")
    void write(@Param("title") String title, @Param("content") String content, @Param("writer") String writer);

    @Select(value = "SELECT bno, title, content, writer, regDate, viewCnt FROM tbl_board WHERE bno = #{bno}")
    public BoardDTO view(@Param("bno") int bno);

    @Update(value = "UPDATE tbl_board set title = #{title}, content = #{content}, writer = #{writer} WHERE bno = #{bno}")
    public void modify(@Param("title") String title, @Param("content") String content, @Param("writer") String writer, @Param("bno") int bno);

    @Update(value = "UPDATE tbl_board set viewCnt = viewCnt+1 WHERE bno = #{bno}")
    public void upView(@Param("bno") int bno);
    @Delete(value = "DELETE FROM tbl_board WHERE bno = #{bno}")
    public void delete(@Param("bno") int bno);
}
