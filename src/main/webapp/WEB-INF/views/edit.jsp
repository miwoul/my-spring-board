<!-- /src/main/webapp/WEB-INF/views/edit.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
</head>
<body>
<h1>게시글 수정</h1>
<form action="/board/${board.id}/edit" method="post">
    <input type="hidden" name="id" value="${board.id}">
    <p>제목: <input type="text" name="title" value="${board.title}" required></p>
<%--    <p>작성자: <input type="text" name="writer" value="${board.writer}" required></p>--%>
    <input type="hidden" name="writer" value="${board.writer}">
    <p>내용: <textarea name="content" rows="5" required>${board.content}</textarea></p>
    <p><button type="submit">EditCheck</button></p>
</form>
<a href="/board/list">목록으로 돌아가기</a>
</body>
</html>
