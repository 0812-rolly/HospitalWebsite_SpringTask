package org.dao;

import org.models.Doctor;
import org.models.Speciality;

import java.util.List;

public interface DoctorDAO {
    void addDoctor(Doctor doctor);

    Doctor getDoctor(Long id);

    List<Doctor> getAllDoctors();

    List<Doctor> getAllDoctorsBySpeciality(Speciality speciality);

    void updateDoctor(Doctor doctor);

    void deleteDoctor(Long id);
}
