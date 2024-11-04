package com.coherentsolutions.advanced.java.section05.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Ex03SecurityConfig {

    /**
     * Configures in-memory authentication with a user.
     *
     * @return a UserDetailsService containing the in-memory user
     */
    @Bean
    public UserDetailsService basicUserDetailsService() { // Rename bean to avoid conflict
        UserDetails user = User.withUsername("user")
                .password("{noop}password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }


    /**
     * Configures HTTP security settings.
     *
     * @param http the HttpSecurity object
     * @return the SecurityFilterChain for Spring Security
     * @throws Exception if an error occurs
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/hello").hasRole("USER") // Securing /hello endpoint
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.loginPage("/login").permitAll()) // Custom login page
                .httpBasic(httpBasic -> {}); // Enables basic HTTP authentication

        return http.build();
    }
}
