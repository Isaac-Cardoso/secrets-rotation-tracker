package io.github.isaaccardoso.secretsrotationtracker.secret;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * 
 * Rest Controller for registering and managing secret metadata.
 * Secret values are never stored or handled in this application.
 */

@RestController 
@RequestMapping ("/api/secrets")
public class SecretController {
    
    private final SecretService secretService;

    public SecretController(SecretService secretService) {
        this.secretService = secretService;
    }

    @PostMapping
    public Secret registerSecret(@RequestBody Secret secret) {
        return secretService.registerSecret(secret);
    }

    @GetMapping 
    public List<Secret> getAllSecrets() {
        return secretService.getAllSecrets();
    }
}
