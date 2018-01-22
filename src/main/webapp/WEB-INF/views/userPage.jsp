<%--
  Created by IntelliJ IDEA.
  User: Blazej
  Date: 21.10.2017
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/userPage.css">
    <link rel="stylesheet" type="text/css" href="/resources/js/DataTables/DataTables-1.10.16/css/jquery.dataTables.min.css">

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" charset="utf8" src="/resources/js/DataTables/DataTables-1.10.16/js/jquery.dataTables.js"></script>
    <script src="/resources/js/dist/jquery.jqplot.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/js/dist/jquery.jqplot.min.css">
    <script src="/resources/js/controller.js"></script>

    <title>Dane użytkownika </title>
</head>
<body>

<h1 align="center"> Zalogowany jako ${user.login}</h1>
<div>
    <form action="/logout">

        <input class="btn btn-danger pull-right" type="submit" value="Wyloguj się">

    </form>
</div>
<div id="sens">
    <%--
<form:form modelAttribute="user" action="userPage" method="post">
<form:select path="sensorsList"  id="dropdown">
    <c:forEach items="${sensors}" var="sensor">
        <form:option value="${sensor.id}" label="${sensor.name}" id="element"/>
    </c:forEach>
</form:select>
</form:form>--%>
<h4>Lista czujników</h4>
    <form>
        <select id="dropdown">
            <c:forEach var="sensor" items="${sensors}" >
                <option value="${sensor.id}" >${sensor.name}</option>
            </c:forEach>
        </select>
    </form>

</div>

    <div>
        <form>

            <input id="showDataButton" class="btn btn-primary" type="button" value="Wyświetl dane" >

        </form>
    </div>

    <div>
        <form action="/addSensor">

                <input class="btn btn-success " type="submit" value="Dodaj czujnik" >

            </form>
    </div>

<div>
    <h4>Opcje filtracji wykresu</h4>
    <form>
        Od: <input id="beginDate" type="text" value="2018-01-01"><br>
        Do: <input id="endDate" type="text" value="2099-12-31"> <br>
        Minimalna wartość: <input id="min" type="number" value="-30" step="0.01"><br>
        Maksymalna wartość: <input id="max" type="number" value="2000" step="0.01">
    </form>
    <input id="filterButton" class="btn btn-warning" type="button" value="Filtruj dane">

</div>



<div style="position: relative; height:30vh; width:80vw">
<div id="myChart"></div>

    <table id="dataTable">
        <thead>
            <tr>
                <th>Nr pomiaru</th>
                <th>Wartość</th>
                <th>Czas</th>
            </tr>
        </thead>

    </table>

</body>
</html>
