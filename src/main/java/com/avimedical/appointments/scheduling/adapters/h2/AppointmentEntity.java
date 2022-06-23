package com.avimedical.appointments.scheduling.adapters.h2;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "APPOINTMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Should be UUID or other non-guessable key format in production

    private String notes;
    private String videoCallLink;
    private String reason;

    private Instant startDateTime;

    private Instant createdAt;
    private Instant modifiedAt;


}
