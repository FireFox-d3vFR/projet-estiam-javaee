<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Jeu</title>
</head>
<body>
<h2>Jeu</h2>
<form action="jeu" method="post">
    Verbe: ${verbe.baseVerbale}<br/>
    Prétérit: <input type="text" name="preterit"/><br/>
    Participe Passé: <input type="text" name="participePasse"/><br/>
    <input type="hidden" name="baseVerbale" value="${verbe.baseVerbale}"/>
    <input type="submit" value="Valider"/>
</form>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>
</body>
</html>
