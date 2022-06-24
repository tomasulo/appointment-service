package com.avimedical.appointments.scheduling.domain.model;

import java.time.Duration;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Reason {
    private String id;
    private String title;
    private String description;

    public Duration getTreatmentDuration() {
        // TODO
        return Duration.ofMinutes(30);
    }
}
