package com.avimedical.appointments.scheduling.adapters.database.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "APPOINTMENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Should be UUID or other non-guessable key format in production

    private String channel;
    private String notes;
    private String symptoms;
    private String videoCallLink;
    private String cancellationLink;
    private Instant startTime;
    private Instant endTime;

    // todo: FK relations to other entities
    private String patientId;
    private String practiceId;
    private String staffId;

    @ManyToOne
    @JoinColumn(name ="reason_id")
    private ReasonEntity reason;
}
