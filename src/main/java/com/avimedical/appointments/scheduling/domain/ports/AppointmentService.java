package com.avimedical.appointments.scheduling.domain.ports;

import java.time.Duration;
import java.time.Instant;

import com.avimedical.appointments.scheduling.domain.model.Appointment;
import com.avimedical.appointments.scheduling.domain.model.Channel;
import com.avimedical.appointments.scheduling.domain.model.VideoCall;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository repository;
    private final ConferencingPort conferencing;

    public Appointment save(Appointment appt) {
        if (appt.getChannel() == Channel.ONLINE) {
            VideoCall videoCall = conferencing.scheduleCall(appt.getStartDateTime(), Duration.ofMinutes(60));
            appt = appt.toBuilder().videoCallLink(videoCall.getUrl()).build();
        }

        // TODO map symptoms and reason

        Appointment appointment = repository.save(appt); // todo return other object?
        appointment = addCancellationLink(appointment);
        appointment = addEstimatedEndTime(appointment);
        log.debug("Saved appointment: {}", appointment);
        return appointment;
    }

    private Appointment addEstimatedEndTime(Appointment appointment) {

        Appointment.AppointmentBuilder builder = appointment.toBuilder();
        Instant start = appointment.getStartDateTime();
        // todo make "reason -> duration" configurable
        switch (appointment.getReason()) {
            case FEVER -> builder.estimatedEndTime(start.plus(Duration.ofMinutes(20)));
            case COUGH -> builder.estimatedEndTime(start.plus(Duration.ofMinutes(10)));
            case SORE_THROAT -> builder.estimatedEndTime(start.plus(Duration.ofMinutes(15)));
        }
        return builder.build();
    }

    // todo move to e.g. CancellationService
    private Appointment addCancellationLink(Appointment appt) {
        return appt.toBuilder()
                .cancellationLink("https://mocked-cancellation-link.com")
                .build();
    }
}
