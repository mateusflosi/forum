# Forum

Esse projeto visa construir um site do estilo Forum do zero usando apenas Java(com Servlets e JSPs), HTML e SQL(postgreeSQL). O site foi construido usando o sistema MVC, portanto os codigos estarão divididos em pacotes para que seja a procurar de algum código em específico seja mais facil.

## Login

Essa é a tela inicial da aplicação, caso o login seja bem sucedido ele vai para a tela "Topicos", caso contrário é apresentado um erro na mesma página indicando se o problema esta no login (ele não existe) ou se a a senha está incorreta. Nessa página também existe um link com a opção de fazer um cadastro.

## Cadastro

Para fazer um cadastro basta inserir informações básicas como Nome, email, nickName e senha. O cadastro só terá alguma falha em dois casos: 
1) Login existente
2) Algum campo não foi preenchido

## Topicos

Essa será a principal tela da aplicação, uma vez que será nela que o usuário irá escolher o que deseja fazer no site, as opções são:

1) Consultar o ranking
2) Inserir um novo topico para discussão
3) Entrar em um topico já existente

Para a opção 3 temos ainda duas opções:

1) Entrar nos topicos que ele mesmo criou, esses são os primeiros topicos a seremm mostrados.
2) Entra em um topico que outro usuario criou, nesse caso, além do titulo do topico, também é mostrado o autor do topico.

## Insere Topico

Nessa pagina o autor inicia um novo topico, acrescentando o titulo e o seu conteudo. A unica forma da inserção der erro e se um dos campos ficarem em branco.

## Ranking

É mostrado o ranking dos usuários, a duas formas de ganhar pontos, sendo eles:

1) Iniciando um novo topico
2) Fazendo comentarios em topicos

## Exibindo topicos

Ao clicar em um topico o usuario será redirecionado para a sua respectiva pagina, mas só há uma página para todos os tópicos. A lógica é a seguinte:

1) Ao clicar no topico que o usuario deseja entrar é mandado uma solicitação para o Servlet.
2) Com o titulo, o servlet irá recuperar o autor, o conteudo e os comentarios do topico.

Dessa forma, teremos uma pagina que ira exibir todos os conteudos, o que faz a aplicação ficar muito mais leve.

## Futuros upgrades

* Estilizar o site com CSS
* Dar a opção de editar e apagar comentarios e topicos (caso ele seja autor)
* Dar a opção de editar o cadastro do usuario, inclusive apagando sua conta
* Cria uma classe que busque palavras chaves que possam ofender as pessoas em topicos e comentarios


# IREI COLOCAR UM LINK COM UM VIDEO QUE MOSTRA O FUNCIONAMENTO DO SITE

aceito sugestões de melhorias
