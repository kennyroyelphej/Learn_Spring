package com.elcorp.pocsecurity.security;

import com.elcorp.pocsecurity.entity.ApplicationUser;
import com.elcorp.pocsecurity.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserManager implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;

    @Autowired
    public ApplicationUserManager(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApplicationUser> user = applicationUserRepository.findByUsername(username);
        user.orElseThrow(()-> new UsernameNotFoundException(String.format("Username %s not found",username)));
        return user.map(ApplicationUserPrototype::new).get();
    }
}
