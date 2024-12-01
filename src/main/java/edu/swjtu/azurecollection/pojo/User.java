package edu.swjtu.azurecollection.pojo;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(UserEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    @Column(unique = true)
    private String blockchainId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<DigitalCollectible> collectibles;

    // Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBlockchainId() {
        return blockchainId;
    }

    public void setBlockchainId(String blockchainId) {
        this.blockchainId = blockchainId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<DigitalCollectible> getCollectibles() {
        return collectibles;
    }

    public void setCollectibles(List<DigitalCollectible> collectibles) {
        this.collectibles = collectibles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", blockchainId='" + blockchainId + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", collectibles=" + collectibles +
                '}';
    }
}
