package com.pharmacy.service;

import com.pharmacy.entity.Inventory;
import com.pharmacy.entity.Medicine;
import com.pharmacy.entity.Prescription;
import com.pharmacy.repository.InventoryRepository;
import com.pharmacy.repository.MedicineRepository;
import com.pharmacy.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final MedicineRepository medicineRepository;
    private final InventoryRepository inventoryRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository,
                                MedicineRepository medicineRepository,
                                InventoryRepository inventoryRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.medicineRepository = medicineRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public Prescription addPrescription(Prescription prescription) {

        Medicine medicine = medicineRepository.findByMedicineName(
                prescription.getMedicineName());

        if (medicine == null) {
            prescription.setValid(false);
            return prescriptionRepository.save(prescription);
        }

        Inventory inventory = inventoryRepository.findByMedicineId(
                medicine.getMedicineId());

        if (inventory == null) {
            prescription.setValid(false);
            return prescriptionRepository.save(prescription);
        }

        if (prescription.getQuantity() <= inventory.getStockQuantity()) {
            prescription.setValid(true);
        } else {
            prescription.setValid(false);
        }

        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }
}