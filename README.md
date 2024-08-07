## Backend-MagaDEV-Kotlin - LojaVirtual Application 🚀 🔄 🌐
Codificação de Backend MagaDev para E-commerce completo em Kotlin com banco de dados Postgres, RabbitMQ e Swagger para documentar ApiREST da
LojaVirtual é uma plataforma de e-commerce desenvolvida com Kotlin, Spring Boot, Hibernate, PostgreSQL 
e RabbitMQ. Esta aplicação foi projetada para gerenciar listagens de produtos, usuários, marcas, estados, categorias, clientes, pedidos e 
pagamentos, com uma arquitetura modular e escalável.

### Tecnologias Utilizadas 🛠️
![Java](https://img.shields.io/badge/-Java-F89820?style=for-the-badge&logo=java&logoColor=white)
![Kotlin](https://img.shields.io/badge/-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Spring Boot](https://img.shields.io/badge/-Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/-PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/-RabbitMQ-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![Maven](https://img.shields.io/badge/-Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Hibernate](https://img.shields.io/badge/-Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![Docker](https://img.shields.io/badge/-Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

### Arquitetura Limpa
A Arquitetura Limpa visa separar as preocupações no design de software, tornando o sistema mais fácil de gerenciar e modificar. Esta arquitetura divide a aplicação em camadas com responsabilidades distintas, melhorando a modularidade e facilitando o desenvolvimento e teste independentes.
O uso de Arquitetura Limpa nesse projeto Kotlin, que é frequentemente aplicada para manter a separação de preocupações e facilitar a manutenção e testabilidade do código. Essa arquitetura é conhecida por dividir o projeto em camadas claramente definidas, cada uma com responsabilidades específicas:

- Domain: Inclui entidades, repositórios e outras classes fundamentais para a lógica de negócio do domínio. É a camada central e não deve ter dependências com as outras camadas.

- Application: Contém a lógica de aplicação que orquestra o fluxo de dados para e do domínio, mediando entre a interface do usuário e a camada de domínio. Pode incluir classes de serviço, DTOs e controladores.

- Infrastructure: Contém implementações que conectam a aplicação ao mundo externo, como banco de dados, APIs externas e outras interfaces de comunicação como adaptadores e gateways.

Cada camada é isolada das outras, promovendo um alto grau de desacoplamento, o que torna o sistema mais modularizado e menos suscetível a mudanças em partes específicas afetando outras.


![](https://raw.githubusercontent.com/emersonamorim-dev/Backend-MagaDEV-Clean-Arch-Kotlin/main/Backend-MagaDEV-2024-08-07%20175116.png)

### Estrutura do Projeto
A aplicação é organizada da seguinte forma:

- application: Contém a lógica de aplicação, incluindo os controladores, objetos de transferência de dados (DTOs) e configurações.

controller: Controladores REST que gerenciam as requisições HTTP.
dto: Objetos de Transferência de Dados usados para encapsular os dados entre as camadas.
config: Configurações da aplicação, como configuração de segurança, CORS, etc.

- domain: Inclui as entidades do domínio, repositórios, serviços e especificações.

entity: Entidades JPA que mapeiam as tabelas do banco de dados.
repository: Interfaces de repositório que se comunicam com o banco de dados.
service: Lógica de negócios e serviços da aplicação.
specification: Especificações para consultas dinâmicas e filtragens no banco de dados.

- infrastructure: Contém adaptações de infraestrutura, gateways de comunicação e listeners.

adpter: Adapters que fazem a ponte entre as camadas da aplicação.
gateway: Componentes que gerenciam integrações externas.
listener: Listeners para eventos de sistema e comunicação assíncrona.

- rabbitmq: Implementações específicas para a integração com o RabbitMQ.

Logger: Logger personalizado para monitoramento de mensagens.
Receiver: Componente responsável por receber e processar mensagens do RabbitMQ.

- utils: Funções utilitárias e classes auxiliares que suportam a aplicação.

LojaVirtualApplication.kt: Ponto de entrada principal da aplicação.

### Execução Local 🚀

Subir o RabbitMQ via conteinner do Docker via WSL

```
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
```

Compilando aplicação via Terminal:
```
mvn spring-boot:run

```
Acessando Backend via o Local:

``` 
http://localhost:8088/swagger-ui/index.html
```


### Conclusão

Em resumo, a aplicação do Backend MagaDev para e-commerce desenvolvida em Kotlin utilizando PostgreSQL, RabbitMQ e Swagger representa um exemplo exemplar de como práticas modernas de desenvolvimento e arquitetura de software podem ser aplicadas em um ambiente robusto e escalável. Este projeto demonstra como integrar eficazmente serviços de mensageria com RabbitMQ para garantir uma comunicação assíncrona e eficiente entre os diferentes componentes da aplicação, ao mesmo tempo em que utiliza PostgreSQL como um banco de dados relacional robusto, capaz de lidar com grandes volumes de dados de maneira confiável.

A implementação do Swagger fornece uma documentação clara e interativa da API, facilitando tanto o desenvolvimento quanto a manutenção futura, além de melhorar a comunicação com outras equipes e partes interessadas no projeto. Este projeto serve como um modelo valioso para desenvolvedores que buscam construir aplicações comerciais robustas e escaláveis, mostrando um caminho claro para a integração de tecnologias modernas com práticas de desenvolvimento ágeis e eficientes.

Este projeto não apenas atende às necessidades funcionais do negócio, mas também se destaca por sua extensibilidade, sustentação e facilidade de manutenção, características essenciais em qualquer sistema de software moderno. Em última análise, este trabalho se apresenta como uma referência para o desenvolvimento de aplicações complexas em um ambiente empresarial, oferecendo uma base sólida para futuras expansões e adaptações conforme as demandas de mercado evoluem.

### Desenvolvido por:
Emerson Amorim [@emerson-amorim-dev](https://www.linkedin.com/in/emerson-amorim-dev/)

