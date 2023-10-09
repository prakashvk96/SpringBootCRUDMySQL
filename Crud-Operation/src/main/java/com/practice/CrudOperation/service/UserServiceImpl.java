package com.practice.CrudOperation.service;

import com.practice.CrudOperation.exceptions.UserNotFoundException;
import com.practice.CrudOperation.model.User;
import com.practice.CrudOperation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.net.UnknownServiceException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        return user.get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getUserId()).get();
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setDob(user.getDob());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUserById(Long id, Map<Object, Object> fields) throws UserNotFoundException {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()){
            fields.forEach((key,value)->{
                Field field = ReflectionUtils.findField(User.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,existingUser.get(),value);
            });
            User updatedUser = userRepository.save(existingUser.get());
            return updatedUser;
        }
        throw new UserNotFoundException("user not found");
    }
}
