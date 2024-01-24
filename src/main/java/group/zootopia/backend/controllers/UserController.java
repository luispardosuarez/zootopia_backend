package group.zootopia.backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import group.zootopia.backend.interfaces.IGenericLimitedService;
import group.zootopia.backend.models.User;
import group.zootopia.backend.services.UserService;

@RestController
@RequestMapping(path = "${api-endpoint}/users")
public class UserController {

    IGenericLimitedService<User> service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<User> index() {

        List<User> users = service.getAll();
        return users;

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getOneById(@PathVariable("id") Long id) throws Exception {

        User user = service.getById(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(user);
    }

    @PostMapping(path = "")
    public ResponseEntity<User> create(@RequestBody User user) {

        User newUser = service.save(user);

        return ResponseEntity.status(201).body(newUser);
    }
}