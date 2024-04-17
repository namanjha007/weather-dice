package com.example.weather.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Objects;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Value("${myapp.clientId}")
    private String clientIdActual;

    @Value("${myapp.clientSecret}")
    private String clientSecretActual;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Extract client id and client secret from request headers
        String clientId = request.getHeader("client-id");
        String clientSecret = request.getHeader("client-secret");

        // Perform authentication based on extracted credentials
        if (isValidClientCredentials(clientId, clientSecret)) {
            // If credentials are valid, proceed with the request
            filterChain.doFilter(request, response);
        } else {
            // If credentials are invalid, return unauthorized response
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
    }

    private boolean isValidClientCredentials(String clientId, String clientSecret) {
        // Checking if both id and secret matches with the actual values
        return Objects.equals(clientId, clientIdActual) && Objects.equals(clientSecret, clientSecretActual);
    }
}
