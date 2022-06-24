package com.avimedical.appointments.scheduling.domain.ports;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.avimedical.appointments.scheduling.domain.model.Appointment;
import com.avimedical.appointments.scheduling.domain.model.Channel;
import com.avimedical.appointments.scheduling.domain.model.VideoCall;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {

    @Mock AppointmentRepository repository;
    @Mock ReasonService reasonService;
    @Mock VideoCallPort videoCallPort;

    @InjectMocks
    AppointmentService cut;

    @Test
    void create_VideoCallChannel_HappyPath() {
        when(reasonService.getDuration(any())).thenReturn(Duration.ofMinutes(30));
        when(videoCallPort.schedule(any(), any())).thenReturn(VideoCall.builder().url("url").build());
        Appointment appt = Appointment.builder()
                .reasonId("1")
                .channel(Channel.VIDEO_CALL)
                .startTime(Instant.parse("2022-07-23T07:15:00Z")).build();
        when(repository.create(any())).thenReturn(appt);

        Appointment result = cut.create(appt);

        assertThat(result.getEndTime()).isAfterOrEqualTo(result.getStartTime().plus(30, ChronoUnit.MINUTES));
        assertThat(result.getVideoCallLink()).isEqualTo("url");
        verify(reasonService).getDuration("1");
        verify(videoCallPort).schedule(appt.getStartTime(), Duration.ofMinutes(30));
        verify(repository).create(appt);
    }
}
