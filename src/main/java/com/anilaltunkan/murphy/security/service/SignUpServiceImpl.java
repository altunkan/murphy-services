package com.anilaltunkan.murphy.security.service;

import com.anilaltunkan.murphy.security.dto.SignUpRequest;
import com.anilaltunkan.murphy.err.exception.BadRequestException;
import com.anilaltunkan.murphy.security.model.AuthProvider;
import com.anilaltunkan.murphy.security.model.Authority;
import com.anilaltunkan.murphy.security.model.AuthorityName;
import com.anilaltunkan.murphy.security.model.User;
import com.anilaltunkan.murphy.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 22:28
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User saveUser(SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setProvider(AuthProvider.local);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Authority authority = new Authority();
        authority.setAuthorityName(AuthorityName.ROLE_USER);
        user.setAuthorities(Arrays.asList(authority));
        return userRepository.save(user);
    }
}
