# Java Tooling Template

Um repositório modelo para aplicações Java, utilizando:

- [ ] Maven Release Plugin
- [ ] Travis, com release em Github
- [ ] Codecov
- [ ] Sonarqube
- [ ] JUnit 5

## Ferramentas

### Travis

Para que o Travis consiga fazer o deploy no Github releases, é necessário configurar uma variável de ambiente nomeada GITHUB_OAUTH_TOKEN, cujo valor será o TOKEN do Github com os acessos adequados para efetuar o deploy. Veja como criar um Token na [documentação oficial](https://docs.travis-ci.com/user/deployment/releases/), além de como efetuar esta configuração através do Travis CLI, se preferir.

### Codecov

Após adicionar seu projeto ao Github e ter o Travis corretamente configurado, basta acessar o [codecov](https://codecov.io/) e visualizar o seu repositório. O endereço é `https://codecov.io/gh/<usuario-github>/<nome-repositorio>`.