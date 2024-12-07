package edu.swjtu.azurecollection.service;

import edu.swjtu.azurecollection.pojo.DigitalCollectible;
import edu.swjtu.azurecollection.pojo.User;
import edu.swjtu.azurecollection.pojo.dto.DigitalCollectibleDto;

import java.util.List;
import java.util.Optional;

public interface IDigitalCollectibleService {
    DigitalCollectible createCollectible(DigitalCollectibleDto collectible);
    DigitalCollectible updateCollectible(Long collectibleId, DigitalCollectibleDto collectible);
    void deleteCollectible(Long collectibleId);
    Optional<DigitalCollectible> getCollectibleById(Long collectibleId);
    List<DigitalCollectible> getAllCollectibles();
    User getOwner(Long id);

    DigitalCollectible updateStatus(Long id, String status);
}