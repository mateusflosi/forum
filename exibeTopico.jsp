<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${titulo}</title>
    </head>
    <body>
        <form action="topicos">
            <input type="hidden" name="login" value="${login}"/>
            <input type="submit" value="voltar">
        </form>
        <h1>${titulo}</h1>
        <h4>Autor: ${autor}</h4>
        <p style="width: 800px">${conteudo}</p>
        <h2>Comentarios:</h2>
        <c:forEach var="item" items="${comentarios}" >
            <h4>${item.key}</h4>
            <p style="width: 800px">${item.value}</p>
        </c:forEach>
        <h4>${erro}</h4>
        <form method="POST" action="comentar">
            <textarea type="text" name="novoComentario" cols="120" rows="10"></textarea>
            <br> <br>
            <input type="hidden" name="login" value="${login}"/>
            <input type="hidden" name="titulo" value="${titulo}"/>
            <input type="submit" value="inserir">
        </form>
    </body>
</html>
