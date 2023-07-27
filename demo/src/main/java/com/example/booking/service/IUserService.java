package com.example.booking.service;


import com.example.booking.model.request.UserRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.model.response.UserResponse;

import javax.security.auth.message.AuthException;

public interface IUserService {

    BaseResponse createUser(UserRequest request);

    UserResponse validateUser(String userName, String password) throws AuthException;
}
