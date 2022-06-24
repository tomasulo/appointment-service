package com.avimedical.appointments.scheduling.adapters.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TREATMENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreatmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Should be UUID or other non-guessable key format in production

    @ManyToOne
    @JoinColumn(name = "reason_id")
    private ReasonEntity reason;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;

    private String duration;
}
