package com.RiosTech.PlataformaDeComidaADomicilio.repository;

import com.RiosTech.PlataformaDeComidaADomicilio.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
