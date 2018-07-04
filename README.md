# Java Tooling Template [![Build Status](https://travis-ci.org/Miguel-Fontes/java-tooling-template.svg?branch=master)](https://travis-ci.org/Miguel-Fontes/java-tooling-template)

Um repositório modelo para aplicações Java, utilizando:

- [x] Maven Release Plugin
- [x] Travis, com release em Github
- [x] Codecov
- [x] Sonarqube
- [x] JUnit 5

O artefato final deste projeto é um archetype maven, que pode ser utilizado na criação de novos projetos ou outras ferramentas similares.

<!-- TOC -->

- [Java Tooling Template ![Build Status](https://travis-ci.org/Miguel-Fontes/java-tooling-template)](#java-tooling-template-build-statushttpstravis-ciorgmiguel-fontesjava-tooling-template)
  - [Instalando o Archetype](#instalando-o-archetype)
    - [Método 1 - Clonando o Repositório](#m%C3%A9todo-1---clonando-o-reposit%C3%B3rio)
    - [Método 2 - Script de instalação](#m%C3%A9todo-2---script-de-instala%C3%A7%C3%A3o)
    - [Método 3 - Maven Install File](#m%C3%A9todo-3---maven-install-file)
  - [Criando e configurando seu projeto](#criando-e-configurando-seu-projeto)
    - [Criando o projeto com o Maven](#criando-o-projeto-com-o-maven)
    - [Configurando o Travis](#configurando-o-travis)
    - [Configurando o Sonarqube](#configurando-o-sonarqube)
    - [YOUR_NAME nome no arquivo LICENSE](#yourname-nome-no-arquivo-license)
  - [Utilizando as ferramentas](#utilizando-as-ferramentas)
    - [Acessando o Travis](#acessando-o-travis)
    - [Sonarqube](#sonarqube)
    - [Codecov](#codecov)

<!-- /TOC -->

## Instalando o Archetype

### Método 1 - Clonando o Repositório

1. Clone este repositório (`git@github.com:Miguel-Fontes/java-tooling-template.git`)
2. Execute `mvn install`
3. Profit!

### Método 2 - Script de instalação

Então, você quer uma instalação automatizada? We got it! Navegue até um diretório de sua escolha e:

``` shell
$ wget https://raw.githubusercontent.com/Miguel-Fontes/java-tooling-template/master/utils/install.sh
$ chmod +x install.sh
$ ./install.sh
```

O script aceita um argumento, a versão à ser instalada (que deve ser o nome de um release do Github releases). Se nenhuma versão for indicada, a mais recente é considerada.

![install-java-tooling](https://user-images.githubusercontent.com/15656072/42250090-2aa39808-7f05-11e8-9a23-f133eda89cc3.gif)

### Método 3 - Maven Install File

Baixa sua versão favorita do github releases, extraia, e a instale com o `mvn install:install-file`. Exemplificando abaixo, considerando que o Jar está no diretório de trabalho atual (lembre-se de alterar as versões em `-Dversion` e no nome do arquivo, em `-Dfile`).

``` bash
mvn install:install-file -Dfile=java-tooling-template-archetype-1.7.jar \
  -DgroupId=br.com.miguelfontes                   \
  -DartifactId=java-tooling-template-archetype    \
  -Dpackaging=jar                                 \
  -Dversion=1.7
```

## Criando e configurando seu projeto

### Criando o projeto com o Maven

Após instalar o archetype em seu repositório, crie seu projeto utilizando o maven. Exemplo:

``` bash
mvn archetype:generate                                     \
  -DarchetypeGroupId=br.com.miguelfontes                   \
  -DarchetypeArtifactId=java-tooling-template-archetype    \
  -DarchetypeVersion=1.7                                   \
  -DgroupId=br.com.miguelfontes                            \
  -DartifactId=meu-projeto                                 \
  -DgithubUser=Miguel-Fontes                               \
  -Dversion=1.0-SNAPSHOT                                   \
  -DinteractiveMode=false
```

O projeto irá considerar que o repositório da aplicação é `<githubUser>/<DartifactId>` (Ex: Miguel-Fontes/meu-projeto). Se o repositório possuir outro nome, ajuste o `pom.xml`, na seção `<scm>`. Feito isto, faça o commit inicial com o push para o Github.

![create-project](https://user-images.githubusercontent.com/15656072/42250002-c90e6820-7f04-11e8-8ec7-8926bbf78df4.gif)

### Configurando o Travis

Para que o Travis consiga fazer o deploy no Github releases, é necessário configurar uma variável de ambiente nomeada **GITHUB_OAUTH_TOKEN**, cujo valor será o TOKEN do Github com os acessos adequados para efetuar o deploy. Veja como criar um Token na [documentação oficial](https://docs.travis-ci.com/user/deployment/releases/), além de como efetuar esta configuração através do Travis CLI, se preferir.

### Configurando o Sonarqube

Para projetos open source, o [Sonar Cloud](https://sonarcloud.io/projects) é gratuito Cada build executado no Travis irá encaminhar os novos dados para à plataforma.

Para configurar este comportamento, é necessário acessar o [Sonar Cloud](https://sonarcloud.io/projects) e configurá-lo para sua conta do Github, obtendo um novo token e nome de organização, veja mais no [Get Started](https://about.sonarcloud.io/get-started/). Feito isto, é necessário configurar estes valores como variáveis de ambiente no Travis, por segurança. Acesse a configuração de variáveis de ambiente do travis e crie:

- **SONARQUBE_TOKEN**: com o valor do token;
- **SONARQUBE_ORGANIZATION**: com o nome da organização;

A configuração final no Travis, deverá ficar como:

![image](https://user-images.githubusercontent.com/15656072/41385975-3e349512-6f55-11e8-9d5d-37ca04e63601.png)

### YOUR_NAME nome no arquivo LICENSE

No arquivo LICENSE procure pela String YOUR_NAME e altere por seu nome completo. DONE!

## Utilizando as ferramentas

O ponto central das ferramentas é o Travis, que irá enviar dados sempre que um build for bem sucedido.

### Acessando o Travis

Irá interceptar toda mudança no repositório e efetuar o build.

<TBD informações sobre a configuração>

### Sonarqube

Acessível via [Sonar Cloud](https://sonarcloud.io/projects), receberá dados após o build bem sucedido do travis.

### Codecov

Basta acessar o [codecov](https://codecov.io/) e visualizar o seu repositório. O endereço é `https://codecov.io/gh/<usuario-github>/<nome-repositorio>`.
