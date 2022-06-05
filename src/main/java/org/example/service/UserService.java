package org.example.service;


import org.example.model.UserAuthModel;
import org.example.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel createUser ( UserModel userModel );

    Boolean deleteUserById ( Long userId );

    UserModel getUserById ( Long userId );

    String getToken ( UserAuthModel userAuthDto );

    List<UserModel> getAllUsers ();

    Boolean updateUser ( UserModel userModel );
}