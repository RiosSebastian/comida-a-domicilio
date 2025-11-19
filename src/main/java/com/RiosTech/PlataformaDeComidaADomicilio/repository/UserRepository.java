package com.RiosTech.PlataformaDeComidaADomicilio.repository;

import com.RiosTech.PlataformaDeComidaADomicilio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
}
