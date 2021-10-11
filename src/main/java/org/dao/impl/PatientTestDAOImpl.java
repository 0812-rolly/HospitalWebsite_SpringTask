package org.dao.impl;

import org.dao.PatientDAO;
import org.models.Patient;

import java.util.List;

public class PatientTestDAOImpl implements PatientDAO {
    private List<Patient> patients;

    public PatientTestDAOImpl(List<Patient> patients){
        this.patients = patients;
    }
    @Override
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    @Override
    public Patient getPatient(Long id) {
        for(Patient patient : patients){
            if(patient.getId().equals(id))
                return patient;
        }
        return new Patient();
    }

    @Override
    public List<Patient> getAllPatients() {
        return patients;
    }

    @Override
    public void updatePatient(Patient patient) {

    }

    @Override
    public void deletePatient(Long id) {
        patients.removeIf(patient -> patient.getId().equals(id));
    }
}
