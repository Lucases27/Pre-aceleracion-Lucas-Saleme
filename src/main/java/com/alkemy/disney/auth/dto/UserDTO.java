package com.alkemy.disney.auth.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
public class UserDTO {
    @Email(message = "Username must be an email")
    private String username;
    @Size(min = 8, max = 20)
    private String password;
}
