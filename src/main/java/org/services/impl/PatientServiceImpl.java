package org.services.impl;

import org.dao.PatientDAO;
import org.models.Patient;
import org.services.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    private PatientDAO patientDAO;

    public PatientServiceImpl(PatientDAO patientDao) {
        this.patientDAO = patientDao;
    }

    @Override
    public void addPatient(Patient patient) {
        patientDAO.addPatient(patient);
    }

    @Override
    public Patient getPatient(Long id) {
        return patientDAO.getPatient(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    @Override
    public void updatePatient(Patient patient, String parameter, String newValue) {

    }

    @Override
    public void deletePatient(Long id) {
        patientDAO.deletePatient(id);
    }
}
