package edu.swjtu.azurecollection.repository;

import edu.swjtu.azurecollection.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    User findUserByUserId(Long userId);
    Long findUserIdByEmail(String email);
}