package com.alpengotter.dental_service_bank.domain.repository;

import com.alpengotter.dental_service_bank.domain.entity.ActivitiesEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivitiesRepository extends JpaRepository<ActivitiesEntity, Integer> {

    List<ActivitiesEntity> findAllByIsActiveIsTrue();
}
