package io.github.isaaccardoso.secretsrotationtracker.secret;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "secrets")
public class Secret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String owner;
    private String vault;
    private String application;

    private LocalDate rotationDueDate;

    // JPA requires a no-argument constructor
    public Secret() {
    }

    public Secret(String name, String owner, String vault, String application, LocalDate rotationDueDate) {
        this.name = name;
        this.owner = owner;
        this.vault = vault;
        this.application = application;
        this.rotationDueDate = rotationDueDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getVault() {
        return vault;
    }

    public String getApplication() {
        return application;
    }

    public LocalDate getRotationDueDate() {
        return rotationDueDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setVault(String vault) {
        this.vault = vault;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public void setRotationDueDate(LocalDate rotationDueDate) {
        this.rotationDueDate = rotationDueDate;
    }
}