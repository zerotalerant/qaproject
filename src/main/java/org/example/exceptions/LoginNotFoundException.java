package org.example.exceptions;

import org.springframework.http.HttpStatus;

public class LoginNotFoundException extends RuntimeException {
    public LoginNotFoundException ( String message, HttpStatus unauthorized )
    {
        super ( message );
    }
}
