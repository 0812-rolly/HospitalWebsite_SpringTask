package org.structure.services;

import org.structure.models.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment getAppointmentById(long id);

    List<Appointment> getAllAppointments();

    void saveAppointment(Appointment appointment);

    void updateAppointment(Appointment appointment);

    void deleteAppointment(long id);
}
