package edu.swjtu.azurecollection.service;

import edu.swjtu.azurecollection.pojo.DigitalCollectible;
import edu.swjtu.azurecollection.pojo.User;
import edu.swjtu.azurecollection.pojo.dto.DigitalCollectibleDto;
import edu.swjtu.azurecollection.repository.DigitalCollectibleRepository;
import edu.swjtu.azurecollection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DigitalCollectibleService implements IDigitalCollectibleService {

    @Autowired
    private DigitalCollectibleRepository collectibleRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public DigitalCollectible createCollectible(DigitalCollectibleDto collectibleDto) {
        DigitalCollectible collectible = new DigitalCollectible();
        org.springframework.beans.BeanUtils.copyProperties(collectibleDto, collectible, "collectibleId", "owner");
        User owner = userRepository.findUserByUserId(collectibleDto.getOwner());
        collectible.setOwner(owner);
        return collectibleRepository.save(collectible);
    }

    @Override
    public DigitalCollectible updateCollectible(Long collectibleId, DigitalCollectibleDto collectibleDto) {
        Optional<DigitalCollectible> existingCollectible = collectibleRepository.findById(collectibleId);
        if (existingCollectible.isEmpty()) {
            return null;
        }
        DigitalCollectible updatedCollectible = existingCollectible.get();
        org.springframework.beans.BeanUtils.copyProperties(collectibleDto, updatedCollectible, "collectibleId", "owner");
        User owner = userRepository.findUserByUserId(collectibleDto.getOwner());
        updatedCollectible.setOwner(owner);
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