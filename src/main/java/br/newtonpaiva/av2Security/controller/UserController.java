package br.newtonpaiva.av2Security.controller;


import br.newtonpaiva.av2Security.model.ProductsRequest;
import br.newtonpaiva.av2Security.model.UserRequest;
import br.newtonpaiva.av2Security.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService authService;

    @PostMapping("/admin/register")
    public ResponseEntity<?> register(@RequestBody UserRequest user) {
        authService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/manager/register")
    public ResponseEntity<?> registerProduct(@RequestBody ProductsRequest products) {
        authService.saveProduct(products);
        return ResponseEntity.ok("Products registered successfully");
    }

    @PostMapping("/admin/login")
    public ResponseEntity<?> login(@RequestBody UserRequest loginRequest) {
        String token = authService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @GetMapping("/admin/user/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        UserRequest user = authService.findByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(404).body("User not found");
    }
    @Secured("ADMIN")
    @PutMapping("/admin/edit/{id}")
    public ResponseEntity<?> editUser(@PathVariable String id, @RequestBody UserRequest user) {
        boolean isUpdated = authService.updateUser(id, user);
        if (isUpdated) {
            return ResponseEntity.ok("User updated successfully");
        }
        return ResponseEntity.status(404).body("User not found");
    }

    @Secured("ADMIN")
    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        boolean isDeleted = authService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.ok("User deleted successfully");
        }
        return ResponseEntity.status(404).body("User not found");
    }

}
