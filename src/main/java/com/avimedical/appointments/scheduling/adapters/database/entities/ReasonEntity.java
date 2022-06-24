package com.avimedical.appointments.scheduling.adapters.database.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "REASONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReasonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Should be UUID or other non-guessable key format in production
    private String title;
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "reason_id")
    private List<TreatmentEntity> treatments;
}
