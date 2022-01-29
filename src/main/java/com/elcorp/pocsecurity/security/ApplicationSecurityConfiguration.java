package com.elcorp.pocsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.concurrent.TimeUnit;

import static com.elcorp.pocsecurity.security.ApplicationUserRoles.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserManager applicationUserManager;

    @Autowired
    public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder, ApplicationUserManager applicationUserManager) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserManager = applicationUserManager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()   //disable if non-browser
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())    // only when a request is processed by the browser
//                .and()
                .authorizeRequests()
                    .antMatchers("/","index","/css/*","/js/*").permitAll()
                    .antMatchers("/student/**").hasRole(STUDENT.name())
//                    .antMatchers(HttpMethod.POST,"/manage/**").hasAuthority(STUDENT_WRITE.getPermission())
//                    .antMatchers(HttpMethod.PUT,"/manage/**").hasAuthority(STUDENT_WRITE.getPermission())
//                    .antMatchers(HttpMethod.DELETE,"/manage/**").hasAuthority(STUDENT_WRITE.getPermission())
//                    .antMatchers("/manage/**").hasAnyRole(ADMIN.name(),MANAGER.name())
                    .anyRequest()
                .authenticated()
                .and()
//                .httpBasic(); // basic authentication method
                .formLogin()
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/courses",true)
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21)) //default to two weeks
                    .key("somethingverysecure")
                    .rememberMeParameter("remember-me")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID","remember-me")
                    .logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserManager);
        return provider;
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails june = User.builder()
//                .username("june")
//                .password(passwordEncoder.encode("password"))
//                .roles("STUDENT")
//                .roles(STUDENT.name())  //ROLE_STUDENT
//                .authorities(STUDENT.getGrantedAuthorities())
//                .build();
//        UserDetails regina = User.builder()
//                .username("regina")
//                .password(passwordEncoder.encode("password"))
//                .roles("ADMIN")
//                .roles(ADMIN.name())  //ROLE_ADMIN
//                .authorities(ADMIN.getGrantedAuthorities())
//                .build();
//        UserDetails danny = User.builder()
//                .username("danny")
//                .password(passwordEncoder.encode("password"))
//                .roles("MANAGER")
//                .roles(MANAGER.name())  //ROLE_MANAGER
//                .authorities(MANAGER.getGrantedAuthorities())
//                .build();
//        return new InMemoryUserDetailsManager( june, regina, danny );
//    }

}
