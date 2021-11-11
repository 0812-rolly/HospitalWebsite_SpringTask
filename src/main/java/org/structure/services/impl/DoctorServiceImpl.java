package org.structure.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.structure.repository.DoctorRepository;
import org.structure.models.Doctor;
import org.structure.models.Speciality;
import org.structure.services.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctor(Long id) {
        return doctorRepository.getById(id);
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
    public void updateDoctor(Doctor doctor, String parameter, String newValue) {

    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
