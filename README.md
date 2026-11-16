# Secrets Rotation Tracker

A Spring Boot web application for tracking secret ownership, storage locations, and rotation schedules across different secret management platforms.

The application helps teams maintain visibility into credentials that need rotation without storing or exposing actual secret values.

## Problem

Applications increasingly rely on client credentials, API keys, and other secrets to communicate with external services. Keeping track of their ownership, storage locations, and rotation schedules can become difficult as environments grow.

Secrets Rotation Tracker aims to centralize this metadata and help teams stay ahead of upcoming and overdue rotations.

## Key Features

- Register and manage secret metadata.
- Track secret owners and associated applications.
- Record the secret management provider or vault.
- Track rotation due dates.
- Monitor upcoming and overdue rotations.
- Maintain rotation history and audit records. *(Planned)*

## Architecture

The application currently follows a layered architecture within a Spring Boot modular monolith.

- **API layer:** Handles incoming REST requests.
- **Service layer:** Contains application business logic.
- **Persistence layer:** Handles database operations through Spring Data JPA.
- **Database:** H2 for development; PostgreSQL is planned for production.

See [Architecture Documentation](docs/architecture.md) for more details.

## Technology Stack

- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- Spring Web MVC
- H2 Database
- Maven

## Getting Started

### Prerequisites

- Java 21 or later
- Git

### Run the application

Clone the repository:

```bash
git clone https://github.com/isaac-cardoso/secrets-rotation-tracker.git
cd secrets-rotation-tracker
```

Start the application:

```bash
./mvnw spring-boot:run
```

On Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

The application runs at:

`http://localhost:8080`

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/secrets` | Register a secret |
| GET | `/api/secrets` | Retrieve all secrets |

## Security Principles

- Actual secret values are never stored.
- The application tracks metadata only.
- Access control and authentication are planned.

## Roadmap

- [x] Initial Spring Boot application
- [x] REST API for registering and retrieving secrets
- [x] Database persistence with Spring Data JPA
- [ ] Complete CRUD operations
- [ ] Request validation and error handling
- [ ] PostgreSQL integration
- [ ] Authentication and authorization with Microsoft Entra ID
- [ ] Rotation history and audit logging
- [ ] Automated rotation reminders
- [ ] Integrations with secret management platforms

## Architecture Decisions

Important architectural decisions and their tradeoffs are documented in [`docs/decisions/`](docs/decisions/).