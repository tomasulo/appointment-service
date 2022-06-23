package com.avimedical.appointments.scheduling.adapters.zoom;

import java.time.Duration;
import java.time.Instant;

import com.avimedical.appointments.scheduling.domain.model.VideoCall;
import com.avimedical.appointments.scheduling.domain.ports.ConferencingPort;
import org.springframework.stereotype.Component;

@Component
public class ZoomAdapter implements ConferencingPort {
    @Override
    public VideoCall scheduleCall(Instant startTime, Duration duration) {
        return VideoCall.builder()
                .url("https://mocked-video-call-url.com")
                .duration(duration)
                .startTime(startTime)
                .build();
    }
}
