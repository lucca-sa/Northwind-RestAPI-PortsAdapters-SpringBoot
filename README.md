# Projeto Spring Boot Hexagonal

Este projeto é uma aplicação Spring Boot que segue a arquitetura hexagonal. A arquitetura hexagonal, ou arquitetura de ports and adapters, é um padrão que visa separar claramente o núcleo da aplicação de seus componentes externos, como interfaces de usuário e bancos de dados. Isso facilita a manutenção e a evolução do sistema ao longo do tempo.

## Estrutura de Pastas

A estrutura de pastas do projeto é organizada da seguinte maneira:

```plaintext
adapter
│
├── exception
│   └── handler
│       └── GlobalExceptionHandler.java
│
├── input
│   └── customers
│       ├── controller
│       │   ├── BuscaPorIdController.java
│       │   ├── DeletarController.java
│       │   ├── CriarController.java
│       │   ├── EditarController.java
│       │
│       ├── dto
│       │   ├── ClienteResponse.java
│       │   ├── CriarClienteRequest.java
│       │   ├── EditarClienteRequest.java
│       │   ├── ClienteIdRequest.java
│       │
│       ├── BuscaPorIdSwagger.java
│       ├── DeletarSwagger.java
│       ├── CriarSwagger.java
│       └── EditarSwagger.java
│
├── mapper
│   └── CustomerMapper.java
│
└── output
    ├── CustomerPersistence.java
    └── database
        ├── data
        │   ├── compositekey
        │   └── entity
        │       └── CustomerEntity.java
        └── repository
            └── CustomerRepository.java

domain
│
├── exception
│   └── DataConflictException.java
│
├── model
│   └── Customer.java
│
└── service
    └── customers
        ├── BuscarPorIdService.java
        ├── CriarService.java
        ├── DeletarPorIdService.java
        └── EditarService.java

port
│
└── customers
    ├── input
    │   ├── BuscaPorIdUseCase.java
    │   ├── CriarUseCase.java
    │   ├── DeletarPorIdUseCase.java
    │   └── EditarUseCase.java
    │
    └── output
        ├── BuscarPorIdPort.java
        ├── CriarPort.java
        ├── DeletarPorIdPort.java
        └── EditarPort.java
```

### Descrição das Pastas

- **adapter**: Contém os adaptadores que fazem a interface entre a aplicação e o mundo externo.
  - **exception**: Classe para tratamento global de exceções.
  - **input**: Adaptadores de entrada, como controladores e DTOs.
    - **customers**: DTOs específicos para operações com clientes e Controladores que chamam os UseCases.
  - **mapper**: Classes de mapeamento entre entidades e DTOs.
  - **output**: Adaptadores de saída, como repositórios e persistência de dados que implementam os Ports.
    - **database**: Estrutura de banco de dados, incluindo entidades e repositórios.

- **domain**: Contém o núcleo central da aplicação.
  - **exception**: Exceções específicas do domínio.
  - **model**: Modelos de domínio.
  - **service**: Serviços que implementam os UseCases e chamam os Ports.
    - **customers**: Serviços específicos para operações com clientes.

- **port**: Contém interfaces que definem contratos para a comunicação entre o domínio e os adaptadores.
  - **customers**: Portas específicas para operações com clientes.
    - **input**: Interfaces para casos de uso de entrada.
    - **output**: Interfaces para portas de saída.

## Como Executar o Projeto

### Versões utilizadas

- Java 17
- Maven 3.9.6

### Passos para Executar

1. Clone o repositório:

    (https://github.com/lucca-sa/Northwind-RestAPI-PortsAdapters-SpringBoot.git)
   


2. Navegue até o diretório do projeto:
    ```sh
    cd seu-repositorio
    ```


3. Certifique-se de que o banco de dados Northwind está configurado. Você pode criar e popular o banco de dados localmente usando o script deste repositório: [northwind_psql](https://github.com/pthom/northwind_psql)
    - Alternativamente, você pode usar Docker e Docker Compose conforme as instruções no repositório `northwind_psql`.


4. Crie as variáveis de ambiente necessárias. Exemplo:
    ```sh
    DB_SERVER_URL=jdbc:postgresql://localhost:5432/northwind
    DB_USER=seu_usuario
    DB_PASSWORD=sua_senha
    ```


5. Compile o projeto:
    ```sh
    mvn clean install
    ```


6. Execute a aplicação:
    ```sh
    mvn spring-boot:run
    ```


A aplicação estará disponível em `http://localhost:8080/swagger-ui/index.html#/`.
