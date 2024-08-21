<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        body {
            background-color: #f5f5f5; /* light gray background */
            font-family: Arial, sans-serif; /* choose a suitable font */
            color: #333; /* dark gray text color */
            padding: 20px;
        }

        .action-links {
            display: flex;
            justify-content: flex-end; /* align to the right */
            margin-bottom: 10px;
        }

        .action-links form {
            margin-left: 5px; /* reduce margin between buttons */
        }

        .search-bar {
            float: right; /* float the search bar to the right */
            margin-bottom: 10px;
        }

        .search-bar input[type=text] {
            padding: 6px;
            margin-right: 5px;
            border: 1px solid #ccc;
            font-size: 14px;
            border-radius: 4px;
            width: 150px; /* adjust width as needed */
        }

        .search-bar button {
            background-color: #ceb6fa; /* green */
            color: white;
            padding: 6px 10px;
            border: none;
            cursor: pointer;
            border-radius: 4px;
            font-size: 14px; /* match font size with input */
        }

        .search-bar button:hover {
            background-color: #9575cd; /* darker green on hover */
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2; /* alternate row colors */
        }

        .edit-link {
            margin-right: 10px;
        }

        button {
            background-color: #ceb6fa; /* light purple */
            color: white; /* dark gray text color */
            padding: 6px 12px; /* adjusted padding */
            border: none;
            cursor: pointer;
            margin-right: 5px; /* reduce margin between buttons */
            font-size: 12px; /* adjusted font size */
        }

        button:hover {
            background-color: #9575cd; /* darker purple on hover */
        }

        a {
            color: #272727; /* yellow links */
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="action-links">
    <form action="/users/signup" method="get">
        <button type="submit">Signup</button>
    </form>
    <form action="/login" method="get">
        <button type="submit">Login</button>
    </form>
    <form action="/logout" method="get">
        <button type="submit">Logout</button>
    </form>
</div>

<div class="search-bar">
    <form action="/search" method="get">
        <input type="text" placeholder="Search..." name="q">
        <button type="submit">Search</button>
    </form>
</div>

<table>
    <c:forEach var="board" items="${boards}">
        <tr>
            <td>${board.id}</td>
            <td><a href="/board/${board.id}">${board.title}</a></td>
            <td>${board.writer}</td>
            <td>
                <a href="/board/${board.id}/edit" class="edit-link">Edit</a>
                <form action="/board/${board.id}/delete" method="post" style="display:inline;">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<div class="pagination" style="text-align: center; margin-top: 10px;">
    <a href="#" style="margin-right: 5px;">1</a>
    <a href="#" style="margin-right: 5px;">2</a>
    <a href="#" style="margin-right: 5px;">3</a>
    <!-- Add more links as needed -->
</div>

<form action="/board/create" method="get">
    <button type="submit">New</button>
</form>
</body>
</html>
