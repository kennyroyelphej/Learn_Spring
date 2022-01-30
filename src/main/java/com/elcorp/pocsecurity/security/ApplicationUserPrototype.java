package com.elcorp.pocsecurity.security;

import com.elcorp.pocsecurity.entity.ApplicationUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class ApplicationUserPrototype implements UserDetails {

    private final String username;
    private final String password;
    private final Set<? extends GrantedAuthority> grantedAuthority;
    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;

    public ApplicationUserPrototype(
            String username,
            String password,
            Set<? extends GrantedAuthority> grantedAuthority,
            boolean isAccountNonExpired,
            boolean isAccountNonLocked,
            boolean isCredentialsNonExpired,
            boolean isEnabled
    ) {
        this.username = username;
        this.password = password;
        this.grantedAuthority = grantedAuthority;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    public ApplicationUserPrototype(ApplicationUser applicationUser){
        this.username = applicationUser.getUsername();
        this.password = applicationUser.getPassword();
        this.grantedAuthority = ApplicationUserRoles.valueOf(applicationUser.getRole()).getGrantedAuthorities();
        this.isAccountNonExpired = applicationUser.isAccountNonExpired();
        this.isAccountNonLocked = applicationUser.isAccountNonLocked();
        this.isCredentialsNonExpired = applicationUser.isCredentialsNonExpired();
        this.isEnabled = applicationUser.isEnabled();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthority;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public String toString() {
        return "ApplicationUserPrototype{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", grantedAuthority=" + grantedAuthority +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
