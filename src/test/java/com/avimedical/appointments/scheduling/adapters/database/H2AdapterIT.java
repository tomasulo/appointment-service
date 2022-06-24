package com.avimedical.appointments.scheduling.adapters.database;

import java.util.List;

import com.avimedical.appointments.scheduling.domain.model.Reason;
import com.avimedical.appointments.scheduling.domain.model.Staff;
import com.avimedical.appointments.scheduling.domain.model.Treatment;
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
    void getReasons_HappyPath() {
        List<Reason> reasons = cut.getReasons();

        assertThat(reasons).hasSize(3);
    }
}
