[README.md](https://github.com/user-attachments/files/27779639/README.md)
# 🎬 Movie Catalog REST API

A RESTful backend service for managing a movie catalog — built with **Spring Boot 3**, **PostgreSQL**, and **Spring Security**. Supports role-based access control (USER / ADMIN), database migrations, and full CRUD operations for movies, directors, and genres.

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17 |
| Framework | Spring Boot 3.5 |
| Security | Spring Security (HTTP Basic, BCrypt, Role-based) |
| Database | PostgreSQL 15 |
| ORM | Spring Data JPA / Hibernate |
| Migrations | Flyway |
| Mapping | MapStruct |
| API Docs | SpringDoc OpenAPI (Swagger UI) |
| Build | Gradle |
| Containerization | Docker Compose |
| Testing | JUnit 5, Spring Boot Test |

---

## Features

- **CRUD** for Movies, Directors, Genres
- **Role-based access control** — `ROLE_USER` (read), `ROLE_ADMIN` (write)
- **Flyway** database migrations (versioned schema + seed data)
- **MapStruct** DTO mapping — clean separation between API and domain layers
- **Swagger UI** — interactive API documentation at `/swagger-ui.html`
- **Docker Compose** — one command to spin up main + test databases
- **Unit tests** for service and mapper layers

---

## Getting Started

### Prerequisites

- Java 17+
- Docker & Docker Compose

### Run

```bash
# 1. Start PostgreSQL
docker-compose up -d

# 2. Run the application
./gradlew bootRun
```

The API will be available at `http://localhost:8081`  
Swagger UI: `http://localhost:8081/swagger-ui.html`

---

## API Endpoints

### Auth
| Method | Endpoint | Access |
|--------|----------|--------|
| POST | `/auth/register` | Public |
| POST | `/auth` | Public |

### Movies
| Method | Endpoint | Access |
|--------|----------|--------|
| GET | `/movie` | USER, ADMIN |
| GET | `/movie/{id}` | USER, ADMIN |
| POST | `/movie` | ADMIN only |
| PUT | `/movie/{id}` | ADMIN only |
| DELETE | `/movie/{id}` | ADMIN only |

### Directors & Genres
Same pattern as Movies — GET endpoints open to authenticated users, write operations restricted to ADMIN.

---

## Database Schema

```
t_user ──< t_user_permissions >── t_permission
t_movie >── t_director
t_movie ──< t_movie_genres >── t_genre
```

Schema is managed via Flyway migrations in `src/main/resources/db/migration/`.

---

## Project Structure

```
src/
├── main/java/com/example/finall/
│   ├── controller/      # REST controllers (MovieApi, DirectorApi, GenreApi, UserApi)
│   ├── service/         # Service interfaces + implementations
│   ├── model/           # JPA entities (Movie, Director, Genre, User, Permission)
│   ├── dto/             # Data Transfer Objects
│   ├── mapper/          # MapStruct mappers
│   ├── repository/      # Spring Data JPA repositories
│   └── security/        # Spring Security configuration
└── main/resources/
    ├── application.properties
    └── db/migration/    # Flyway SQL migrations
```

---

## Running Tests

```bash
./gradlew test
```

Tests use a separate PostgreSQL instance (port `5433`) defined in `docker-compose.yaml`.

---

## Author

**Rahat Musagaliev**  
Computer Science Student · Almaty, Kazakhstan  
[GitHub](https://github.com/bl00dtearz) · [LinkedIn](https://www.linkedin.com/in/rahat-musagaliev-99304740a/)
