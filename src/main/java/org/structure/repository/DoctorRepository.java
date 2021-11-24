package org.structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.structure.models.Doctor;
import org.structure.models.Doctor;
import org.structure.models.Speciality;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findDoctorByLoginLogin(String login);

    Doctor getById(long id);

    List<Doctor> findAll();

    Doctor save(Doctor Doctor);

    void deleteById(long id);

    void deleteDoctorByLoginLogin(String login);

    List<Doctor> findAllBySpeciality(Speciality speciality);
}
