package org.services.impl;

import org.dao.RegistrationDAO;
import org.models.Registration;
import org.services.RegistrationService;

import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {
    private RegistrationDAO registrationDAO;

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
