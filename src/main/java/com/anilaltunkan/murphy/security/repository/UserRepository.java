package com.anilaltunkan.murphy.security.repository;

import com.anilaltunkan.murphy.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 20:55
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
