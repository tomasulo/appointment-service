package com.avimedical.appointments.scheduling.domain.ports;

import com.avimedical.appointments.scheduling.domain.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
