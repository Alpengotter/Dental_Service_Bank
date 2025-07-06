package com.alpengotter.dental_service_bank.domain.repository;

import com.alpengotter.dental_service_bank.domain.entity.NominationsEntity;
import com.alpengotter.dental_service_bank.domain.entity.OrdersEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NominationsRepository extends JpaRepository<NominationsEntity, Integer> {
}
