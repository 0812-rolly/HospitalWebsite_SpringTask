package org.services;

import org.models.Doctor;
import org.models.Speciality;

import java.util.List;

public interface DoctorService {
    void addDoctor(Doctor doctor);

    Doctor getDoctor(Long id);

    List<Doctor> getAllDoctors();

    List<Doctor> getAllDoctorsBySpeciality(Speciality speciality);

    void updateDoctor(Doctor doctor, String parameter, String newValue);

    void deleteDoctor(Long id);
}
