package com.elcorp.pocsecurity.security;

import com.elcorp.pocsecurity.jwt.ApplicationJWTConfiguration;
import com.elcorp.pocsecurity.jwt.ApplicationTokenValidator;
import com.elcorp.pocsecurity.jwt.ApplicationUserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

import static com.elcorp.pocsecurity.security.ApplicationUserRoles.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserManager applicationUserManager;
    private final ApplicationJWTConfiguration applicationJWTConfiguration;
    private final SecretKey secretKey;

    @Autowired
    public ApplicationSecurityConfiguration(
            PasswordEncoder passwordEncoder, ApplicationUserManager applicationUserManager,
            ApplicationJWTConfiguration applicationJWTConfiguration, SecretKey secretKey) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserManager = applicationUserManager;
        this.applicationJWTConfiguration = applicationJWTConfiguration;
        this.secretKey = secretKey;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()   //disable if non-browser
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())    // only when a request is processed by the browser
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new ApplicationUserAuthentication(authenticationManager(),applicationJWTConfiguration,secretKey))
                .addFilterAfter(new ApplicationTokenValidator(applicationJWTConfiguration, secretKey),ApplicationUserAuthentication.class)
                .authorizeRequests()
                    .antMatchers("/","index","/css/*","/js/*").permitAll()
                    .antMatchers("/student/**").hasRole(STUDENT.name())
                    .antMatchers("/manage/user").permitAll()
//                    .antMatchers(HttpMethod.POST,"/manage/**").hasAuthority(STUDENT_WRITE.getPermission())
//                    .antMatchers(HttpMethod.PUT,"/manage/**").hasAuthority(STUDENT_WRITE.getPermission())
//                    .antMatchers(HttpMethod.DELETE,"/manage/**").hasAuthority(STUDENT_WRITE.getPermission())
//                    .antMatchers("/manage/**").hasAnyRole(ADMIN.name(),MANAGER.name())
                    .anyRequest()
                .authenticated();
//                .and()
//                .httpBasic(); // basic authentication method
//                .formLogin()  // form based authentication
//                    .loginPage("/login").permitAll()
//                    .defaultSuccessUrl("/courses",true)
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//                .and()
//                .rememberMe()
//                    .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21)) //default to two weeks
//                    .key("somethingverysecure")
//                    .rememberMeParameter("remember-me")
//                .and()
//                .logout()
//                    .logoutUrl("/logout")
//                    .clearAuthentication(true)
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID","remember-me")
//                    .logoutSuccessUrl("/login");
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
