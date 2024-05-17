package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.model.CustomUserDetails;
import com.example.repository.UserRepository;

@Service
public class DetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = repository.findByUsername(username);
        if (employee.isPresent()) {
            return new CustomUserDetails(employee.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
