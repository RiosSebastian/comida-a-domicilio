package com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq;

import com.RiosTech.PlataformaDeComidaADomicilio.util.RoleEnum;

public record UserDtoReq( String username,
         String password,
         String email,
         RoleEnum role) {
}
