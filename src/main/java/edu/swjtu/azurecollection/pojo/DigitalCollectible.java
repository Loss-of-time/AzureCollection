package edu.swjtu.azurecollection.pojo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DigitalCollectible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collectibleId;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    private String name;
    private String description;

    @Lob
    private String metadata;

    private LocalDateTime creationDate;

    @Column(nullable = false)
    private String status; // e.g., active, sold, gifted, destroyed

    @Column(nullable = false)
    private String verificationStatus;

    // Getters and Setters

    public Long getCollectibleId() {
        return collectibleId;
    }

    public void setCollectibleId(Long collectibleId) {
        this.collectibleId = collectibleId;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    @Override
    public String toString() {
        return "DigitalCollectible{" +
                "collectibleId=" + collectibleId +
                ", creator=" + creator +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", metadata='" + metadata + '\'' +
                ", creationDate=" + creationDate +
                ", status='" + status + '\'' +
                ", verificationStatus='" + verificationStatus + '\'' +
                '}';
    }
}

