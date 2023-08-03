package com.example.booking.service.impl;

import com.example.booking.mapper.CustomerMapper;
import com.example.booking.mapper.EmployeeMapper;
import com.example.booking.mapper.UserMapper;
import com.example.booking.model.request.CustomerRequest;
import com.example.booking.model.request.EmployeeRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.model.response.CustomerResponse;
import com.example.booking.model.response.EmployeeResponse;
import com.example.booking.model.response.UserResponse;
import com.example.booking.service.IEmployeeService;
import com.google.common.base.Strings;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private UserMapper userMapper;

    public BaseResponse getEmployee(EmployeeRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            List<EmployeeResponse> result = mapper.get(request);
            int count = mapper.countEmployee(request);

            if(result.size() >= 0) {
                baseResponse = new BaseResponse(result, count, "0", "Get Successfully");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse getAllEmployee(EmployeeRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            List<EmployeeResponse> result = mapper.getAll();

            if(result.size() > 0) {
                baseResponse = new BaseResponse(result, "0", "Get Successfully");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse updateEmployee(EmployeeRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int result = mapper.update(request);

            if(result > 0) {
                baseResponse = new BaseResponse(request, "0", "Update Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Update failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse deleteEmployee(EmployeeRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int result = mapper.delete(request);

            if(result > 0) {
                baseResponse = new BaseResponse(request, "0", "Delete Successsfully");
            }else {
                baseResponse = new BaseResponse("1", "Delete failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse createEmployee(EmployeeRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int checkEmployeeCode = mapper.checkInfo(request);

            if(checkEmployeeCode > 0) {
                return new BaseResponse("1", "Employee code has be use");
            }

//            create account
            if (request == null || Strings.isNullOrEmpty(request.getName())
                    || Strings.isNullOrEmpty(request.getUserName()) || Strings.isNullOrEmpty(request.getEmail())
                    || Strings.isNullOrEmpty(request.getPassword())) {
                return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                        "Fiels is requried");
            }

            UserResponse checkEmailExistion = userMapper.checkEmailExistion(request.getEmail());
            if(checkEmailExistion != null) {
                return new BaseResponse("1", "Email already in use");
            }

            UserResponse checkUsernameExistion = userMapper.checkUsernameExistion(request.getUserName());
            if(checkUsernameExistion != null) {
                return new BaseResponse("1", "Username already in use");
            }

            String hashedPassword = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(10));
            request.setPassword(hashedPassword);

            UserResponse account = userMapper.createEmployeeAccount(request);

            if(account != null) {
                request.setAccountId(account.getId());
            }else {
                return new BaseResponse("1", "Create failed");
            }

            EmployeeResponse result = mapper.create(request);

            if(result != null) {
                baseResponse = new BaseResponse(request, "0", "Create Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Create failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }
}
