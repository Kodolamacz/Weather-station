<%--
  Created by IntelliJ IDEA.
  User: Blazej
  Date: 17.10.2017
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/resources/css/welcome.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<head>
    <title>Stacja pogodowa</title>
</head>
<body style="width: 100%;
    background-repeat: no-repeat;
    background-size: contain;
    background-image: url('/resources/img/welcome.jpg');">

<div class="container">

    <h1 align="center" style="color: white"> ${message}</h1>

</div>


<div class="container">
    <div>
        <form action="/login">

            <input class="btn btn-success pull-right " type="submit"  value="Zaloguj się" >

        </form>
    </div>
    <div>
        <form action="/register">

            <input class="btn btn-success pull-right" type="submit"  value="Zarejestruj się" >

        </form>
    </div>

</div>

<div class="w3-content w3-section" style="max-width:60%">
    <img class="mySlides w3-animate-fading" src="/resources/img/1.jpg" style="width:100%">
    <img class="mySlides w3-animate-fading" src="/resources/img/2.jpg" style="width:100%">
    <img class="mySlides w3-animate-fading" src="/resources/img/3.jpg" style="width:100%">
    <img class="mySlides w3-animate-fading" src="/resources/img/4.jpeg" style="width:100%">
</div>

<script src="/resources/js/slideshow.js">
</script>




</body>
</html>
