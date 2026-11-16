# ADR-001: Use a Modular Monolith

- **Status:** Accepted
- **Date:** 2026-11-15

## Context

Secrets Rotation Tracker is initially being developed as a single application. It will support several capabilities, including secret management, rotation tracking, notifications, and external vault integrations.

The architecture needs to support future growth without introducing unnecessary operational complexity.

## Decision

Use a modular monolith architecture.

The application will run as a single Spring Boot deployment while organizing functionality into separate logical modules.

## Alternatives Considered

- **Microservices:** Separate services for individual capabilities.
- **Monolith without module boundaries:** One application without clear separation of responsibilities.

## Consequences

- Simpler deployment and development.
- Easier communication between application components.
- Clear module boundaries support future maintainability.
- Individual modules cannot be independently deployed or scaled.
- Extracting services later may require additional work.