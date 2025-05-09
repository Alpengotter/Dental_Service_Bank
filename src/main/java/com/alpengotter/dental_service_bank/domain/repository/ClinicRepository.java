package com.alpengotter.dental_service_bank.domain.repository;

import com.alpengotter.dental_service_bank.domain.entity.ClinicEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<ClinicEntity, Integer> {

    Optional<ClinicEntity> findByNameIgnoreCase(String name);
    Page<ClinicEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<ClinicEntity> findAll(Pageable pageRequest);
}
