package org.structure.services;

import org.structure.models.Patient;

import java.util.List;

public interface PatientService {
    void addPatient(Patient patient);

    Patient getPatient(Long id);

    List<Patient> getAllPatients();

    void updatePatient(Long id, String parameter, String newValue);

    void deletePatient(Long id);
}
