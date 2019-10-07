package com.anilaltunkan.murphy.calculation.controller;

import com.anilaltunkan.murphy.calculation.dto.CalculationRequest;
import com.anilaltunkan.murphy.calculation.dto.CalculationResponse;
import com.anilaltunkan.murphy.calculation.service.MurphyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 28.09.2019 17:58
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@RestController
@RequestMapping("/")
public class MurphyController {
    private MurphyService murphyService;

    @Autowired
    public MurphyController(MurphyService murphyService) {
        this.murphyService = murphyService;
    }

    @PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalculationResponse> calculate(@RequestBody CalculationRequest calculationRequest, Device device) {
        return ResponseEntity.ok(murphyService.calculateMurphy(calculationRequest));
    }
}
