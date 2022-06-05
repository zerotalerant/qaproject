package org.example.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.model.UserAuthModel;
import org.example.model.UserModel;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    @Autowired
    final UserService userService;

    @PostMapping(path = "/sign-up")
    public UserModel register ( @RequestBody UserModel userModel )
    {
        return userService.createUser ( userModel );
    }

    @PostMapping(path = "/sign-in")
    public String getAuthToken ( @Valid @RequestBody UserAuthModel userAuthDto )
    {
        return userService.getToken ( userAuthDto );
    }

    @GetMapping(path = "/get/all-users")
    public List<UserModel> getAllUsers ()
    {
        return userService.getAllUsers ();
    }

    @GetMapping(path = "/get/{userId}")
    public UserModel getUserById ( @PathVariable("userId") Long userId )
    {
        return userService.getUserById ( userId );
    }
}
