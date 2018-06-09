# Java Tooling Template [![Build Status](https://travis-ci.org/Miguel-Fontes/java-tooling-template.svg?branch=master)](https://travis-ci.org/Miguel-Fontes/java-tooling-template)

Um repositório modelo para aplicações Java, utilizando:

- [x] Maven Release Plugin
- [x] Travis, com release em Github
- [x] Codecov
- [x] Sonarqube
- [x] JUnit 5

## Ferramentas

### Travis

Para que o Travis consiga fazer o deploy no Github releases, é necessário configurar uma variável de ambiente nomeada GITHUB_OAUTH_TOKEN, cujo valor será o TOKEN do Github com os acessos adequados para efetuar o deploy. Veja como criar um Token na [documentação oficial](https://docs.travis-ci.com/user/deployment/releases/), além de como efetuar esta configuração através do Travis CLI, se preferir.

### Codecov

Após adicionar seu projeto ao Github e ter o Travis corretamente configurado, basta acessar o [codecov](https://codecov.io/) e visualizar o seu repositório. O endereço é `https://codecov.io/gh/<usuario-github>/<nome-repositorio>`.

### Sonarqube

Para projetos open source, o [Sonar Cloud](https://sonarcloud.io/projects) é gratuito Cada build executado no Travis irá encaminhar os novos dados para à plataforma.

Para configurar este comportamento, é necessário acessar o [Sonar Cloud](https://sonarcloud.io/projects) e configurá-lo para sua conta do Github, obtendo um novo token e nome de organização. Feito isto, acesse a configuração de variáveis de ambiente do travis e crie:

- **SONARQUBE_TOKEN**: com o valor do token;
- **SONARQUBE_ORGANIZATION**: com o nome da organização;

## Próximos passos

- [ ] Adicionar referência à guia de configuração de variáveis de ambiente no Travis
- [ ] Adicionar referência à guia de configuração de conta no Sonar Cloud