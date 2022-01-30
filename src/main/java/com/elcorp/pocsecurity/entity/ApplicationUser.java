package com.elcorp.pocsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name="application_user",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_username",
                columnNames = "username"
        )
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationUser {

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
    private Long userId;
    private String username;
    private String password;
    private String role;
    private  boolean isAccountNonExpired;
    private  boolean isAccountNonLocked;
    private  boolean isCredentialsNonExpired;
    private  boolean isEnabled;

}
