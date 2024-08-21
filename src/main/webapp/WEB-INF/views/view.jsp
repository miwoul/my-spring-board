<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${board.title} 상세보기</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #af6dff; /* 보라색 */
            margin-bottom: 10px;
        }
        hr {
            border: none;
            border-top: 1px solid #ccc;
            margin: 20px 0;
        }
        .comment-form {
            margin-top: 20px;
        }
        .comment-form textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }
        .comment-form input[type="submit"] {
            background-color: #b476ff; /* 보라색 */
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 4px;
        }
        .comment-form input[type="submit"]:hover {
            background-color: #5632a8; /* 짙은 보라색 */
        }
        .back-link {
            display: block;
            margin-top: 20px;
            color: #6A5ACD; /* 보라색 */
            text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
        .comment {
            margin-top: 20px;
            border-top: 1px solid #ccc;
            padding-top: 10px;
        }
        .comment p {
            margin-bottom: 5px;
        }
        .comment .meta {
            font-size: 0.9em;
            color: #888;
        }
        /* Improved styling for comment list */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table th, table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        table th {
            background-color: #f2f2f2;
            color: #333;
            text-align: center; /* Center-align headings */
        }
        table td {
            background-color: #fff;
            text-align: center; /* Center-align content */
        }
        table td form {
            margin: 0;
        }
        table td form input[type="submit"] {
            background-color: #ab66ff; /* 빨간색 */
            color: #fff;
            border: none;
            padding: 6px 12px;
            cursor: pointer;
            border-radius: 4px;
        }
        table td form input[type="submit"]:hover {
            background-color: #7000cc; /* 짙은 빨간색 */
        }
    </style>
</head>
<body>
<div class="container">
    <h1>${board.title}</h1>
    <p>작성자: ${board.writer}</p>
    <p>작성일: ${board.createdAt}</p>
    <hr>
    <p>${board.content}</p>
    <hr>

    <!-- 댓글 입력 폼 -->
    <form class="comment-form" action="/comment" method="post">
        <textarea name="content" rows="4" placeholder="댓글을 작성해 주세요..." required></textarea><br>
        <input type="hidden" name="boardId" value="${board.id}">
        <input type="submit" value="댓글 작성">
    </form>

    <hr>

    <!-- 댓글 목록 -->
    <h3>댓글 목록</h3>
    <table>
        <thead>
        <tr>
            <th>작성자</th>
            <th>내용</th>
            <th>작성일</th>
            <th>삭제</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${board.comments}" var="comment">
            <tr>
                <td>${comment.username}</td>
                <td>${comment.content}</td>
                <td>${comment.createdAt}</td>
                <td>
                    <form action="/comment/${comment.id}" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
                        <input type="hidden" name="commentId" value="${comment.id}">
                        <input type="submit" value="삭제">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <hr>
    <a class="back-link" href="/board/list">목록으로 돌아가기</a>
</div>
</body>
</html>
