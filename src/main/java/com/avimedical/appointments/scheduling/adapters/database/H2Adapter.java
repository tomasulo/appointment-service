package com.avimedical.appointments.scheduling.adapters.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import com.avimedical.appointments.scheduling.adapters.database.entities.AppointmentEntity;
import com.avimedical.appointments.scheduling.adapters.database.entities.ReasonEntity;
import com.avimedical.appointments.scheduling.domain.model.Appointment;
import com.avimedical.appointments.scheduling.domain.model.Channel;
import com.avimedical.appointments.scheduling.domain.model.Reason;
import com.avimedical.appointments.scheduling.domain.ports.AppointmentRepository;
import com.avimedical.appointments.scheduling.domain.ports.ReasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class H2Adapter implements AppointmentRepository, ReasonRepository {

    private final AppointmentCrudRepository appointmentRepository;
    private final ReasonCrudRepository reasonRepository;

    @Override
    public Appointment create(Appointment appt) {
        AppointmentEntity entity = toEntity(appt);

        AppointmentEntity save = appointmentRepository.save(entity);

        ReasonEntity reason = entity.getReason();

        return appt.toBuilder()
                .id(entity.getId().toString())
                .build();
    }

    @Override
    public Optional<Appointment> findAppointment(String id) {
        return appointmentRepository.findById(Long.valueOf(id)).map(this::toDomain);
    }

    private AppointmentEntity toEntity(Appointment appt) {
        return AppointmentEntity.builder()
                .notes(appt.getNotes())
                .startTime(appt.getStartTime())
                .practiceId(appt.getPracticeId())
                .videoCallLink(appt.getVideoCallLink())
                .symptoms(String.join(",", appt.getSymptoms()))
                .reason(ReasonEntity.builder().id(Long.valueOf(appt.getReasonId())).build())
                // TODO
                .staffId("")
                .patientId("")
                .build();
    }

    @Override
    public Reason create(Reason reason) {
        return toDomain(reasonRepository.save(toEntity(reason)));
    }

    private ReasonEntity toEntity(Reason reason) {
        return ReasonEntity.builder()
                .title(reason.getTitle())
                .description(reason.getDescription())
                .build();
    }

    @Override
    public List<Reason> getReasons() {
        List<ReasonEntity> entities = new ArrayList<>();
        reasonRepository.findAll().forEach(entities::add);
        return entities.stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Reason> find(String reasonId) {
        return reasonRepository.findById(Long.valueOf(reasonId)).map(this::toDomain);
    }

    private Appointment toDomain(AppointmentEntity entity) {
        return Appointment.builder()
                .id(String.valueOf(entity.getId()))
                .channel(Channel.valueOf(entity.getChannel()))
                .notes(entity.getNotes())
                .videoCallLink(entity.getVideoCallLink())
                .cancellationLink(entity.getCancellationLink())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .practiceId(entity.getPracticeId())
                .reason(toDomain(entity.getReason()))
                .build();
    }

    private Reason toDomain(ReasonEntity entity) {
        return Reason.builder()
                .id(entity.getId().toString())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .build();
    }

}
