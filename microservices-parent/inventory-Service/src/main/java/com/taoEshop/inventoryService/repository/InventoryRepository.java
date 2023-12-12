package com.taoEshop.inventoryService.repository;

import com.taoEshop.inventoryService.model.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    Optional<InventoryEntity> findBySkuCode(String skuCode);
}
