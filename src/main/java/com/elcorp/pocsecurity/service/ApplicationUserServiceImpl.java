package com.elcorp.pocsecurity.service;

import com.elcorp.pocsecurity.dto.UserRegistrationDTO;
import com.elcorp.pocsecurity.entity.ApplicationUser;
import com.elcorp.pocsecurity.exception.InvalidArgumentsException;
import com.elcorp.pocsecurity.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService{

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserRepository applicationUserRepository;

    @Autowired
    public ApplicationUserServiceImpl(PasswordEncoder passwordEncoder, ApplicationUserRepository applicationUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public void createNewUser(UserRegistrationDTO userRegistrationDTO) throws InvalidArgumentsException {
        Optional<ApplicationUser> testUser = applicationUserRepository.findByUsername(userRegistrationDTO.getUsername());
        if(testUser.isPresent()){ throw new InvalidArgumentsException("Username already exists");}
        ApplicationUser user = new ApplicationUser();
        user.setUsername(userRegistrationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        user.setRole(userRegistrationDTO.getRole());
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        applicationUserRepository.save(user);
    }

}
