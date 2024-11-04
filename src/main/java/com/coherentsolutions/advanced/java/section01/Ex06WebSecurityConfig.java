package com.coherentsolutions.advanced.java.section01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configures web security for the application.
 */
@Configuration
public class Ex06WebSecurityConfig {

    /**
     * Configures in-memory authentication with a user.
     *
     * @return UserDetailsService that contains the in-memory user
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("{noop}password") // {noop} indicates no password encoding
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    /**
     * Configures HTTP security settings.
     *
     * @param http the HttpSecurity object
     * @return SecurityFilterChain configured with authentication settings
     * @throws Exception if an error occurs
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().authenticated() // All requests require authentication
                )
                .formLogin(form -> form.loginPage("/login").permitAll()) // Custom login page
                .httpBasic(httpBasic -> {}); // Enables basic HTTP authentication

        return http.build();
    }

    /**
     * Defines the password encoder bean.
     *
     * @return the PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
