package com.elcorp.pocsecurity.service;

import com.elcorp.pocsecurity.dto.UserRegistrationDTO;
import com.elcorp.pocsecurity.exception.InvalidArgumentsException;

public interface ApplicationUserService {
    public void createNewUser(UserRegistrationDTO userRegistrationDTO) throws InvalidArgumentsException;
}
