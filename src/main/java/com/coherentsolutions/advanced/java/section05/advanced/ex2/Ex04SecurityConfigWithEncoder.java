package com.coherentsolutions.advanced.java.section05.advanced.ex2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration using password encoding.
 */
@Configuration
public class Ex04SecurityConfigWithEncoder {

    /**
     * Configures in-memory authentication with password encoding.
     *
     * @return UserDetailsService that contains the in-memory user with encoded password
     */
    @Bean
    public UserDetailsService customUserDetailsService() {
        // Create a user with encoded password
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    /**
     * Configures HTTP security settings.
     *
     * @param http the HttpSecurity object
     * @return SecurityFilterChain configured with authorization and authentication settings
     * @throws Exception if an error occurs
     */
    @Bean
    public SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/hello").hasRole("USER") // Secures /hello endpoint for USER role
                        .anyRequest().authenticated()
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
        return new BCryptPasswordEncoder();
    }
}
