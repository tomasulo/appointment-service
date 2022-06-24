package com.avimedical.appointments.scheduling.domain.ports;

import java.time.Duration;

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
    private final ReasonService reasonService;
    private final VideoCallPort videoCallPort;

    public Appointment create(Appointment appt) {
        Duration duration = reasonService.getDuration(appt.getReasonId());
        appt.setEndTime(appt.getStartTime().plus(duration));

        if (appt.getChannel() == Channel.VIDEO_CALL) {
            VideoCall videoCall = videoCallPort.schedule(appt.getStartTime(), duration);
            appt.setVideoCallLink(videoCall.getUrl());
        }

        Appointment appointment = repository.create(appt);
        appointment.setCancellationLink("http://mocked-cancellation-link.com");
        return appointment;
    }
}
