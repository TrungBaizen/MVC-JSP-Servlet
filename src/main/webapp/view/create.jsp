<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2024
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create</title>
    <link rel="stylesheet" href="../view/style.css">
</head>
<body>
<form method="post" action="http://localhost:9999/books?action=create">
    <input type="text" name="id" placeholder="Id">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="price" placeholder="Price">
    <input type="text" name="description" placeholder="Description">
    <input type="text" name="author" placeholder="Author">
    <input type="text" name="image" placeholder="Image">
    <button>Submit</button>
</form>
</body>
</html>