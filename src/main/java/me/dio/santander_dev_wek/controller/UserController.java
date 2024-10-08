package me.dio.santander_dev_wek.controller;

import io.swagger.v3.oas.annotations.Operation;
import me.dio.santander_dev_wek.exceptions.EntityNotFoundException;
import me.dio.santander_dev_wek.model.User;
import me.dio.santander_dev_wek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar todos usuários.")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar usuário por id.")
    public User findById(@PathVariable Long id) throws EntityNotFoundException {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar novo usuário.")
    public User create(@RequestBody User user) throws EntityNotFoundException {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar usuário por id.")
    public User update(@PathVariable Long id, @RequestBody User user) throws EntityNotFoundException {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Deletar usuário por id.")
    public void delete(@PathVariable Long id) throws EntityNotFoundException {
        userService.delete(id);
    }
}
