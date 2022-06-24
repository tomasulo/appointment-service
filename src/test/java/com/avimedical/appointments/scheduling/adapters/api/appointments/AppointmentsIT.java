package com.avimedical.appointments.scheduling.adapters.api.appointments;

import com.avimedical.appointments.generated.model.AppointmentDto;
import com.avimedical.appointments.generated.model.ChannelEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class AppointmentsIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void shouldCreateVideoCallAppointment() throws Exception {
        MvcResult result = mockMvc.perform(
                        post("/appointments")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\n"
                                        + "    \"notes\": \"Hey I am really sick!\",\n"
                                        + "    \"channel\": \"VIDEO_CALL\",\n"
                                        + "    \"reasonId\":\"2\",\n"
                                        + "    \"symptoms\": [\"FEVER\",\"COUGH\"],\n"
                                        + "    \"startTime\": \"2022-07-23T07:15:00Z\",\n"
                                        + "    \"practiceId\": \"15\",\n"
                                        + "    \"staffId\": \"3\"\n"
                                        + "}")
                                .characterEncoding("utf-8"))
                .andExpect(status().isOk()).andReturn();

        AppointmentDto response = mapper.readValue(result.getResponse().getContentAsString(), AppointmentDto.class);

        assertThat(response.getId()).isNotNull();
        assertThat(response.getChannel()).isEqualTo(ChannelEnum.VIDEO_CALL);
        assertThat(response.getReasonId()).isEqualTo("2");
        assertThat(response.getSymptoms()).contains("FEVER", "COUGH");
        assertThat(response.getStartTime()).isEqualTo("2022-07-23T07:15:00Z");
        assertThat(response.getEndTime()).isEqualTo("2022-07-23T07:45:00Z");
        assertThat(response.getNotes()).isEqualTo("Hey I am really sick!");
        assertThat(response.getCancellationLink()).isNotNull();
        assertThat(response.getVideoCallLink()).isNotNull();
    }
}
