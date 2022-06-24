package com.avimedical.appointments.scheduling.adapters.database;

import com.avimedical.appointments.scheduling.adapters.database.entities.AppointmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AppointmentCrudRepository extends CrudRepository<AppointmentEntity, Long> {
}
