package org.structure.dao.impl;

import org.structure.dao.DoctorDAO;
import org.structure.models.Doctor;
import org.structure.models.Speciality;

import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {
    private List<Doctor> doctors;
    private List<Doctor> specialists;

    public DoctorDAOImpl(List<Doctor> doctors){
        this.doctors = doctors;
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    @Override
    public Doctor getDoctor(Long id) {
        for(Doctor doctor : doctors){
            if(doctor.getId().equals(id))
                return doctor;
        }
        return new Doctor();
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    @Override
    public List<Doctor> getAllDoctorsBySpeciality(Speciality speciality) {
        return null;
    }

    @Override
    public void updateDoctor(Doctor doctor) {

    }

    @Override
    public void deleteDoctor(Long id) {
        doctors.removeIf(doctor -> doctor.getId().equals(id));
    }
}
