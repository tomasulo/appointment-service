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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
