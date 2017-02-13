# Blue Bank - Estamos contratando!


**Blue Bank** é uma instituição financeira fictícia cujas demandas de desenvolvimento de software têm aumentado muito nos últimos meses. Tentando manter-se sempre atualizada, busca novos desenvolvedores de software que sejam capazes de solucionar problemas de forma eficaz e elegante.

Como candidato, seu objetivo é desenvolver uma aplicação que seja capaz de demonstrar seus conhecimentos em desenvolvimento frontend e backend, ou seja, provar ser um legítimo desenvolvedor Fullstack.

Para isso será necessário criar uma aplicação que possibilite a transferência de fundos entre contas de dois correntistas.

## Informações importantes sobre o negócio
Um correntista é identificado pelo seu id, CPF, número da conta corrente e código da agência.

As transferências devem ter controle transacional para evitar débitos e créditos inválidos.

A existência da conta de destino deve ser validada, assim como a existência de fundos suficientes para o valor a ser transferido.

## Requisitos técnicos
- Interface web.
- Backend Java EE ou NodeJs.
- Utilizar OOP.
- Banco de dados relacional com ORM (Lembre-se que a legislação obriga os bancos a manter dados históricos por anos).
- Instruções para deploy e execução.
- Pequeno memorando com justificativa de decisões técnicas.

## Como destacar-se?
- Aplicar SOLID.
- Escrever testes unitários com boa cobertura.
- Arquitetar com SPA + API.
- Fazer o deploy da aplicação no seu ambiente de nuvem preferido ([IBM Bluemix](https://console.ng.bluemix.net/), AWS, Openshift, Heroku).


## Frameworks são bem vindos!
Angular, jQuery, Bootstrap, Material, ModuleJs, Sequelize, Spring, Hibernate.

## Como enviar o código para anáise?
O desenvolvedor deve criar um projeto no seu Git repo preferido (GitHub, GitBucket, etc). Lembre-se que ele será analisado por desenvolvedores, então não economize nos comentários de commit.


## Detalhes para rodar o projeto
**Softwares Requeridos Instalados**

- JDK version >= 1.8

- Maven

- Node/NPM

- bower

**Instalando dependencias web**

Instalar o (https://nodejs.org/en/)[NodeJS]

Instalar Bower e o gulp como dependências globais  
- `npm install -g bower gulp`

Dentro da raiz do projeto executar para instalar as dependências de front  
- `npm install`

Obs. Caso o comando acima não instale os plugins do bower, dentro da raiz do projeto é necessário executar  
- `bower install`




**Instalando dependencias java**

-mvn compile

**Executando o projeto via linha de comando**

-mvn spring-boot:run  - (http://localhost:8080/)

