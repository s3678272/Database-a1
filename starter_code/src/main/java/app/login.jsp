<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<% /* CSS author: Nuozehua Li */ %>
<% /* HTML author:Nuozehua Li */ %>
<% /* Java logic:Yitao Ma */ %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login Page</title>
    <style type="text/css">
        body {
            margin: 0px;
            padding: 0px;
            height: 180px;
            background-image: url(http://img.kuai8.com/article/image/202101/08/ac910b4971.jpg);
            background-size: 100% 100%;
        }
        #error {
            color: red;
            font-weight: bold;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif
        }
        h3 {
            color: red;
            font-weight: bold;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif
        }
        h1 {
            color: wheat;
            text-align: center;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif
        }
        div {
            background-color: #E8E8E8;
            border: 2px solid red;
            padding: 10px;
            border-radius: 50px 20px;
        }
        input {
            width: 320px;
            height: 45px;
            margin: 0px 8px;
            border-radius: 10px;
            text-indent: 10px;
            margin: 10px auto;
        }
        form {
            text-align: center;
            background: gray;
            margin: 50px;
            padding: 50px;
        }
    </style>
</head>
<body>
<form action="loginServlet" method="post">
    <h1>User Login</h1>
    <%
        String errorMsgL = (String) request.getAttribute("errorMsgL");
        String errorEmailempty = (String) request.getAttribute("errorEmailempty");
        String errorPasswordempty = (String) request.getAttribute("errorPasswordempty");
        if (errorMsgL == null) {
            errorMsgL = "";
        }
        if (errorEmailempty == null) {
            errorEmailempty = "";
        }
        if (errorPasswordempty == null) {
            errorPasswordempty = "";
        }
        //String errorEPempty = (String) request.getAttribute("errorEPempty");
    %>
    <h3><%=errorMsgL %>
    </h3>
    E-mail: <br>
    <input type="text" name="email" placeholder="e.g. jdo@test.com"><br>
    <span id="error"><%=errorEmailempty%></span>
    <br>
    password: <br>
    <input type="password" name="password" placeholder="e.g. 12sdF56"><br>
    <span id="error"><%=errorPasswordempty%></span>
    <br>
    <input type="submit" value="Login">
    <br>
    <div>Don't have an account? Click <a href="http://localhost:8080/IMDB/register.jsp">Register</a> here!</div>
</form>
</body>
</html>