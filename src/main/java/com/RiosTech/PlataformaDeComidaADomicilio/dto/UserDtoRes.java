package com.RiosTech.PlataformaDeComidaADomicilio.dto;

import com.RiosTech.PlataformaDeComidaADomicilio.util.RoleEnum;
import lombok.Builder;

@Builder
public record UserDtoRes(Long id,
                         String username,
                         String email,
                         RoleEnum role) {
}
