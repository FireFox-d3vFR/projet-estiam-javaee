<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
<h2>Inscription</h2>
<form action="inscription" method="post">
    Email: <input type="text" name="email"/><br/>
    Nom: <input type="text" name="nom"/><br/>
    Prénom: <input type="text" name="prenom"/><br/>
    Mot de passe: <input type="password" name="motDePasse"/><br/>
    Ville:
    <select name="ville">
        <c:forEach var="ville" items="${villes}">
            <option value="${ville.id}">${ville.nom}</option>
        </c:forEach>
    </select><br/>
    <input type="submit" value="S'inscrire"/>
</form>
<a href="index">Connexion</a>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>
</body>
</html>
