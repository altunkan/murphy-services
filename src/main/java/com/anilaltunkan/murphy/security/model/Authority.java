package com.anilaltunkan.murphy.security.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 20:52
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Entity
@Table(schema = "murphy", name = "authority")
@Data
@EqualsAndHashCode(of = {"authorityId"})
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_seq")
    @SequenceGenerator(name = "authority_seq", sequenceName = "authority_seq", allocationSize = 1)
    private Long authorityId;
    @Column(length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName authorityName;
    @ToString.Exclude
    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;
}