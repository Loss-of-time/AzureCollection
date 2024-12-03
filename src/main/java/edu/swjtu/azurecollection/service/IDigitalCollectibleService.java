package edu.swjtu.azurecollection.service;

import edu.swjtu.azurecollection.pojo.DigitalCollectible;

import java.util.List;
import java.util.Optional;

public interface IDigitalCollectibleService {
    DigitalCollectible createCollectible(DigitalCollectible collectible);
    DigitalCollectible updateCollectible(Long collectibleId, DigitalCollectible collectible);
    void deleteCollectible(Long collectibleId);
    Optional<DigitalCollectible> getCollectibleById(Long collectibleId);
    List<DigitalCollectible> getAllCollectibles();
}