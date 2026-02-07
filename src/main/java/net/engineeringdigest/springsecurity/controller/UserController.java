package net.engineeringdigest.springsecurity.controller;

import net.engineeringdigest.springsecurity.model.User;
import net.engineeringdigest.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        var u = userRepository.findByUsername(user.getUsername());
        if(Objects.isNull(u)){
            return "User not found";
        }
        return "User logged in successfully";
    }
}
