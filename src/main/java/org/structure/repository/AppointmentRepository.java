package org.structure.repository;

import org.springframework.data.repository.CrudRepository;
import org.structure.models.Appointment;

import java.util.List;

public interface AppointmentRepository extends CrudRepository <Appointment, Long> {
    Appointment getById(long id);

    List<org.structure.models.Appointment> findAll();

   Appointment save(Appointment appointment);

    void deleteById(long id);
}