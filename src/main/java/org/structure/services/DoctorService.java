package org.structure.services;

import org.structure.models.Doctor;
import org.structure.models.Speciality;

import java.util.List;

public interface DoctorService {
    void addDoctor(Doctor doctor);

    Doctor getDoctor(String login);

    List<Doctor> getAllDoctors();

    List<Doctor> getAllDoctorsBySpeciality(Speciality speciality);

    void updateDoctor(String login, String parameter, String newValue);

    void deleteDoctorByLogin(String login);

}
