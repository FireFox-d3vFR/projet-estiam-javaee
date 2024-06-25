<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
    <meta charset="UTF-8">
    <link href="style/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>Connexion</h2>
<form action="index" method="post">
    Email: <input type="text" name="email"/><br/>
    Mot de Passe: <input type="password" name="motDePasse"/><br/>
    <input type="submit" value="Se connecter"/>
</form>
<a href="inscription">Inscription</a>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>
</body>
</html>
