package com.taoEshop.inventoryService.controller;

import com.taoEshop.inventoryService.dto.InventoryResponse;
import com.taoEshop.inventoryService.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
