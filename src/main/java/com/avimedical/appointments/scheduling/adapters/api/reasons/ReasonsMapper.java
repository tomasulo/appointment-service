package com.avimedical.appointments.scheduling.adapters.api.reasons;

import com.avimedical.appointments.generated.model.ReasonDto;
import com.avimedical.appointments.scheduling.domain.model.Reason;
import org.springframework.stereotype.Component;

@Component
class ReasonsMapper {
    public Reason toDomain(ReasonDto reasonDto) {
        return Reason.builder()
                .id(reasonDto.getId())
                .title(reasonDto.getTitle())
                .description(reasonDto.getDescription())
                .build();
    }

    public ReasonDto toDto(Reason reason) {
        return new ReasonDto()
                .id(reason.getId())
                .title(reason.getTitle())
                .description(reason.getDescription());
    }
}
