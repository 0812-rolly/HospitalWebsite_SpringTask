package org.structure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.structure.models.Registration;

import java.util.List;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Long> {
    Registration getById(long id);

    List<Registration> findAll();

    Registration save(Registration Registration);

    void deleteById(long id);
}
