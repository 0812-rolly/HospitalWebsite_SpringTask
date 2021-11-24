package org.structure.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.structure.repository.RegistrationRepository;
import org.structure.models.Registration;
import org.structure.services.RegistrationService;

import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationRepository registrationDAO;

    @Override
    public Registration getRegistrationById(long id) {
        return null;
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return null;
    }

    @Override
    public void saveRegistration(Registration registration) {

    }

    @Override
    public void updateRegistration(Registration registration) {

    }

    @Override
    public void deleteRegistration(long id) {

    }
}
