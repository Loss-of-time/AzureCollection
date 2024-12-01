package edu.swjtu.azurecollection.pojo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Exhibition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exhibitionId;

    @ManyToOne
    @JoinColumn(name = "collectible_id", nullable = false)
    private DigitalCollectible collectible;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime displayStartDate;
    private LocalDateTime displayEndDate;

    // Getters and Setters

    public Long getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(Long exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public DigitalCollectible getCollectible() {
        return collectible;
    }

    public void setCollectible(DigitalCollectible collectible) {
        this.collectible = collectible;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDisplayStartDate() {
        return displayStartDate;
    }

    public void setDisplayStartDate(LocalDateTime displayStartDate) {
        this.displayStartDate = displayStartDate;
    }

    public LocalDateTime getDisplayEndDate() {
        return displayEndDate;
    }

    public void setDisplayEndDate(LocalDateTime displayEndDate) {
        this.displayEndDate = displayEndDate;
    }

    @Override
    public String toString() {
        return "Exhibition{" +
                "exhibitionId=" + exhibitionId +
                ", collectible=" + collectible +
                ", user=" + user +
                ", displayStartDate=" + displayStartDate +
                ", displayEndDate=" + displayEndDate +
                '}';
    }
}
