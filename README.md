## API Agenda
 * API REST em Java e MySQL que gerencia e disponibiliza uma agenda de contatos de pessoas.
  
### __Tecnologias Utilizadas__
 * Java
 * Spring Boot
 * Spring Data JPA com Hibernate
 * MySQL
 * Docker

### __Endpoints para uso disponíveis em:__ [Agenda API documentation](https://documenter.getpostman.com/view/13957290/TzRNEUu9)

### __Importar o projeto no Eclipse__
    
* Após baixar o projeto, abra o Eclipse e siga a seguinte ordem.
> File > Import > Maven > Existing Maven Projects > next
* Após isso, apenas selecionar o diretório do projeto e finalizar o import
### __Subir o banco de dados com docker-compose.yml__

* **1 -** navegue até a raiz do projeto<br>
Ex:
> C:\Workspace\agenda-api
* **2 -** executar o seguinte comando para subir o ambiente
>docker-compose up