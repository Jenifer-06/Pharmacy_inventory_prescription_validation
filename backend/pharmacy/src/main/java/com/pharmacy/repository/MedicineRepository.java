package com.pharmacy.repository;

import com.pharmacy.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    Medicine findByMedicineName(String medicineName);

    List<Medicine> findByMedicineNameContainingIgnoreCase(String medicineName);

    List<Medicine> findByExpiryDateBefore(String expiryDate);

    List<Medicine> findByCategoryIgnoreCase(String category);
}