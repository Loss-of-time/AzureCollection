package edu.swjtu.azurecollection.pojo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(DigitalCollectibleListener.class)
public class DigitalCollectible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collectibleId;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonIdentityInfo(generator = com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator.class, property = "userId")
    @JsonIdentityReference(alwaysAsId = true)
    private User owner;

    private String name;
    private String description;

    @Column(nullable = false)
    private Double price;

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User creator) {
        this.owner = creator;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
                ", creator=" + owner +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", metadata='" + metadata + '\'' +
                ", creationDate=" + creationDate +
                ", status='" + status + '\'' +
                ", verificationStatus='" + verificationStatus + '\'' +
                '}';
    }
}

