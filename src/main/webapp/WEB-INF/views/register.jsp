<%--
  Created by IntelliJ IDEA.
  User: Blazej
  Date: 21.10.2017
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resource/css/reg.css">

    <title>Rejestracja</title>
</head>
<body>

<div class="container" style="position: absolute; left: 0; right: 0;margin: auto" >
    <form:form id="regForm" modelAttribute="user" action="register" method="post"
               cssStyle=" align-content: center; color: red; text-align: center;
               margin-top: 3%;" >
    <form:errors path="*" cssClass="alert alert-danger" element="table"/>
    <table id="tab" align="center" border="0">

            <div class="panel-heading">
                <h3 class="panel-title" align="center" style="color: white"> Zarejestruj się</h3>
            </div>

        <tr>
            <td style="color: white">Imię:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td style="color: white">Nazwisko:</td>
            <td><form:input path="surname"/></td>
           <%-- <form:errors path="surname" cssClass="text-danger"/></td>--%>
        </tr>
        <tr>
            <td style="color: white">Login:</td>
            <td><form:input path="login"/>
                <form:errors path="login" cssClass="text-danger"/></td>

        </tr>
        <tr>
            <td style="color: white">Hasło:</td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td style="color: white">Powtórz hasło:</td>
            <td><form:password path="matchingPassword"/></td>
        </tr>
        <tr>
            <td style="color: white">Adres email:</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Zarejestruj" /></td>
        </tr>
    </table>

    </form:form>
</div>
</body>
</html>
