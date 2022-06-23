package com.avimedical.appointments.scheduling.adapters.h2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentCrudRepository extends CrudRepository<AppointmentEntity, Long> {
}
