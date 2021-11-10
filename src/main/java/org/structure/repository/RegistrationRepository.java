package org.structure.repository;

import org.springframework.data.repository.CrudRepository;
import org.structure.models.Registration;
import org.structure.models.Registration;

import java.util.List;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {
    Registration getById(long id);

    List<Registration> findAll();

    Registration save(Registration Registration);

    void deleteById(long id);
}
