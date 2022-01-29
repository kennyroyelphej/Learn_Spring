package com.elcorp.pocsecurity.controller;

import com.elcorp.pocsecurity.entity.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserService {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
