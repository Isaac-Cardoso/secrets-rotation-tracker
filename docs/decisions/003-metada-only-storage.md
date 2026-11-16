# ADR-003: Store Metadata Only

- **Status:** Accepted
- **Date:** 2026-11-15

## Context

Secrets Rotation Tracker needs to monitor credentials stored across different secret management platforms.

The application requires enough information to identify, track, and coordinate the rotation of credentials.

Storing actual secret values would introduce additional security risks and responsibilities.

## Decision

The application will store secret metadata only.

Actual secret values will remain in their respective secret management platforms.

The application may eventually integrate with external vault APIs to retrieve permitted metadata or coordinate rotation operations without persisting secret values.

## Alternatives Considered

- **Store actual secret values:** Centralize credential storage within the application.
- **Metadata-only approach:** Track credentials while leaving their values in existing vaults.

## Consequences

- Reduces the application's exposure to sensitive credential data.
- Supports multiple secret management platforms.
- Requires external vault integrations for future automation.
- The application cannot directly retrieve secret values for users.
- Vault access and integration credentials still require secure management.