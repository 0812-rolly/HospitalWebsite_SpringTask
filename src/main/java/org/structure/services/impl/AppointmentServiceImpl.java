package org.structure.services.impl;

import org.structure.dao.AppointmentDAO;
import org.structure.models.Appointment;
import org.structure.services.AppointmentService;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentDAO appointmentDao;

    @Override
    public Appointment getAppointmentById(long id) {
        return null;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return null;
    }

    @Override
    public void saveAppointment(Appointment appointment) {

    }

    @Override
    public void updateAppointment(Appointment appointment) {

    }

    @Override
    public void deleteAppointment(long id) {

    }
}
