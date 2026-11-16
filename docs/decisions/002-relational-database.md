# ADR-002: Use a Relational Database

- **Status:** Accepted
- **Date:** 2026-11-15

## Context

The application needs to persist secret metadata, ownership information, application associations, and rotation history.

These records will have relationships and require reliable querying.

## Decision

Use a relational database with Spring Data JPA for persistence.

H2 will be used during initial development. PostgreSQL is the intended production database.

## Alternatives Considered

- **NoSQL database:** Flexible document-oriented storage.
- **Direct JDBC:** Explicit SQL queries and database interaction.
- **Relational database with JPA:** Object-relational mapping and repository abstractions.

## Consequences

- Supports relationships between application entities.
- Provides transactional data operations.
- Spring Data JPA reduces repetitive persistence code.
- Requires careful entity and relationship modeling.
- Database schema changes must be managed as the application evolves.