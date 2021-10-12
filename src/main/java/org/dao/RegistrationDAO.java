package org.dao;

import org.models.Registration;

import java.util.List;

public interface RegistrationDAO {
    Registration get(long id);

    List<Registration> getAll();

    void save(Registration registration);

    void update(Registration registration);

    void delete(long id);
}
