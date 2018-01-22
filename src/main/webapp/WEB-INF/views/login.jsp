<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/login.css">
<title>Zaloguj się </title>
</head>

<body>
<div class="container">

    <form:form id="regForm" modelAttribute="login" action="login" method="post"
			   cssStyle="align-content: center; color: red; text-align: center; margin-top: 5%">

        <form:errors path="*" cssClass="text-danger" element="table" id="errors"/>

	<table align="center" border="0">
		<div class="panel-heading">
			<h2 class="panel-title" align="center" style="color: white; margin-top: 3%">Zaloguj się</h2>
		</div>
		<tr>
			<td style="color: white">Login:</td>
			<td><form:input path="login"/>
				<form:errors path="login"/></td>
		</tr>
		<tr>
			<td style="color: white">Hasło:</td>
			<td><form:password path="password"/>
				<form:errors path="password"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Zaloguj" /></td>
		</tr>

	</table>
</form:form>
</div>
</body>
</html>