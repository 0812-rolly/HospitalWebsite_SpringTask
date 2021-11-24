package org.structure.services;

import org.structure.models.Patient;

import java.util.List;

public interface PatientService {
    Patient getPatientByLogin(String login);

    void addPatient(Patient patient);

    Patient getPatient(Long id);

    List<Patient> getAllPatients();

    void updatePatient(String login, String parameter, String newValue);

    void deletePatientByLogin(String login);
}
