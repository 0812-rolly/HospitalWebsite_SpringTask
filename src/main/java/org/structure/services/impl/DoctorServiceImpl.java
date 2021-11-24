package org.structure.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.structure.repository.DoctorRepository;
import org.structure.models.Doctor;
import org.structure.models.Speciality;
import org.structure.services.DoctorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addDoctor(Doctor doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctorRepository.save(doctor);
    }

    @Override
    @SneakyThrows
    public Doctor getDoctor(String login) {
        return doctorRepository.findDoctorByLoginLogin(login).orElseThrow(Exception::new);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> getAllDoctorsBySpeciality(Speciality speciality) {
        return doctorRepository.findAllBySpeciality(speciality);
    }

    @Override
    @SneakyThrows
    public void updateDoctor(String login, String parameter, String newValue) {
        Doctor doctor = doctorRepository.findDoctorByLoginLogin(login).orElseThrow(Exception::new);

        if (parameter.equals("name")) {
            doctor.setFullName(newValue);
        } else if (parameter.equals("number")) {
            doctor.setPhoneNumber(newValue);
        } else if (parameter.equals("email")) {
            doctor.setEmail(newValue);
        } else if (parameter.equals("password")) {
            doctor.setPassword(passwordEncoder.encode(newValue));
        }

        doctorRepository.save(doctor);
    }

    @Override
    @SneakyThrows
    public void deleteDoctorByLogin(String login) {
        Doctor doctor = doctorRepository.findDoctorByLoginLogin(login).orElseThrow(Exception::new);
        doctorRepository.deleteById(doctor.getId());
    }
}
