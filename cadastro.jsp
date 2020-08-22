<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Cadastro</h1>
        <h3>${erro}</h3>
        <form method="POST" action="Cadastrar">
            Nome: <input type="text" name="nome" />
            <br> <br>
            Login: <input type="text" name="login" />
            <br> <br>
            Email: <input type="text" name="email" />
            <br> <br>
            Senha: <input type="password" name="senha" />
            <br> <br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>

