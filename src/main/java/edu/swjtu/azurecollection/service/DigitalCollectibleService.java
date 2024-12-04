package edu.swjtu.azurecollection.service;

import edu.swjtu.azurecollection.pojo.DigitalCollectible;
import edu.swjtu.azurecollection.pojo.User;
import edu.swjtu.azurecollection.repository.DigitalCollectibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DigitalCollectibleService implements IDigitalCollectibleService {

    @Autowired
    private DigitalCollectibleRepository collectibleRepository;

    @Override
    public DigitalCollectible createCollectible(DigitalCollectible collectible) {
        return collectibleRepository.save(collectible);
    }

    @Override
    public DigitalCollectible updateCollectible(Long collectibleId, DigitalCollectible collectible) {
        Optional<DigitalCollectible> existingCollectible = collectibleRepository.findById(collectibleId);
        if (existingCollectible.isEmpty()) {
            return null;
        }
        DigitalCollectible updatedCollectible = existingCollectible.get();
        updatedCollectible.setName(collectible.getName());
        updatedCollectible.setDescription(collectible.getDescription());
        updatedCollectible.setMetadata(collectible.getMetadata());
        updatedCollectible.setStatus(collectible.getStatus());
        updatedCollectible.setVerificationStatus(collectible.getVerificationStatus());
        return collectibleRepository.save(updatedCollectible);
    }

    @Override
    public void deleteCollectible(Long collectibleId) {
        collectibleRepository.deleteById(collectibleId);
    }

    @Override
    public Optional<DigitalCollectible> getCollectibleById(Long collectibleId) {
        return collectibleRepository.findById(collectibleId);
    }

    @Override
    public List<DigitalCollectible> getAllCollectibles() {
        return collectibleRepository.findAll();
    }

    @Override
    public User getOwner(Long id) {
        return collectibleRepository.findById(id).get().getOwner();
    }
}