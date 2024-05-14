package com.aziz.voyages.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SecurityController {
	
	

    @GetMapping("/security/accessDenied")
    public String securityError() {
        return "securityAccessDenied"; // Use a unique view name
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Return the login view name
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/login"; // Redirect to the login page after logout
    }
}
