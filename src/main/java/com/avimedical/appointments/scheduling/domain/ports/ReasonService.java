package com.avimedical.appointments.scheduling.domain.ports;

import java.time.Duration;
import java.util.Optional;

import com.avimedical.appointments.scheduling.domain.model.Reason;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReasonService {

    private final ReasonRepository repository;

    public Duration getDuration(String reasonId) {
        Optional<Reason> reason = repository.find(reasonId);
        if (reason.isEmpty()) {
            return Duration.ofMinutes(30);
        }
        return reason.get().getTreatmentDuration();
    }
}
