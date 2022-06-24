package com.avimedical.appointments.scheduling.domain.model;

import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Appointment {
    String id;
    Channel channel;
    String reasonId;
    String practiceId;
    String notes;
    List<String> symptoms;
    String videoCallLink;
    String cancellationLink;
    Instant startTime;
    Instant endTime;
}
