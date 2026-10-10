package com.pharmacy.controller;

import com.pharmacy.entity.Prescription;
import com.pharmacy.service.PrescriptionService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {
    "http://localhost:5173",
    "http://localhost:5174"
})
@RestController
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/prescriptions")
    public Prescription addPrescription(
            @RequestBody Prescription prescription) {

        return prescriptionService.addPrescription(prescription);
    }

    @GetMapping("/prescriptions")
    public List<Prescription> getAllPrescriptions() {

        return prescriptionService.getAllPrescriptions();
    }

    @GetMapping("/prescriptions/patient/{patientName}")
    public List<Prescription> getPrescriptionsByPatient(
            @PathVariable String patientName) {

        return prescriptionService.getPrescriptionsByPatient(patientName);
    }

    @GetMapping("/prescriptions/{id}")
    public Prescription getPrescriptionById(
            @PathVariable Long id) {

        return prescriptionService.getPrescriptionById(id);
    }

    @PutMapping("/prescriptions/{id}")
    public Prescription updatePrescription(
            @PathVariable Long id,
            @RequestBody Prescription prescription) {

        return prescriptionService.updatePrescription(id, prescription);
    }

    @DeleteMapping("/prescriptions/{id}")
    public void deletePrescription(@PathVariable Long id) {

        prescriptionService.deletePrescription(id);
    }
}