<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Connexion | English Game</title>
    <meta charset="UTF-8">
    <link href="style/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="connexion" method="post">
    <fieldset>
        <legend>Connexion</legend>
        <table border="0">
            <tr>
                <td>Email :</td>
                <td><input id="email" type="email" name="email" value="${email}"/></td>
                <td>*</td>
            </tr>
            <tr>
                <td>Mot de Passe :</td>
                <td><input id="pass1" type="password" name="password" value=""/></td>
                <td>*</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Connexion"/></td>
                <td></td>
            </tr>
        </table>
        <c:if test="${ not empty erreurs }">
            <p class="erreur">${erreurs}</p>
        </c:if>
    </fieldset>
</form>
</body>
</html>
