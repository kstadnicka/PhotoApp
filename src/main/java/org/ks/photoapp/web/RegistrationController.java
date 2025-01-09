package org.ks.photoapp.web;

import org.ks.photoapp.domain.user.UserService;
import org.ks.photoapp.domain.user.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        UserDto user= new UserDto();
        model.addAttribute("user", user);
        return "registration-form";
    }

    @PostMapping("/registration")
    public String register(UserDto userDto) {
        userService.registerUser(userDto);
        return "success-registration";
    }
}
