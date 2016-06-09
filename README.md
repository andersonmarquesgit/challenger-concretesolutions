<H1>Projeto Desafio da Concrete Solutions</H1>

A API está disponível para teste em: http://andersonmarques.s156.eatj.com/cs-challenger-rest-1.0

<H2>Endpoints</H2>
<ul>
<li>/cadastro</li>
<li>/login</li>
</ul>

OBS.: Foi mantido uma listagem na home do projeto, apenas para possibilitar a visualização em JSON dos usuários cadastrados. Contudo é possível acessar o banco de dados (utilizado o H2) para visualizá-los. Basta adicionar "/console" a URL (http://andersonmarques.s156.eatj.com/cs-challenger-rest-1.0/console). Tive alguns problemas para fazer o deploy no Heroku e OpenShift, então optei por outro serviço gratuito com Tomcat.

<ul>
<li>Utilizado JWT na geração do Token</li>
<li>Hash na senha</li>
<li>Teste unitário do repositório de usuários</li>
</ul>

<B>Advanced REST Client:</B> Foi utilizado essa extensão do Google Chrome para os testes das requisições https://goo.gl/kBqdTK
