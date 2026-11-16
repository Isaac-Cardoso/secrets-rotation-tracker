# System Architecture

## 1. Overview

Secrets Rotation Tracker is a web application designed to centralize secret metadata and rotation schedules across multiple secret management platforms.

The application tracks ownership, associated applications, storage providers, and rotation dates without storing actual secret values.

### Architectural Goals

- Centralize visibility into secrets and their rotation schedules.
- Support multiple secret management providers.
- Keep actual secret values outside the application.
- Provide a maintainable and extensible architecture.
- Support future integrations and automated notifications.

## 2. Architecture Style

**Modular Monolith with Layered Architecture**

The application is initially structured as a single deployable Spring Boot application, organized into logical modules.

Within each module, responsibilities are separated into layers:

- Controller: Handles HTTP requests and responses.
- Service: Implements business logic.
- Repository: Handles data persistence.
- Entity: Represents persistent domain data.

This approach keeps the initial system simple while allowing individual capabilities to evolve independently.

## 3. High-Level Architecture

flowchart TD
    User[User / API Client]

    subgraph Application["Spring Boot Application"]
        Controller[REST Controllers]
        Service[Service Layer]
        Repository[Repository Layer]

        Controller --> Service
        Service --> Repository
    end

    Database[(H2 Database)]

    User --> Controller
    Repository --> Database

## 4. Application Components

| Component | Responsibility |
|---|---|
| REST API | Exposes application functionality |
| Secret Management | Manages secret metadata |
| Rotation Management | Tracks rotation schedules and completion |
| Notification Service | Sends rotation reminders |
| Identity and Access | Handles authentication and authorization |
| Persistence | Stores application data |
| Vault Integrations | Connects to external secret providers |

*Some components represent planned capabilities.*

## 5. Data Architecture

The application stores metadata associated with secrets.

Examples include:

- Secret name or identifier
- Owner
- Associated application
- Secret management provider
- Rotation due date
- Rotation status

**Security principle:** Actual secret values are never stored in the application database.

*Will add an entity relationship diagram when the data model develops.*

## 6. External Integrations

The application is intended to support multiple secret management platforms.

Potential integrations:

- Microsoft Azure Key Vault
- AWS Secrets Manager
- HashiCorp Vault
- KeePass

Future integrations should use a common abstraction so that provider-specific implementation details remain isolated from core application logic.

## 7. Security Architecture

Planned security capabilities:

- Microsoft Entra ID authentication using OpenID Connect.
- Role-based access control.
- Authorization at the API level.
- Secure management of integration credentials.
- Audit logging for important operations.

The application must never retrieve or expose secret values unnecessarily.

## 8. Deployment Architecture

Initial development environment:

- Spring Boot
- Embedded H2 database
- Local execution

Planned production environment:

- Spring Boot application
- PostgreSQL database
- Containerized deployment
- CI/CD through GitHub Actions

## 9. Architecture Decisions

Important architectural decisions are documented separately as Architecture Decision Records (ADRs).

See [`decisions/`](decisions/) for the decision history.

## 10. Future Considerations

- Automated rotation monitoring.
- Email and Microsoft Teams notifications.
- Integration with additional vault providers.
- Rotation history and audit reporting.
- Scalability and deployment considerations.
