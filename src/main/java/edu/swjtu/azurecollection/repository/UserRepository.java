package edu.swjtu.azurecollection.repository;

import edu.swjtu.azurecollection.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    User findUserByUserId(Long userId);
    Optional<User> findByEmail(String email);
}