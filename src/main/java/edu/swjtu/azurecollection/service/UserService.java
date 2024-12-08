package edu.swjtu.azurecollection.service;

import edu.swjtu.azurecollection.pojo.User;
import edu.swjtu.azurecollection.pojo.dto.UserLoginDto;
import edu.swjtu.azurecollection.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User user) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isEmpty()) {
            return null;
        }
        User updatedUser = existingUser.get();
        updatedUser.setUsername(user.getUsername());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPhone(user.getPhone());
        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User isLoginValid(UserLoginDto userLoginDto) {
        User user = userRepository.findUserByEmail(userLoginDto.getEmail());
        if (user != null && user.getPasswordHash().equals(userLoginDto.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public User authenticate(UserLoginDto userLoginDto) {
        return userRepository.findByEmail(userLoginDto.getEmail())
                .filter(u -> u.getPasswordHash().equals(userLoginDto.getPassword()))
                .orElse(null);

    }
}
