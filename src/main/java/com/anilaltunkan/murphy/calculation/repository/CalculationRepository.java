package com.anilaltunkan.murphy.calculation.repository;

import com.anilaltunkan.murphy.calculation.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 28.09.2019 17:40
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Repository
public interface CalculationRepository extends JpaRepository<Calculation, Long> {
}
