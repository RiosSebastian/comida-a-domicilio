package com.RiosTech.PlataformaDeComidaADomicilio.service;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.UserDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.UserDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.User;

public interface UserService {
    UserDtoRes create(UserDtoReq dto);
    User findById(Long id);
}
