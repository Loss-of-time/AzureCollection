package edu.swjtu.azurecollection.service;

import edu.swjtu.azurecollection.pojo.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
    Optional<User> getUserById(Long userId);
    List<User> getAllUsers();
}
