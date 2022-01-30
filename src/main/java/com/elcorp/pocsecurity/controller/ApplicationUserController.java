package com.elcorp.pocsecurity.controller;

import com.elcorp.pocsecurity.dto.UserRegistrationDTO;
import com.elcorp.pocsecurity.exception.InvalidArgumentsException;
import com.elcorp.pocsecurity.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manage/user")
public class ApplicationUserController {

    private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody UserRegistrationDTO userRegistrationDTO) throws InvalidArgumentsException {
        applicationUserService.createNewUser(userRegistrationDTO);
        return new ResponseEntity<>("User Created Successfully",HttpStatus.CREATED);
    }

}
