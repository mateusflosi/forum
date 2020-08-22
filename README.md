# Forum

Esse projeto visa construir um site do estilo Forum do zero usando apenas Java(com Servlets e JSPs), HTML e SQL(postgreeSQL). O site foi construido usando o sistema MVC, portando os codigos estarão divididos em pacotes para que seja a procurar de algum código em específico seja mais facil.

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

