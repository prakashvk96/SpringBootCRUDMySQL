package com.practice.CrudOperation.service;

import com.practice.CrudOperation.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUser(Long userId);

}
