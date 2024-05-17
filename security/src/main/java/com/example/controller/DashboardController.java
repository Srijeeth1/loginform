package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin/home")
    public String displayAdminDashboard() {
        return "admin";
    }

    @GetMapping("/employee/home")
    public String displayUserDashboard() {
        return "employee";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
