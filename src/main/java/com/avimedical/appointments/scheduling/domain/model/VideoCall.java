package com.avimedical.appointments.scheduling.domain.model;

import java.time.Duration;
import java.time.Instant;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class VideoCall {
    String url;
    Instant startTime;
    Duration duration;
}
