package com.pharmacy.controller;

import com.pharmacy.entity.Inventory;
import com.pharmacy.service.InventoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/inventory")
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    @GetMapping("/inventory")
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @PutMapping("/inventory/{id}")
    public Inventory updateInventory(@PathVariable Long id,
                                     @RequestBody Inventory inventory) {
        return inventoryService.updateInventory(id, inventory);
    }

    @DeleteMapping("/inventory/{id}")
    public void deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
    }
    @GetMapping("/inventory/low-stock")
public List<Inventory> getLowStockInventory() {
    return inventoryService.getLowStockInventory();
}

}