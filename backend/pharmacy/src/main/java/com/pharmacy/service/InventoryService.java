package com.pharmacy.service;

import com.pharmacy.entity.Inventory;
import com.pharmacy.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory updateInventory(Long id, Inventory inventory) {
        Inventory existingInventory = inventoryRepository.findById(id).orElse(null);

        if (existingInventory != null) {
            existingInventory.setMedicineId(inventory.getMedicineId());
            existingInventory.setStockQuantity(inventory.getStockQuantity());
            existingInventory.setReorderLevel(inventory.getReorderLevel());

            return inventoryRepository.save(existingInventory);
        }

        return null;
    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    public List<Inventory> getLowStockInventory() {
        return inventoryRepository.findByStockQuantityLessThanEqual(15);
    }
}