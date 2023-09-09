package com.tkg.MasterSystem.entities;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Data
@Table(name = "users")
public class User implements UserDetails {

    public User() {}

    public User(String title, String firstName, String lastName, String middleName, String email, String password, LocalDate dob, String gender, String avatarUrl, Long roleId, Boolean status, String countryCode, String phoneNumber, String authenticationCode, LocalDateTime sendAuthenticationCodeAt, Long createdBy) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.avatarUrl = avatarUrl;
        this.roleId = roleId;
        this.status = status;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.authenticationCode = authenticationCode;
        this.sendAuthenticationCodeAt = sendAuthenticationCodeAt;
        this.createdBy = createdBy;
    }

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    @Column(nullable = false, length = 10)
    private String title;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(nullable = true, length = 20)
    private String middleName;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private LocalDate dob;

    @Column(nullable = false, length = 5)
    private String gender;

    private String avatarUrl;

    @Column(nullable = false)
    private Long roleId;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean status;

    @Column(length = 10)
    private String countryCode;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 6)
    private String authenticationCode;

    private LocalDateTime sendAuthenticationCodeAt;

    @Column(nullable = false)
    private Long createdBy;

    @Column(nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long deletedBy;

    private LocalDateTime deletedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }
}

