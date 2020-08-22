<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topicos</title>
    </head>
    <body>
        <h1>Bem vindo ${nome}</h1>
        <table>
            <tr>
                <th>Seus topicos</th>
            </tr>
            <c:forEach var="item" items="${topicosUsuario}" >
            <tr>
                <td>
                    <form action="exibeTopico">
                        <input type="hidden" name="titulo" value="${item}" />
                        <input type="hidden" name="login" value="${login}"/>
                        <input type="submit" value="${item}">
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
        <br> <br>
        <table>
            <tr>
                <th>Outros topicos</th>
                <th>Autor</th>
            </tr>
            <c:forEach var="item" items="${outrosTopicos}" >
            <tr>
                <td>
                    <form action="exibeTopico">
                        <input type="hidden" name="titulo" value="${item.key}" />
                        <input type="hidden" name="login" value="${login}" />
                        <input type="submit" value="${item.key}">
                    </form>
                </td>
                <td>${item.value}</td>
            </tr>
            </c:forEach>
        </table>
        <br> <br>
        <form action="insereTopico.jsp">
            <input type="hidden" name="login" value="${login}" />
            <input type="submit" value="Começar novo topico">
        </form>
        <form action="Ranking">
            <input type="submit" value="Ranking">
        </form>
        <br> <br>
    </body>
</html>
