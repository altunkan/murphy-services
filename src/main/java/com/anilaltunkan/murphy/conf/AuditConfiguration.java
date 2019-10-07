package com.anilaltunkan.murphy.conf;

import com.anilaltunkan.murphy.util.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 03.10.2019 09:37
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Configuration
public class AuditConfiguration {
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
}
