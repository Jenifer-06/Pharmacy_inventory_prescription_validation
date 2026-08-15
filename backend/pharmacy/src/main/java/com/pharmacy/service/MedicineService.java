package com.pharmacy.service;

import com.pharmacy.entity.Medicine;
import com.pharmacy.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

    public Medicine updateMedicine(Long id, Medicine medicine) {
        Medicine existingMedicine = medicineRepository.findById(id).orElse(null);

        if (existingMedicine != null) {
            existingMedicine.setBatchNumber(medicine.getBatchNumber());
            existingMedicine.setCategory(medicine.getCategory());
            existingMedicine.setExpiryDate(medicine.getExpiryDate());
            existingMedicine.setManufacturer(medicine.getManufacturer());
            existingMedicine.setMedicineName(medicine.getMedicineName());
            existingMedicine.setPrice(medicine.getPrice());
            existingMedicine.setQuantity(medicine.getQuantity());

            return medicineRepository.save(existingMedicine);
        }

        return null;
    }

    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

}