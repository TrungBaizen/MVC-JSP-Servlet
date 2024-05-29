<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2024
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="../view/style.css">
</head>
<body>
<form method="post" >
    <input type="text" name="id" value="${book.id}" readonly>
    <input type="text" name="name" value="${book.name}" >
    <input type="text" name="price" value="${book.price}">
    <input type="text" name="description" value="${book.description}">
    <input type="text" name="author" value="${book.author}">
    <input type="text" name="image" value="${book.image}">
    <img src="${book.image}">
    <button>Submit</button>
</form>
</body>
</html>
