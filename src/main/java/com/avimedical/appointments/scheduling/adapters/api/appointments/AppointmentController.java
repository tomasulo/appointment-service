package com.avimedical.appointments.scheduling.adapters.api.appointments;

import com.avimedical.appointments.generated.api.AppointmentsApi;
import com.avimedical.appointments.generated.model.AppointmentDto;
import com.avimedical.appointments.scheduling.domain.model.Appointment;
import com.avimedical.appointments.scheduling.domain.ports.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
class AppointmentController implements AppointmentsApi {

    private final AppointmentService service;
    private final AppointmentMapper mapper;

    @Override
    public ResponseEntity<AppointmentDto> createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = service.create(mapper.toDomain(appointmentDto));
        return ResponseEntity.ok(mapper.toDto(appointment));
    }

}
