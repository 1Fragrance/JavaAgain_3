<%--
    Document   : index
    Created on : Jan 10, 2022, 9:48:37 PM
    Author     : ILans
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Система учета платежей</title>
</head>
<body>

<h1>Система учета платежей</h1>

<h2>Все платежи</h2>

<c:forEach var="payment" items="${requestScope.payments}">
    <ul>
        <li>Номер счета: <c:out value="${payment.creditCode}"/></li>
        <li>Размер платежа: <c:out value="${payment.value}"/></li>
        <li>Дата платежа: <c:out value="${payment.createDate}"/></li>
    </ul>
    <hr />

</c:forEach>

<h2>Добавление нового платежа</h2>

<form method="post">

    <p>Номер счета</p>
    <label>
        <input type="text" name="code">
    </label>
    <p>Размер платежа</p>
    <label>
        <input type="number" name="value">
    </label>
    <div style="margin-top: 15px">
        <input type="submit" value="Добавить" name="Ok">
    </div>

</form>

</body>
</html>
