package com.RiosTech.PlataformaDeComidaADomicilio.service.serviceImpl;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.UserDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.UserDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.User;
import com.RiosTech.PlataformaDeComidaADomicilio.mapper.UserMapper;
import com.RiosTech.PlataformaDeComidaADomicilio.repository.UserRepository;
import com.RiosTech.PlataformaDeComidaADomicilio.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDtoRes create(UserDtoReq dto) {
        User entity = UserMapper.toEntity(dto);
        userRepository.save(entity);
        return UserMapper.toDto(entity);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
