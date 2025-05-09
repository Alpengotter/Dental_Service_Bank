package com.alpengotter.dental_service_bank.domain.repository;

import com.alpengotter.dental_service_bank.domain.entity.ClinicEntity;
import com.alpengotter.dental_service_bank.domain.entity.UserClinicMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserClinicMapRepository extends JpaRepository<UserClinicMapEntity, Integer> {

}
