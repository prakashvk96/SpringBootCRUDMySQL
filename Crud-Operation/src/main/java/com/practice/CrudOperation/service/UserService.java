package com.practice.CrudOperation.service;

import com.practice.CrudOperation.exceptions.UserNotFoundException;
import com.practice.CrudOperation.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    User createUser(User user);
    User getUserById(Long userId) throws UserNotFoundException;
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUser(Long userId);
    User updateUserById(Long id, Map<Object, Object> fields) throws UserNotFoundException;
}
