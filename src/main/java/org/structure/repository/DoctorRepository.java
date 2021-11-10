package org.structure.repository;

import org.springframework.data.repository.CrudRepository;
import org.structure.models.Doctor;
import org.structure.models.Doctor;
import org.structure.models.Speciality;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    Doctor getById(long id);

    List<Doctor> findAll();

    Doctor save(Doctor Doctor);

    void deleteById(long id);

    List<Doctor> findAllBySpeciality(Speciality speciality);
}
