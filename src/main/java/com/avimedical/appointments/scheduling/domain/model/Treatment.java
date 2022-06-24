package com.avimedical.appointments.scheduling.domain.model;

import java.time.Duration;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Treatment {
    Staff staff;
    Duration duration;
}
