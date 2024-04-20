# Projeto PCP

Este é o README do projeto PCP. Aqui você encontrará uma descrição breve do projeto, uma lista dos endpoints disponíveis e um passo a passo para a execução do projeto pela linha de comando.

## Arquitetura

Este projeto segue a arquitetura Controller, Service e Repository. Na camada Controller, as solicitações HTTP são recebidas e mapeadas para os serviços correspondentes. A camada Service contém a lógica de negócios do aplicativo, atuando como uma ponte entre a camada Controller e a camada Repository. A camada Repository, por sua vez, é responsável por interagir com o banco de dados, contendo os métodos para buscar, criar, atualizar e deletar registros.

A segurança do projeto é gerenciada pelo Spring Security e JWT (JSON Web Tokens). O Spring Security é um framework que fornece autenticação e autorização para aplicações Java, enquanto o JWT é um padrão de token de acesso que permite a troca segura de informações entre partes.

As respostas das solicitações são manipuladas usando classes DTO (Data Transfer Object). Estes são objetos simples que encapsulam os dados e os passam de uma camada do aplicativo para outra.

Por fim, o mapeamento objeto-relacional é gerenciado pelo JPA (Java Persistence API). O JPA permite mapear classes Java para tabelas de banco de dados e vice-versa, facilitando a manipulação de dados persistentes.

![Modelo de Classes](/doc/modelo.png)

## Versionamento

Este projeto é desenvolvido usando o modelo de ramificação GitFlow. No GitFlow, temos duas branches principais. A primeira é a branch `main`, que contém o código de produção. A segunda é a branch `development`, onde as funcionalidades são construídas.

Quando o código na branch `development` está estável e pronto para ser lançado, ele é mesclado de volta à branch `main` e marcado com uma versão de lançamento. Além disso, cada nova funcionalidade tem sua própria branch, chamada de `feature`. Quando a funcionalidade está completa, ela é mesclada de volta à branch `development`.

Finalmente, temos as branches `hotfix`, que são criadas a partir da `main` para corrigir bugs em produção. Uma vez que o bug é corrigido, a branch 'hotfix' é mesclada de volta à `main` e à `development`. Este fluxo garante que o código em produção seja sempre estável e que o trabalho em novas funcionalidades não afete o código em produção até que esteja completamente pronto. Abaixo um exemplo ilustrado como  o fluxo funciona, a nomenclatura dos branches estão ligeiramente diferente da nomenclatura de ramo adotada nesse projeto.

![Git Flow](/doc/gitflow.png)

## Banco de Dados

Este projeto utiliza o PostgreSQL como sistema de gerenciamento de banco de dados. Certifique-se de ter o PostgreSQL instalado e configurado corretamente em seu ambiente local para executar este projeto. No diretório db existe um arquivo *.sql contendo as DDL e os dados iniciais. A senha padrão do usuário admin é: `senhaSegura123`.

![PostgreSQL](/doc/pg.png)

## Execução do Projeto

Para executar o projeto pela linha de comando, siga os passos abaixo:

1. Clone o repositório para o seu ambiente local:

    ```bash
    git clone https://github.com/seu-usuario/projeto-pcp.git
    ```

2. Acesse o diretório do projeto:

    ```bash
    cd projeto-pcp
    ```

3. Execute o comando para iniciar a aplicação:

    ```bash
    ./gradlew bootRun
    ```

4. A aplicação estará disponível em `http://localhost:8080`.

## Endpoints

A aplicação possui os seguintes endpoints:

- /alunos [GET]
- /alunos [POST]
- /alunos/{id} [DELETE]
- /alunos/{id} [GET]
- /alunos/{id} [PUT]
- /cursos [GET]
- /cursos [POST]
- /cursos/{id} [DELETE]
- /cursos/{id} [GET]
- /cursos/{id} [PUT]
- /docentes [GET]
- /docentes [POST]
- /docentes/{id} [DELETE]
- /docentes/{id} [GET]
- /docentes/{id} [PUT]
- /matérias [GET]
- /matérias [POST]
- /materias/{id} [DELETE]
- /materias/{id} [GET]
- /materias/{id} [PUT]
- /notas [CET]
- /notas [POST]
- /notas/{id} [DELETE]
- /notas/{id} [CET]
- /notas/{id} [PUT]
- /turmas [CET]
- /turmas [POST]
- /turmas/{id} [DELETE]
- /turmas/{id} [CET]
- /turmas/{id} [PUT]
- /usuários [POST]
- /usuarios/login [POST]

Para mais detalhes consultar o arquivo do Postman no diretório doc.