package com.example.password_service.controller;

import com.example.password_service.service.PasswordService;
import com.example.password_service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/create")
    public String createPassword(
            @RequestBody RawPassword rawPassword
    ) {
        return passwordService.hashPassword(rawPassword.getRaw_password());
    }

    @PostMapping("/check")
    public Boolean checkPassword(
            @RequestBody RawEncodedPassword rawEncodedPassword
    ) {
        return passwordService.verifyPassword(
                rawEncodedPassword.getRaw_password(),
                rawEncodedPassword.getEncoded_password()
        );
    }
}
