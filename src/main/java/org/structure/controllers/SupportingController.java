package org.structure.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.structure.models.Role;

@Controller
@RequiredArgsConstructor
public class SupportingController {

    @GetMapping(value = "/sign-in")
    public String getsignInForm() {
        return "signInPage";
    }

    @GetMapping(value = "/client")
    public String redirect() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().contains(Role.PATIENT)) {
            return "redirect:/patient/home-page";
        } else {
            return "redirect:/doctor/home-page";
        }
    }
}