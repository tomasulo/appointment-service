package com.avimedical.appointments.scheduling.domain.ports;

import com.avimedical.appointments.scheduling.domain.model.Appointment;

public interface AppointmentRepository {
    Appointment save(Appointment appt);
}
