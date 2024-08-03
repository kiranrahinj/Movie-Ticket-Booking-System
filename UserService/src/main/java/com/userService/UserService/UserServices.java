package com.userService.UserService;
import java.util.*;
import com.userService.Model.User;

public interface UserServices {

    public User getUser(int id);

    public List<User> getAll();

    public User createUser(User user);

    public User deleteUser(int id);

}
