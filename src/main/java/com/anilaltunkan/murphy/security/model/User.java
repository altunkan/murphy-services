package com.anilaltunkan.murphy.security.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 20:51
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Entity
@Table(schema = "murphy", name = "user")
@Data
@EqualsAndHashCode(of = {"userId"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long userId;
    @Column(length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String name;
    @Column(length = 100)
    @NotNull
    @Size(min = 4, max = 100)
    private String password;
    @Column(length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    @Email
    private String email;
    @NotNull
    private Boolean enabled;
    private String imageUrl;
    @Column(nullable = false)
    private Boolean emailVerified = false;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;
    private String providerId;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "authorityId", referencedColumnName = "authorityId")})
    private List<Authority> authorities;
}
