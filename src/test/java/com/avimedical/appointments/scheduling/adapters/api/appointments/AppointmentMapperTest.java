package com.avimedical.appointments.scheduling.adapters.api.appointments;

import java.time.Instant;
import java.util.List;

import com.avimedical.appointments.generated.model.AppointmentDto;
import com.avimedical.appointments.generated.model.ChannelEnum;
import com.avimedical.appointments.scheduling.domain.model.Appointment;
import com.avimedical.appointments.scheduling.domain.model.Channel;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AppointmentMapperTest {

    AppointmentMapper cut = new AppointmentMapper();

    @Test
    void toDto_HappyPath() {
        Appointment appointment = Appointment.builder()
                .id("1")
                .channel(Channel.VIDEO_CALL)
                .practiceId("2")
                .startTime(Instant.parse("2022-07-23T07:15:00Z"))
                .endTime(Instant.parse("2022-07-23T07:45:00Z"))
                .notes("A note")
                .reasonId("3")
                .symptoms(List.of("FEVER", "COUGH"))
                .videoCallLink("video")
                .cancellationLink("cancel")
                .build();

        AppointmentDto result = cut.toDto(appointment);

        assertThat(result.getChannel()).isEqualTo(ChannelEnum.VIDEO_CALL);
        assertThat(result.getPracticeId()).isEqualTo("2");
        assertThat(result.getStartTime()).isEqualTo("2022-07-23T07:15:00Z");
        assertThat(result.getEndTime()).isEqualTo("2022-07-23T07:45:00Z");
        assertThat(result.getNotes()).isEqualTo("A note");
        assertThat(result.getReasonId()).isEqualTo("3");
        assertThat(result.getSymptoms()).contains("FEVER", "COUGH");
    }
}
