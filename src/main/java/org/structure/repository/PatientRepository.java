package org.structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.structure.models.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findPatientByLoginLogin(String login);

    Patient getById(long id);

    List<Patient> findAll();

    Patient save(Patient Patient);

    void deleteById(long id);

    void deletePatientByLogin(String login);
}
