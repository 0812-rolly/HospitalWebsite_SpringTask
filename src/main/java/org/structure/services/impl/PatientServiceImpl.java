package org.structure.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.structure.repository.PatientRepository;
import org.structure.models.Patient;
import org.structure.services.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient getPatient(Long id) {
        return patientRepository.getById(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
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

        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
