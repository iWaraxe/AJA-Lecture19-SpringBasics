package com.coherentsolutions.advanced.java.section05.advanced.ex3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configures multiple users with different roles.
 */
@Configuration
public class Ex07MultiUserSecurityConfig {

    /**
     * Configures in-memory authentication with multiple users.
     *
     * @return UserDetailsService with two in-memory users
     */
    @Bean
    public UserDetailsService multyUserDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    /**
     * Configures HTTP security settings.
     *
     * @param http the HttpSecurity object
     * @return SecurityFilterChain for Spring Security
     * @throws Exception if an error occurs
     */
    @Bean
    public SecurityFilterChain multySecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/hello").hasAnyRole("USER", "ADMIN") // Accessible by both USER and ADMIN roles
                        .requestMatchers("/admin").hasRole("ADMIN") // Accessible by ADMIN role only
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.loginPage("/login").permitAll()) // Custom login page
                .httpBasic(httpBasic -> {}); // Enables basic HTTP authentication
        return http.build();
    }

    /**
     * Defines a no-op password encoder for simplicity.
     *
     * @return PasswordEncoder instance
     */
    @Bean
    public PasswordEncoder multyPasswordEncoder() {
        // NoOpPasswordEncoder is used here only for simplicity and demonstration purposes
        return NoOpPasswordEncoder.getInstance();
    }
}
