package org.structure.dao;

import org.structure.models.Patient;

import java.util.List;

public interface PatientDAO {
    void addPatient(Patient patient);

    Patient getPatient(Long id);

    List<Patient> getAllPatients();

    void updatePatient(Patient patient);

    void deletePatient(Long id);
}
