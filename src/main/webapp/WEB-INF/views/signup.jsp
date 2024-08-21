<!-- signup.jsp -->

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Signup</title>
</head>
<body>
<h2>Signup</h2>
<form action="/users/signup" method="post">
    <label for="username">id:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="passwordcheck">passwordCheck:</label>
    <input type="password" id="passwordcheck" name="passwordConfirm" required><br><br>

    <input type="submit" value="Signup">
</form>
</body>
</html>
