package com.RiosTech.PlataformaDeComidaADomicilio.repository;

import com.RiosTech.PlataformaDeComidaADomicilio.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
