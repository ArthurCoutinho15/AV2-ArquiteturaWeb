package br.newtonpaiva.av2Security.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserRequest {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private String role;

    public UserRequest() {
    }

    public UserRequest(String id, String password, String username, String email, String role) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
