package io.github.isaaccardoso.secretsrotationtracker.secret;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretRepository extends JpaRepository<Secret, Long> {
    
}
