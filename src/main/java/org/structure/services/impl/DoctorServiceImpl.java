package org.structure.services.impl;

import org.structure.dao.DoctorDAO;
import org.structure.models.Doctor;
import org.structure.models.Speciality;
import org.structure.services.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    private DoctorDAO doctorDAO;

    public DoctorServiceImpl(DoctorDAO doctorDao) {
        this.doctorDAO = doctorDao;
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
    }

    @Override
    public Doctor getDoctor(Long id) {
        return doctorDAO.getDoctor(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    @Override
    public List<Doctor> getAllDoctorsBySpeciality(Speciality speciality) {
        return doctorDAO.getAllDoctorsBySpeciality(speciality);
    }

    @Override
    public void updateDoctor(Doctor doctor, String parameter, String newValue) {

    }

    @Override
    public void deleteDoctor(Long id) {
        doctorDAO.deleteDoctor(id);
    }
}
