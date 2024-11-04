package com.coherentsolutions.advanced.java.section05.advanced.ex3;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * A service demonstrating method-level security.
 */
@Service
public class Ex06SecureService {

    /**
     * Method accessible only to users with the "ADMIN" role.
     *
     * @return a secret message
     */
    @PreAuthorize("hasRole('ADMIN')")
    public String getSecret() {
        return "Secret Information";
    }
}
