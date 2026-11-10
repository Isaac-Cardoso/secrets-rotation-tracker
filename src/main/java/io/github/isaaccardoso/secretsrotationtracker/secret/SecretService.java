package io.github.isaaccardoso.secretsrotationtracker.secret;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretService {
    private final SecretRepository secretRepository;

    public SecretService(SecretRepository secretRepository) {
        this.secretRepository = secretRepository;
    }

    public Secret registerSecret(Secret secret) {
        return secretRepository.save(secret);
    }
    
    public List<Secret> getAllSecrets() {
        return secretRepository.findAll();
    }
}
