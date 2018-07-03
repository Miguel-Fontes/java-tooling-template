# Java Tooling Template [![Build Status](https://travis-ci.org/Miguel-Fontes/java-tooling-template.svg?branch=master)](https://travis-ci.org/Miguel-Fontes/java-tooling-template)

Um repositório modelo para aplicações Java, utilizando:

- [x] Maven Release Plugin
- [x] Travis, com release em Github
- [x] Codecov
- [x] Sonarqube
- [x] JUnit 5

O artefato final deste projeto é um archetype maven, que pode ser utilizado na criação de novos projetos ou outras ferramentas similares.

## Utilizando o Archetype

### Construindo seu projeto

1. Clone este repositório (`git@github.com:Miguel-Fontes/java-tooling-template.git`)
2. Execute `mvn install`
3. Profit!

Após instalar o archetype em seu repositório, utilize o archetype normalmente. Exemplo:

``` bash
mvn archetype:generate                                     \
  -DarchetypeGroupId=br.com.miguelmf                       \
  -DarchetypeArtifactId=java-tooling-template-archetype    \
  -DarchetypeVersion=1.5-SNAPSHOT                          \
  -DgroupId=br.com.miguelmf                                \
  -DartifactId=meu-projeto                                 \
  -DgithubUser=Miguel-Fontes                               \
  -Dversion=1.0-SNAPSHOT                                   \
  -DinteractiveMode=false
```

O projeto irá considerar que o repositório da aplicação é `<githubUser>/<DartifactId>`. Se o repositório possuir outro nome, ajuste o `pom.xml`, na seção `<scm>`. Feito isto, faça o commit inicial com o push para o Github.

### Travis

Para que o Travis consiga fazer o deploy no Github releases, é necessário configurar uma variável de ambiente nomeada **GITHUB_OAUTH_TOKEN**, cujo valor será o TOKEN do Github com os acessos adequados para efetuar o deploy. Veja como criar um Token na [documentação oficial](https://docs.travis-ci.com/user/deployment/releases/), além de como efetuar esta configuração através do Travis CLI, se preferir.

### Sonarqube

Para projetos open source, o [Sonar Cloud](https://sonarcloud.io/projects) é gratuito Cada build executado no Travis irá encaminhar os novos dados para à plataforma.

Para configurar este comportamento, é necessário acessar o [Sonar Cloud](https://sonarcloud.io/projects) e configurá-lo para sua conta do Github, obtendo um novo token e nome de organização, veja mais no [Get Started](https://about.sonarcloud.io/get-started/). Feito isto, é necessário configurar estes valores como variáveis de ambiente no Travis, por segurança. Acesse a configuração de variáveis de ambiente do travis e crie:

- **SONARQUBE_TOKEN**: com o valor do token;
- **SONARQUBE_ORGANIZATION**: com o nome da organização;

A configuração final no Travis, deverá ficar como:

![image](https://user-images.githubusercontent.com/15656072/41385975-3e349512-6f55-11e8-9d5d-37ca04e63601.png)

## As ferramentas

O ponto central das ferramentas é o Travis, que irá enviar dados sempre que um build for bem sucedido.

### Acessando o Travis

Irá interceptar toda mudança no repositório e efetuar o build.

<TBD informações sobre a configuração>

### Sonarqube

Acessível via [Sonar Cloud](https://sonarcloud.io/projects), receberá dados após o build bem sucedido do travis.

### Codecov

Basta acessar o [codecov](https://codecov.io/) e visualizar o seu repositório. O endereço é `https://codecov.io/gh/<usuario-github>/<nome-repositorio>`.