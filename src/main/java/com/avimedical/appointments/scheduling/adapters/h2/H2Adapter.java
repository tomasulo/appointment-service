package com.avimedical.appointments.scheduling.adapters.h2;

import java.time.Instant;

import com.avimedical.appointments.scheduling.domain.model.Appointment;
import com.avimedical.appointments.scheduling.domain.ports.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class H2Adapter implements AppointmentRepository {

    private final AppointmentCrudRepository repository;

    @Override
    public Appointment save(Appointment appt) {
        AppointmentEntity entity = toEntity(appt);
        repository.save(entity);
        return appt.toBuilder()
                .id(entity.getId())
                .build();
    }

    private AppointmentEntity toEntity(Appointment appt) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setNotes(appt.getNotes());
        entity.setStartDateTime(appt.getStartDateTime());
        entity.setCreatedAt(Instant.now());
        entity.setVideoCallLink(appt.getVideoCallLink());
        return entity;
    }
}
