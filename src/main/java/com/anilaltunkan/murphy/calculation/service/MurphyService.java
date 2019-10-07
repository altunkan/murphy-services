package com.anilaltunkan.murphy.calculation.service;

import com.anilaltunkan.murphy.calculation.dto.CalculationRequest;
import com.anilaltunkan.murphy.calculation.dto.CalculationResponse;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 28.09.2019 17:37
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
public interface MurphyService {
    CalculationResponse calculateMurphy(CalculationRequest calculationRequest);
}
