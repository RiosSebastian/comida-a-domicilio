package com.RiosTech.PlataformaDeComidaADomicilio.repository;

import com.RiosTech.PlataformaDeComidaADomicilio.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
