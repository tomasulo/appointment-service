package com.avimedical.appointments.scheduling.domain.ports;

import java.time.Duration;
import java.time.Instant;

import com.avimedical.appointments.scheduling.domain.model.VideoCall;

public interface ConferencingPort {
    VideoCall scheduleCall(Instant startTime, Duration duration);
}
