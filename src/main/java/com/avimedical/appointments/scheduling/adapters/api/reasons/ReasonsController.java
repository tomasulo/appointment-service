package com.avimedical.appointments.scheduling.adapters.api.reasons;

import java.util.List;
import java.util.stream.Collectors;

import com.avimedical.appointments.generated.api.ReasonsApi;
import com.avimedical.appointments.generated.model.ReasonDto;
import com.avimedical.appointments.scheduling.domain.model.Reason;
import com.avimedical.appointments.scheduling.domain.ports.ReasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
class ReasonsController implements ReasonsApi {

    private final ReasonRepository repository;
    private final ReasonsMapper mapper;

    @Override
    public ResponseEntity<ReasonDto> createReason(ReasonDto reasonDto) {
        Reason reason = repository.create(mapper.toDomain(reasonDto));
        return ResponseEntity.ok(mapper.toDto(reason));
    }

    @Override
    public ResponseEntity<List<ReasonDto>> getReasons() {
        List<Reason> reasons = repository.getReasons();
        return ResponseEntity.ok(reasons.stream().map(mapper::toDto).toList());
    }
}
