package com.example.booking.service;

import com.example.booking.model.request.CustomerRequest;
import com.example.booking.model.request.EmployeeRequest;
import com.example.booking.model.response.BaseResponse;

public interface IEmployeeService {

    public BaseResponse getEmployee(EmployeeRequest request);

    public BaseResponse updateEmployee(EmployeeRequest request);

    public BaseResponse deleteEmployee(EmployeeRequest request);

    public BaseResponse createEmployee(EmployeeRequest request);


}
