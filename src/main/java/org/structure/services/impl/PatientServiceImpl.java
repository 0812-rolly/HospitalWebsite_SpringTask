package org.structure.services.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.structure.repository.PatientRepository;
import org.structure.models.Patient;
import org.structure.services.PatientService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private final PasswordEncoder passwordEncoder;

    @SneakyThrows
    public Patient getPatientByLogin(String login) {
        return patientRepository.findPatientByLoginLogin(login).orElseThrow(Exception::new);
    }

    @Override
    public void addPatient(Patient patient) {
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
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
    @SneakyThrows
    public void updatePatient(String login, String parameter, String newValue) {
        Patient patient = patientRepository.findPatientByLoginLogin(login).orElseThrow(Exception::new);

        if (parameter.equals("name")){
            patient.setFullName(newValue);
        }
        else if (parameter.equals("number")){
            patient.setPhoneNumber(newValue);
        }
        else if (parameter.equals("email")){
            patient.setEmail(newValue);
        }
        else if (parameter.equals("password")){
            patient.setPassword(newValue);
        }

        patientRepository.save(patient);
    }

    @SneakyThrows
    @Override
    public void deletePatientByLogin(String login) {
        Patient patient = patientRepository.findPatientByLoginLogin(login).orElseThrow(Exception::new);
        patientRepository.deleteById(patient.getId());
    }
}
