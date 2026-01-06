package com.RiosTech.PlataformaDeComidaADomicilio.dto;

import com.RiosTech.PlataformaDeComidaADomicilio.util.RoleEnum;
import lombok.Builder;
import lombok.Data;

@Builder

public record UserDtoRes(Long id,
                         String username,
                         String email,
                         RoleEnum role) {
}
