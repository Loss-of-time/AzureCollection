package edu.swjtu.azurecollection.pojo;

import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

public class DigitalCollectibleListener {

    @PrePersist
    public void prePersist(DigitalCollectible collectible) {
        LocalDateTime now = LocalDateTime.now();
        collectible.setCreationDate(now);
    }
}