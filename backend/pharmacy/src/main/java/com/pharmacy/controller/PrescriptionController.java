package com.pharmacy.controller;

import com.pharmacy.entity.Prescription;
import com.pharmacy.service.PrescriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/prescriptions")
    public Prescription addPrescription(@RequestBody Prescription prescription) {
        return prescriptionService.addPrescription(prescription);
    }

    @GetMapping("/prescriptions")
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

}