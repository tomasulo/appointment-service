package com.avimedical.appointments.scheduling.domain.ports;

import java.util.Optional;

import com.avimedical.appointments.scheduling.domain.model.Appointment;

public interface AppointmentRepository {
    Appointment create(Appointment appt);

    Optional<Appointment> findAppointment(String id);
}
