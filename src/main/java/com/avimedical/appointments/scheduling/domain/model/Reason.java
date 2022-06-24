package com.avimedical.appointments.scheduling.domain.model;

import java.time.Duration;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Reason {
    private String id;
    private String title;
    private String description;
    private List<Treatment> treatments;

    public Duration getTreatmentDuration() {
        return treatments.stream().map(Treatment::getDuration).reduce(Duration.ZERO, Duration::plus);
    }
}
