package com.avimedical.appointments.scheduling.adapters.api;

import com.avimedical.appointments.generated.api.AppointmentsApi;
import com.avimedical.appointments.generated.model.CreateAppointment200Response;
import com.avimedical.appointments.generated.model.CreateAppointmentRequest;
import com.avimedical.appointments.scheduling.domain.model.Appointment;
import com.avimedical.appointments.scheduling.domain.model.Channel;
import com.avimedical.appointments.scheduling.domain.model.Reason;
import com.avimedical.appointments.scheduling.domain.ports.AppointmentService;
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

    // todo practiceId, staffId
    // authentication

    private Appointment toAppointment(CreateAppointmentRequest request) {
        return Appointment.builder()
                .notes(request.getNotes())
                .reason(Reason.valueOf("COUGH")) // todo
                .startDateTime(request.getStartDateTime().toInstant())
                .channel(Channel.valueOf(request.getChannel().name())) // I assume not-null for simplicity
                .build();
    }

    private CreateAppointment200Response toResponse(Appointment appointment) {
        CreateAppointment200Response response = new CreateAppointment200Response();
        response.setId(appointment.getId().toString());
        response.setBookedStartTime(appointment.getStartDateTime().toString());
        response.setEstimatedEndTime(appointment.getEstimatedEndTime().toString());
        response.setCancellationLink(appointment.getCancellationLink());
        response.setVideoCallLink(appointment.getVideoCallLink());
        return response;
    }
}
