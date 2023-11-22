package com.efass.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    @Size(min = 4, message = "Username should have at least 5 characters")
    private String username;

    @Size(min = 2, message = "Password should have at least 5 characters")
    private String password;
}
