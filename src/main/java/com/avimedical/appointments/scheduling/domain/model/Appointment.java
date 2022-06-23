package com.avimedical.appointments.scheduling.domain.model;

import java.time.Instant;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Appointment {
    Long id;
    Channel channel;
    Reason reason;
    String notes;
    String videoCallLink;
    String cancellationLink;
    Instant startDateTime;
    Instant estimatedEndTime;
}
