package com.example.booking.service.impl;

import com.example.booking.mapper.UserMapper;
import com.example.booking.model.request.UserRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.model.response.UserResponse;
import com.example.booking.service.IUserService;
import com.google.common.base.Strings;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    public BaseResponse createUser(UserRequest request) {
        try{
            if (request == null || Strings.isNullOrEmpty(request.getName())
                    || Strings.isNullOrEmpty(request.getUserName()) || Strings.isNullOrEmpty(request.getEmail())
                    || Strings.isNullOrEmpty(request.getPassword())) {
                return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                        "Fiels is requried");
            }

            UserResponse checkEmailExistion = mapper.checkEmailExistion(request.getEmail());
            if(checkEmailExistion != null) {
                return new BaseResponse("1", "Email already in use");
            }

            UserResponse checkUsernameExistion = mapper.checkUsernameExistion(request.getUserName());
            if(checkUsernameExistion != null) {
                return new BaseResponse("1", "Username already in use");
            }

            String hashedPassword = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(10));
            request.setPassword(hashedPassword);

            UserResponse result = mapper.create(request);
            if(result != null) {
                return new BaseResponse(result, "0", "Account have been created");
            }else {
                return new BaseResponse("1", "Something is false");
            }
        }catch (Exception e){
            return new BaseResponse("1", "Failure");
        }
    }

    public UserResponse validateUser(String userName, String password) throws AuthException {
        try{
            UserResponse user = mapper.finAccountByUsername(userName);

            if(user == null || !BCrypt.checkpw(password, user.getPassword())) {
                return null;
            }
            user.setPassword(null);
            return user;

        }catch (EmptyResultDataAccessException e){
            throw new AuthException("Invalid username/password");
        }
    }
}
