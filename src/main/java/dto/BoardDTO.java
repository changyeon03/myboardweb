package dto;

import java.sql.Timestamp;
import java.util.Date;

public class BoardDTO {
    private int bno;
    private String title;
    private String content;
    private String writer;
    private Timestamp regDate;
    private int vewCnt;

    public int getVewCnt() {
        return vewCnt;
    }

    public void setVewCnt(int vewCnt) {
        this.vewCnt = vewCnt;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    private int viewCnt;
}