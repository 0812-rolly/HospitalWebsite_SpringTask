package org.structure.dao;

import org.structure.models.Doctor;
import org.structure.models.Speciality;

import java.util.List;

public interface DoctorDAO {
    void addDoctor(Doctor doctor);

    Doctor getDoctor(Long id);

    List<Doctor> getAllDoctors();

    List<Doctor> getAllDoctorsBySpeciality(Speciality speciality);

    void updateDoctor(Doctor doctor);

    void deleteDoctor(Long id);
}
