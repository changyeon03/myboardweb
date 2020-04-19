<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 조회</title>
</head>
<body>
<a href="/board/write">게시글 작성</a>
<form method="post">

    <label>제목</label>
    ${view.title}<br />

    <label>작성자</label>
    ${view.writer}<br />

    <label>내용</label><br />
    ${view.content}<br />
    <div>
        <a href="/board/modify?bno=${view.bno}">게시물 수정</a>
        <a href="/board/delete?bno=${view.bno}">게시물 삭제</a>
    </div>
    <!-- 게시물 끝 -->
    <table>
        <thead>
        <tr>
            <th>번호</th>
            <th>내용</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>수정/삭제</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${readReply}" var="readReply">
            <tr>
                <td>${readReply.rno}</td>
                <td>${readReply.content}</td>

                <td>${readReply.writer}</td>
                <td>${readReply.regDate}</td>
                <td><a href="/board/modifyReply?rno=${readReply.rno}">수정</a> <a href="/board/deleteReply?rno=${readReply.rno}">삭제</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
<form method="post", action="/board/writeReply">
    <input type="hidden" id="bno" name="bno" value="${view.bno}" readonly="readonly"/>
    <label>작성자</label>
    <input type="text" name="writer" value="${userName}" readonly="readonly"/><br />

    <label>내용</label>
    <textarea cols="50" rows="5" name="content"></textarea><br />

    <button type="submit">작성</button>

</form>
<a href="/board/list">목록으로</a>
</body>
</html>