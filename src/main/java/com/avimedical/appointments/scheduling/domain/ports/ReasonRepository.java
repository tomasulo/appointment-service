package com.avimedical.appointments.scheduling.domain.ports;

import java.util.List;
import java.util.Optional;

import com.avimedical.appointments.scheduling.domain.model.Reason;

public interface ReasonRepository {
    Reason create(Reason reason);

    List<Reason> getReasons();

    Optional<Reason> find(String reasonId);
}
