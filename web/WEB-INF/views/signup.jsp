<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Sign Up</h1>
<form action="signup", method="post">
    <label>ACCOUNT : </label>
    <input name="account" type="email"><br>
    <label>PASSWORD :</label>
    <input name="password" type="password" minlength="6" maxlength="15" required><br>
    <label>NICK_NAME :</label>
    <input name="nick_name" type="text" minlength="3" maxlength="15" required><br>
    <input type="submit" value="회원가입">
</form>
</body>
</html>