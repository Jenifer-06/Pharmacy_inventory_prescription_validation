package com.pharmacy.repository;

import com.pharmacy.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByMedicineId(Long medicineId);

    List<Inventory> findByStockQuantityLessThanEqual(Integer stockQuantity);

}