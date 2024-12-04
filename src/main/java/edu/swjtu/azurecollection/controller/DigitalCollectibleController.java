package edu.swjtu.azurecollection.controller;

import edu.swjtu.azurecollection.pojo.DigitalCollectible;
import edu.swjtu.azurecollection.pojo.ResponseMessage;
import edu.swjtu.azurecollection.pojo.User;
import edu.swjtu.azurecollection.service.IDigitalCollectibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/collectibles")
public class DigitalCollectibleController {

    @Autowired
    private IDigitalCollectibleService collectibleService;

    @PostMapping
    public ResponseMessage<DigitalCollectible> createCollectible(@RequestBody DigitalCollectible collectible) {
        DigitalCollectible createdCollectible = collectibleService.createCollectible(collectible);
        return ResponseMessage.success(createdCollectible);
    }

    @PutMapping("/{id}")
    public ResponseMessage<DigitalCollectible> updateCollectible(@PathVariable Long id, @RequestBody DigitalCollectible collectible) {
        DigitalCollectible updatedCollectible = collectibleService.updateCollectible(id, collectible);
        if (updatedCollectible != null) {
            return ResponseMessage.success(updatedCollectible);
        }
        return new ResponseMessage<>(HttpStatus.NOT_FOUND.value(), "Collectible not found", null);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<Void> deleteCollectible(@PathVariable Long id) {
        collectibleService.deleteCollectible(id);
        return new ResponseMessage<>(HttpStatus.NO_CONTENT.value(), "Collectible deleted", null);
    }

    @GetMapping("/{id}")
    public ResponseMessage<DigitalCollectible> getCollectibleById(@PathVariable Long id) {
        Optional<DigitalCollectible> collectible = collectibleService.getCollectibleById(id);
        return collectible.map(ResponseMessage::success)
                .orElseGet(() -> new ResponseMessage<>(HttpStatus.NOT_FOUND.value(), "Collectible not found", null));
    }

    @GetMapping
    public ResponseMessage<List<DigitalCollectible>> getAllCollectibles() {
        List<DigitalCollectible> collectibles = collectibleService.getAllCollectibles();
        return ResponseMessage.success(collectibles);
    }

    // 获取 collectible 的 owner
    @GetMapping("/{id}/owner")
    public ResponseMessage<User> getOwner(@PathVariable Long id) {
        User owner = collectibleService.getOwner(id);
        return ResponseMessage.success(owner);
    }
}