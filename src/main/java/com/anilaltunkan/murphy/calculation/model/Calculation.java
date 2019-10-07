package com.anilaltunkan.murphy.calculation.model;

import com.anilaltunkan.murphy.util.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 28.09.2019 17:29
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Entity
@Table(schema = "murphy", name = "calculation")
@Data @EqualsAndHashCode(of = {"calculationId"})
public class Calculation extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calc_seq")
    @SequenceGenerator(name = "calc_seq", sequenceName = "calc_seq", allocationSize = 1)
    private Long calculationId;
    @Column(length = 1000)
    @NotNull
    @Size(min = 4, max = 1000)
    private String event;
    @NotNull
    private BigDecimal urgency;
    @NotNull
    private BigDecimal importance;
    @NotNull
    private BigDecimal complexity;
    @NotNull
    private BigDecimal skill;
    @NotNull
    private BigDecimal frequency;
    private BigDecimal murphy;
    private LocalDateTime eventTime;
    @Column(length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private CalculationStatus status;
}
