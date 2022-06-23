package com.avimedical.appointments.scheduling.domain.ports;

import com.avimedical.appointments.scheduling.domain.model.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository repository;

    public Appointment save(Appointment appt) {
        return repository.save(appt);
    }
}
