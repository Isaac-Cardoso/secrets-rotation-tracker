package io.github.isaaccardoso.secretsrotationtracker.secret;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Rest Controller for registering and managing secret metadata.
 * Secret values are never stored or handled in this application.
 */

@RestController 
@RequestMapping ("/api/secrets")
public class SecretController {
    
    @PostMapping
    public String registerSecret(@RequestBody SecretRequest request) {
        return "Secret metadata received for: " + request.name;
    }

    public record SecretRequest(String name, String owner, String vault, String application, String rotationDueDate) {
    }
}
