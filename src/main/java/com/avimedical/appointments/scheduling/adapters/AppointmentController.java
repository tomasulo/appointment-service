package com.avimedical.appointments.scheduling.adapters;

import com.avimedical.appointments.scheduling.domain.model.Appointment;
import com.avimedical.appointments.scheduling.domain.model.CreateAppointment;
import com.avimedical.appointments.scheduling.domain.ports.AppointmentService;
import com.avimedical.appointments.generated.api.AppointmentsApi;
import com.avimedical.appointments.generated.model.CreateAppointment200Response;
import com.avimedical.appointments.generated.model.CreateAppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
class AppointmentController implements AppointmentsApi {

    private final AppointmentService service;

    @Override
    public ResponseEntity<CreateAppointment200Response> createAppointment(
            CreateAppointmentRequest request) {
        Appointment appointment = service.save(toAppointment(request));
        return ResponseEntity.ok(toResponse(appointment));
    }

    private Appointment toAppointment(CreateAppointmentRequest request) {
        return null;
    }

    private CreateAppointment200Response toResponse(Appointment appointment) {
        return new CreateAppointment200Response();
    }

    private CreateAppointment toCreateAppointment(CreateAppointmentRequest request) {
        return new CreateAppointment();
    }
}
