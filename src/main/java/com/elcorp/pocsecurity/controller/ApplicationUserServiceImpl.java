package com.elcorp.pocsecurity.controller;

import com.elcorp.pocsecurity.entity.ApplicationUser;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.elcorp.pocsecurity.security.ApplicationUserRoles.*;

@Repository("fake")
public class ApplicationUserServiceImpl implements ApplicationUserService{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationUserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
            new ApplicationUser(
                    "june",
                    passwordEncoder.encode("password"),
                    STUDENT.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),
            new ApplicationUser(
                    "regina",
                    passwordEncoder.encode("password"),
                    ADMIN.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),
            new ApplicationUser(
                    "danny",
                    passwordEncoder.encode("password"),
                    MANAGER.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            )
        );
        return applicationUsers;
    }

}
