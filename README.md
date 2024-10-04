# Folha de Pagamento - Projeto Java

Este projeto faz parte da residência de TIC do Parque Tecnológico Serratec, realizado em grupo, e consiste em um sistema de folha de pagamento. A aplicação é desenvolvida em Java, com leitura de dados de funcionários a partir de um arquivo XML e geração de outro arquivo XML contendo o cálculo do salário líquido. O sistema também faz a conexão com um banco de dados PostgreSQL local utilizando JDBC.

## Funcionalidades

- Leitura de dados dos funcionários a partir de um arquivo XML.
- Cálculo do salário líquido com base nos dados fornecidos.
- Geração de um arquivo XML com os resultados.
- Conexão com banco de dados PostgreSQL via JDBC para armazenar e consultar dados dos funcionários.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para o desenvolvimento do sistema.
- **XML**: Para entrada e saída de dados.
- **JDBC (Java Database Connectivity)**: Para a conexão com o banco de dados.
- **PostgreSQL**: Banco de dados relacional utilizado no projeto, rodando em localhost.
- **IDE usada**: [Eclipse](https://www.eclipse.org)

## Configuração do Banco de Dados

1. Certifique-se de que o PostgreSQL está instalado e rodando no seu localhost.
2. Crie um banco de dados para o projeto:
   ```sql
   CREATE DATABASE folha_pagamento;
3. No código Java, configure a URL de conexão JDBC, usuário e senha do banco de dados no formato:
```java
  String url = "jdbc:postgresql://localhost:5432/folha_pagamento";
  String user = "seu_usuario";
  String password = "sua_senha";
```

## Contribuição
Este projeto foi desenvolvido em colaboração por alunos da residência de TIC do Parque Tecnológico Serratec em Petrópolis.

