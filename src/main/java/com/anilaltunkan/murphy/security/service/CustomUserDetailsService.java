package com.anilaltunkan.murphy.security.service;

import com.anilaltunkan.murphy.security.dto.UserPrincipal;
import com.anilaltunkan.murphy.err.exception.ResourceNotFoundException;
import com.anilaltunkan.murphy.security.model.User;
import com.anilaltunkan.murphy.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 22:20
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email : " + email)
                );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipal.create(user);
    }
}
