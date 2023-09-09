package com.tkg.MasterSystem.payload.requests.authentication;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;



public class SendSignInCodeRequest {
//    @NotEmpty(message = )
    @NotEmpty(message = "{email.notEmpty}")
    @NotBlank(message = "{email.notEmpty}")
    @Email(message = "{email.format}")
    private String email;

    @NotEmpty(message = "{password.notEmpty}")
    @NotBlank(message = "{password.notEmpty}")
    @Length(message = "{password.min}" , min = 8)
    private String password;


    public SendSignInCodeRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
