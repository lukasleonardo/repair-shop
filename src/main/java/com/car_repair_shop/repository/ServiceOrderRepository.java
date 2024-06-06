package com.car_repair_shop.repository;

import com.car_repair_shop.domain.service_order.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder,Long> {
}
