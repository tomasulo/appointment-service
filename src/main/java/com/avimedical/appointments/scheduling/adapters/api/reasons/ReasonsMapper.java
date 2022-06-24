package com.avimedical.appointments.scheduling.adapters.api.reasons;

import com.avimedical.appointments.generated.model.ReasonDto;
import com.avimedical.appointments.generated.model.TreatmentDto;
import com.avimedical.appointments.scheduling.domain.model.Reason;
import com.avimedical.appointments.scheduling.domain.model.Treatment;
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
                .treatments(reason.getTreatments().stream().map(this::toDto).toList())
                .description(reason.getDescription());
    }

    public TreatmentDto toDto(Treatment treatment) {
        return new TreatmentDto()
                .staff(treatment.getStaff().getName())
                .duration(treatment.getDuration().toString());
    }
}
