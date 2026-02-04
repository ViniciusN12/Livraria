# 📚 Sistema de Livraria

A web system for managing books and authors built with Spring Boot.

## 🛠️ Technologies

- Java 25
- Spring Boot 4.0.2
- Spring Data JPA
- Thymeleaf
- MySQL
- Lombok

## ⚙️ Setup

1. Clone the repository
```bash
git clone https://github.com/seu-usuario/livraria.git
cd livraria
```

2. Create `application.properties` from example
```bash
cp src/main/resources/.example.aplication.properties src/main/resources/application.properties
```

3. Configure your MySQL credentials in `application.properties`
```properties
spring.datasource.username=YOUR_USER
spring.datasource.password=YOUR_PASSWORD
```

4. Run the application
```bash
./mvnw spring-boot:run
```

5. Access the application at `http://localhost:8080`

## 📍 Endpoints

| URL | Description |
|-----|-------------|
| `/` | Books listing |
| `/livro/cadastrar` | Create book |
| `/livro/atualizar/{id}` | Update book |
| `/livro/deletar/{id}` | Delete book |
| `/autores` | Authors listing |
| `/autores/cadastrar` | Create author |
| `/autores/atualizar/{id}` | Update author |
| `/autores/deletar/{id}` | Delete author |
| `/livros?genero=X&autor=Y` | Search books by genre or author |

## 📁 Project Structure

```
src/main/java/livraria/
├── controllers/        # Presentation layer (MVC Controllers)
├── services/           # Business layer
├── repository/         # Persistence layer
└── models/entity/      # JPA Entities

src/main/resources/
├── templates/          # Thymeleaf views
└── application.properties
```

## 🏗️ Architecture

This project uses **Layered Architecture** with **MVC pattern**:

- **Presentation Layer**: Controllers + Thymeleaf templates
- **Business Layer**: Services with business logic
- **Persistence Layer**: Spring Data JPA Repositories
- **Database**: MySQL

## 📝 Features

- [x] CRUD for Authors
- [x] CRUD for Books
- [x] OneToMany relationship (Author → Books)
- [x] Search books by genre or author name
- [x] Bean Validation
- [x] Cascade delete (delete author removes all books)

## 📄 License

MIT
