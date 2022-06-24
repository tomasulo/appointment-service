package com.avimedical.appointments.scheduling.adapters.database;

import com.avimedical.appointments.scheduling.adapters.database.entities.ReasonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ReasonCrudRepository extends CrudRepository<ReasonEntity, Long> {
}
