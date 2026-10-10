package com.pharmacy.service;

import com.pharmacy.entity.Inventory;
import com.pharmacy.entity.Medicine;
import com.pharmacy.entity.Prescription;
import com.pharmacy.repository.InventoryRepository;
import com.pharmacy.repository.MedicineRepository;
import com.pharmacy.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        // Check whether quantity is valid
        if (prescription.getQuantity() == null ||
                prescription.getQuantity() <= 0) {

            prescription.setValid(false);
            return prescriptionRepository.save(prescription);
        }

        // Find the medicine
        Medicine medicine = medicineRepository.findByMedicineName(
                prescription.getMedicineName());

        // Medicine does not exist
        if (medicine == null) {
            prescription.setValid(false);
            return prescriptionRepository.save(prescription);
        }

        // Check medicine expiry date
        LocalDate expiryDate = LocalDate.parse(medicine.getExpiryDate());

        if (expiryDate.isBefore(LocalDate.now())) {
            prescription.setValid(false);
            return prescriptionRepository.save(prescription);
        }

        // Find inventory for the medicine
        Inventory inventory = inventoryRepository.findByMedicineId(
                medicine.getMedicineId());

        // Inventory does not exist
        if (inventory == null) {
            prescription.setValid(false);
            return prescriptionRepository.save(prescription);
        }

        // Check whether enough stock is available
        if (prescription.getQuantity() <= inventory.getStockQuantity()) {

            prescription.setValid(true);

            int remainingStock = inventory.getStockQuantity()
                    - prescription.getQuantity();

            inventory.setStockQuantity(remainingStock);

            inventoryRepository.save(inventory);

        } else {
            prescription.setValid(false);
        }

        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public List<Prescription> getPrescriptionsByPatient(String patientName) {
    return prescriptionRepository.findByPatientName(patientName);
}

    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id).orElse(null);
    }

    public Prescription updatePrescription(Long id,
                                           Prescription prescription) {

        Prescription existingPrescription =
                prescriptionRepository.findById(id).orElse(null);

        if (existingPrescription != null) {

            existingPrescription.setPatientName(
                    prescription.getPatientName());

            existingPrescription.setDoctorName(
                    prescription.getDoctorName());

            existingPrescription.setMedicineName(
                    prescription.getMedicineName());

            existingPrescription.setQuantity(
                    prescription.getQuantity());

            return prescriptionRepository.save(existingPrescription);
        }

        return null;
    }

    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }
}