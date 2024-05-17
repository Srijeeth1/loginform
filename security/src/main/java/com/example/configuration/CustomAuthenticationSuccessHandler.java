package com.example.configuration;

import java.io.IOException;
import java.util.Collection;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(authority -> {
            try {
                if (authority.getAuthority().equals("ROLE_ADMIN")) {
                    response.sendRedirect("/admin/home");
                } else if (authority.getAuthority().equals("ROLE_EMPLOYEE")) {
                    response.sendRedirect("/employee/home");
                } else {
                    throw new IllegalStateException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
