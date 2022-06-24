package com.avimedical.appointments.scheduling.adapters.database.entities;

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
@Table(name = "REASONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReasonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Should be UUID or other non-guessable key format in production
    private String title;
    private String description;
}
