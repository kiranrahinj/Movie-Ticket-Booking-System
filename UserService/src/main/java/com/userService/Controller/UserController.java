package com.userService.Controller;

import com.userService.UserService.ServiceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.userService.Model.User;
import java.util.*;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        return ResponseEntity.ok(userServiceImp.getUser(id));
    }
    @GetMapping
    public ResponseEntity<List<User>>getALl(){
        return ResponseEntity.ok(userServiceImp.getAll());
    }

    @PostMapping
    public ResponseEntity<User> createUsers(@RequestBody User user){
        return new ResponseEntity<>(userServiceImp.createUser(user),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
        return ResponseEntity.ok(userServiceImp.deleteUser(id));
    }
}
