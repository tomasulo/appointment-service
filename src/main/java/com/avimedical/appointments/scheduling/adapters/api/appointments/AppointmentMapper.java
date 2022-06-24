package com.avimedical.appointments.scheduling.adapters.api.appointments;

import java.time.Instant;
import java.util.List;

import com.avimedical.appointments.generated.model.AppointmentDto;
import com.avimedical.appointments.generated.model.ChannelEnum;
import com.avimedical.appointments.scheduling.domain.model.Appointment;
import com.avimedical.appointments.scheduling.domain.model.Channel;
import org.springframework.stereotype.Component;

@Component
class AppointmentMapper {
    AppointmentDto toDto(Appointment appointment) {
        AppointmentDto dto = new AppointmentDto();
        dto.setId(appointment.getId());
        dto.setPracticeId(appointment.getPracticeId());
        dto.setReasonId(appointment.getReasonId());
        dto.setVideoCallLink(appointment.getVideoCallLink());
        dto.setStartTime(appointment.getStartTime().toString());
        dto.setEndTime(appointment.getEndTime().toString());
        dto.setCancellationLink(appointment.getCancellationLink());
        dto.setChannel(ChannelEnum.valueOf(appointment.getChannel().toString()));
        dto.setNotes(appointment.getNotes());
        dto.setSymptoms(appointment.getSymptoms());
        return dto;
    }

    Appointment toDomain(AppointmentDto dto) {
        return Appointment.builder()
                .notes(dto.getNotes())
                .reasonId(dto.getReasonId())
                .practiceId(dto.getPracticeId())
                .startTime(Instant.parse(dto.getStartTime()))
                .channel(toDomain(dto.getChannel()))
                .symptoms(dto.getSymptoms())
                .build();
    }

    Channel toDomain(ChannelEnum channel) {
        return switch (channel) {
            case IN_PERSON -> Channel.IN_PERSON;
            case VIDEO_CALL -> Channel.VIDEO_CALL;
        };
    }
}
