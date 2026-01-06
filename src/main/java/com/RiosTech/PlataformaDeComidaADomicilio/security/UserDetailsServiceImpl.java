package com.RiosTech.PlataformaDeComidaADomicilio.security;

import com.RiosTech.PlataformaDeComidaADomicilio.entity.User;
import com.RiosTech.PlataformaDeComidaADomicilio.repository.UserRepository;
import com.RiosTech.PlataformaDeComidaADomicilio.util.RoleEnum;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.nio.file.attribute.UserPrincipal;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Usuario no encontrado: " + username
                        )
                );

        return (UserDetails) User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .role(RoleEnum.valueOf(user.getRole().name())) // o authorities
                .build();
    }
}
