package com.userService.UserService.ServiceImp;

import com.userService.Model.User;
import com.userService.Repository.UserRepository;
import com.userService.UserService.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserServices {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User is Not present"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(int id) {
         User user=getUser(id);
         userRepository.deleteById(id);
         return user;
    }
}
