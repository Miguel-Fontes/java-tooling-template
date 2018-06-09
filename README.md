# Java Tooling Template

Um repositório modelo para aplicações Java, utilizando:

- Travis
- Codecov
- Sonarqube
- JUnit 5


## Configurações

### Travis

Para que o Travis consiga fazer o deploy no Github releases, é necessário configurar uma variável de ambiente nomeada GITHUB_OAUTH_TOKEN, cujo valor será o TOKEN do Github com os acessos adequados para efetuar o deploy. Veja como criar um Token na [documentação oficial](https://docs.travis-ci.com/user/deployment/releases/), além de como efetuar esta configuração através do Travis CLI, se preferir.
