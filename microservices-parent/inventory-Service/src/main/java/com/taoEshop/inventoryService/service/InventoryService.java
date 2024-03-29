package com.taoEshop.inventoryService.service;

import com.taoEshop.inventoryService.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
        log.info("Checking inventory by Sku code");
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
