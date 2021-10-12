package org.services;

import org.models.Registration;

import java.util.List;

public interface RegistrationService {
    Registration getRegistrationById(long id);

    List<Registration> getAllRegistrations();

    void saveRegistration(Registration registration);

    void updateRegistration(Registration registration);

    void deleteRegistration(long id);
}
