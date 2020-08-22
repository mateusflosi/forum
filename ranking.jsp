<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ranking</title>
    </head>
    <body>
        <h1>Confira sua pontuação e colocação no ranking</h1>
        <table style="width:50%">
            <tr>
                <th>Colocação</th>
                <th>Nome</th>
                <th>nickName</th>
                <th>Pontuação</th>
            </tr>
            <c:forEach var="item" items="${ranking}" >
            <tr>
                <td>${item.colocacao}</td>        
                <td>${item.nome}</td>
                <td>${item.login}</td>
                <td>${item.pontos}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
