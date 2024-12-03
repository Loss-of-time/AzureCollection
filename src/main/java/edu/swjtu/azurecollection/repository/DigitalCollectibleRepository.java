package edu.swjtu.azurecollection.repository;

import edu.swjtu.azurecollection.pojo.DigitalCollectible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DigitalCollectibleRepository extends JpaRepository<DigitalCollectible, Long> {
    // Custom query methods (if needed) can be added here
}