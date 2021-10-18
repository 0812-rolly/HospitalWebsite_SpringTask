package org.structure.services.impl;

import org.structure.dao.PatientDAO;
import org.structure.models.Patient;
import org.structure.services.PatientService;

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
    public void updatePatient(Long id, String parameter, String newValue) {
        Patient patient = getPatient(id);
        if (parameter.equals("name")){
            patient.setFullName(newValue);
        }
        else if (parameter.equals("number")){
            patient.setPhoneNumber(newValue);
        }
        else if (parameter.equals("email")){
            patient.setEmail(newValue);
        }
        else if (parameter.equals("login")){
            patient.setLogin(newValue);
        }
        else if (parameter.equals("password")){
            patient.setPassword(newValue);
        }

        patientDAO.updatePatient(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientDAO.deletePatient(id);
    }
}
