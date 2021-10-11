package org.services;

import org.models.Patient;

import java.util.List;

public interface PatientService {
    void addPatient(Patient patient);

    Patient getPatient(Long id);

    List<Patient> getAllPatients();

    void updatePatient(Patient patient, String parameter, String newValue);

    void deletePatient(Long id);
}
