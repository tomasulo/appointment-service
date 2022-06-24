package com.avimedical.appointments.scheduling.adapters.database;

import com.avimedical.appointments.scheduling.domain.model.Reason;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
class H2AdapterIT {

    @Autowired
    H2Adapter cut;

    @Test
    void createReason_HappyPath() {
        Reason reason = Reason.builder().title("Title").description("Description").build();

        Reason result = cut.create(reason);

        assertThat(result.getId()).isNotNull();
        assertThat(result.getTitle()).isEqualTo("Title");
        assertThat(result.getDescription()).isEqualTo("Description");
    }
}
