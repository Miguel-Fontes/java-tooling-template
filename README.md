# Java Tooling Template [![Build Status](https://travis-ci.org/Miguel-Fontes/java-tooling-template.svg?branch=master)](https://travis-ci.org/Miguel-Fontes/java-tooling-template)

Um repositório modelo para aplicações Java, utilizando:

- [x] Maven Release Plugin
- [x] Travis, com release em Github
- [x] Codecov
- [x] Sonarqube
- [x] JUnit 5

O artefato final deste projeto é um archetype maven, que pode ser utilizado na criação de novos projetos ou outras ferramentas similares.

## Ferramentas

### Travis

Para que o Travis consiga fazer o deploy no Github releases, é necessário configurar uma variável de ambiente nomeada GITHUB_OAUTH_TOKEN, cujo valor será o TOKEN do Github com os acessos adequados para efetuar o deploy. Veja como criar um Token na [documentação oficial](https://docs.travis-ci.com/user/deployment/releases/), além de como efetuar esta configuração através do Travis CLI, se preferir.

Adicionalmente, deve ser definida uma variável *$OUTPUT_DIR*, indicando o diretório do arquivo que se deseja efetuar o deploy. A busca pelo arquivo é feita no seguinte diretório:

    $TRAVIS_BUILD_DIR/$OUTPUT_DIR

Nesta linha:

- **$TRAVIS_BUILD_DIR**: variável de ambiente do próprio travis, e refere-se ao diretório raiz so projeto Java;
- **$OUTPUT_DIR**: esta variável deve ser setada, indicando o diretório onde o arquivo será localizado, abaixo do diretório raiz.

Um exemplo:

- $TRAVIS_BUILD_DIR: /usr/home/dev/jProject
- $OUTPUT_DIR: ui-module/target

Concatenando ambas as variáveis, temos `/usr/home/dev/jProject/ui-module/target`.

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
- [ ] Transformar em Maven Archetype