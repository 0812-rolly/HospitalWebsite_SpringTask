package org.structure.repository;

import org.springframework.data.repository.CrudRepository;
import org.structure.models.Patient;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    Patient getById(long id);

    List<Patient> findAll();

    Patient save(Patient Patient);

    void deleteById(long id);
}
