package com.test.backend.persistence.repositories;

import com.test.backend.persistence.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Abubakr on 4/10/2017.
 */
@Repository
public interface PlanRepository extends CrudRepository<Plan, Integer> {
}
