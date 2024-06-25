<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration | English Game</title>
</head>
<body>
<form action="inscription" method="post">
    <fieldset>
        <legend>Inscription Utilisateur</legend>
        <table border="0">
            <tr>
                <td>Nom :</td>
                <td><input type="text" name="nom" value="${nom}"/></td>
                <td>*</td>
            </tr>
            <tr>
                <td>Prénom :</td>
                <td><input type="text" name="prenom" value="${prenom}"/></td>
                <td>*</td>
            </tr>
            <tr>
                <td>Email :</td>
                <td><input type="email" name="email" value="${email}"/></td>
                <td>*</td>
            </tr>
            <tr>
                <td>Mot de Passe :</td>
                <td><input id="pass1" type="password"/></td>
                <td>*</td>
            </tr>
            <tr>
                <td>Confirmer Mot de Passe :</td>
                <td><input id="pass2" type="password"/></td>
                <td>*</td>
            </tr>
            <tr>
                <td></td>
                <td><select name="ville">
                    <c:forEach items="${city}" var="city">
                        <option><c:out value="${city.name}"/></option>
                    </c:forEach>
                </select></td>
                <td>*</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Valider"/><input type="reset" value="Annuler"/></td>
            </tr>
        </table>
        <c:if test="${ not empty erreurs }">
            <p class="erreur">${erreurs}</p>
        </c:if>
    </fieldset>
</form>
</body>
</html>
