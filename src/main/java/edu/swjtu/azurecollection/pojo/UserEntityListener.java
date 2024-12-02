package edu.swjtu.azurecollection.pojo;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;

public class UserEntityListener {

    @PrePersist
    public void prePersist(User user) {
        LocalDateTime now = LocalDateTime.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        user.setBlockchainId(User.generateBlockchainId(user.getUsername()));
        user.setPasswordHash(User.hashPassword(user.getPasswordHash()));
    }

    @PreUpdate
    public void preUpdate(User user) {
        user.setUpdatedAt(LocalDateTime.now());
    }


}