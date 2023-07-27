package com.example.booking.mapper;


import com.example.booking.model.request.EmployeeRequest;
import com.example.booking.model.request.UserRequest;
import com.example.booking.model.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper {

    UserResponse checkEmailExistion(String email);

    UserResponse create(UserRequest request);

    UserResponse createEmployeeAccount(EmployeeRequest request);

    UserResponse finAccountByUsername(String userName);

    UserResponse checkUsernameExistion(String userName);
}
