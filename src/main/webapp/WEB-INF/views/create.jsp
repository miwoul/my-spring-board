<!-- /src/main/webapp/WEB-INF/views/create.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 등록</title>
</head>
<body>
<h1>게시글 등록</h1>
<form action="/board/create" method="post">
    <p>제목: <input type="text" name="title" required></p>
<%--    <p>작성자: <input type="text" name="writer" required></p>--%>
    <p>내용: <textarea name="content" rows="5" required></textarea></p>
    <p><button type="submit">등록</button></p>
</form>
<a href="/board/list">목록으로 돌아가기</a>
</body>
</html>
