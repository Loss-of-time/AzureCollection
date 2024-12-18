package edu.swjtu.azurecollection.controller;

import edu.swjtu.azurecollection.pojo.ResponseMessage;
import edu.swjtu.azurecollection.pojo.User;
import edu.swjtu.azurecollection.pojo.dto.UserLoginDto;
import edu.swjtu.azurecollection.service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseMessage<User> createUser(@RequestBody User user) {
        // TODO 接收密码而不是密码的哈希
        User createdUser = userService.createUser(user);
        return ResponseMessage.success(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseMessage<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseMessage.success(updatedUser);
        }
        return new ResponseMessage<>(HttpStatus.NOT_FOUND.value(), "User not found", null);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseMessage<>(HttpStatus.NO_CONTENT.value(), "User deleted", null);
    }

    @GetMapping("/{id}")
    public ResponseMessage<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseMessage::success)
                .orElseGet(() -> new ResponseMessage<>(HttpStatus.NOT_FOUND.value(), "User not found", null));
    }

    @GetMapping
    public ResponseMessage<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseMessage.success(users);
    }

    @PostMapping("/login")
    public ResponseMessage<String> login(@RequestBody UserLoginDto userLoginDto, HttpSession session) {
        User user = userService.authenticate(userLoginDto);
        if(user == null) {
            session.setAttribute("userId", user.getUserId());
            return new ResponseMessage<>(HttpStatus.UNAUTHORIZED.value(), "Login failed", null);

        }
        session.setAttribute("userId", user.getUserId());
        return ResponseMessage.success("Login successful");
    }

    @PostMapping("/logout")
    public ResponseMessage<String> logout(HttpSession session) {
        session.removeAttribute("userId");
        return ResponseMessage.success("Logout successful");
    }

    @PostMapping("/session")
    public ResponseMessage<Long> getSessionUser(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null)
            return new ResponseMessage<>(HttpStatus.UNAUTHORIZED.value(), "Not logged in", null);
        return ResponseMessage.success(userId);
    }
}