<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Blazej
  Date: 25.11.2017
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/welcome.css">
    <title>Dodaj czujnik</title>
</head>
<body>
<div style="text-align: center;position: absolute; left: 0; right: 0;margin: 3% auto auto;">
<form:form id="regForm" modelAttribute="sensor" action="addSensor" method="post" cssStyle="color: red">
    <form:errors path="*" cssClass="text-danger" element="table"/>
    <table align="center" border="0">
        <tr>
            <td colspan="2" align="center" style="color: white"><h2> Dodaj czujnik</h2> </td>
        </tr>
        <tr>
            <td style="color: white">Nazwa czujnika:</td>
            <td ><form:input path="name"/></td>

        </tr>
        <tr>
            <td style="color: white">Użytkownik:</td>
            <td><form:input path="owner"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input class="btn btn-success" type="submit" value="Dodaj" /></td>
        </tr>

    </table>
</form:form>
    <form  action="/userPage">
        <input class="btn btn-danger" type="submit"  value="anuluj" >
    </form>

</div>
</body>
</html>
