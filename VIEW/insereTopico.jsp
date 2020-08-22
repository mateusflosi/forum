<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Topico</title>
    </head>
    <body>
        <h1>Deseja começar um novo topico ${param.login}?</h1>
        <h4>${erro}</h4>
        <form method="POST" action="inserirTopico">
            <textarea type="text" name="titulo" cols="100"></textarea>
            <br> <br>
            <textarea type="text" name="conteudo" rows="25" cols="100"></textarea>
            <br> <br>
            <input type="hidden" name="login" value="${param.login}"/>
            <input type="submit" value="inserir">
        </form>
    </body>
</html>
