package com.anilaltunkan.murphy.security.service;

import com.anilaltunkan.murphy.security.dto.Profile;
import com.anilaltunkan.murphy.err.exception.ResourceNotFoundException;
import com.anilaltunkan.murphy.security.model.User;
import com.anilaltunkan.murphy.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 23:41
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Profile getProfile(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException("User", "id", userId);
        }
        User user = userOptional.get();
        return new Profile(user.getUserId(), user.getEmail());
    }
}
