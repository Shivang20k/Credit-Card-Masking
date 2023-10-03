package com.creditcard.masking.Controller;

import com.creditcard.masking.Model.User;
import com.creditcard.masking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    private ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    private ResponseEntity<User> getUserByID(@PathVariable long id) {
        return new ResponseEntity<>(userRepository.findById(id).orElse(null), HttpStatus.OK);
    }

    @PostMapping("/user")
    private ResponseEntity<String> createUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>("Created successfully", HttpStatus.OK);
    }

    @PutMapping("/user/update/{id}")
    private ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setAccount(user.getAccount());
        userRepository.save(existingUser);
        return new ResponseEntity<>(existingUser, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    private ResponseEntity<String> deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

}
