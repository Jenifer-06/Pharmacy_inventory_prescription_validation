package com.pharmacy.repository;

import com.pharmacy.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findByStockQuantityLessThanEqual(Integer reorderLevel);

}