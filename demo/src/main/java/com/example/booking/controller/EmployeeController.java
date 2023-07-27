package com.example.booking.controller;

import com.example.booking.model.request.CustomerRequest;
import com.example.booking.model.request.EmployeeRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.service.ICustomerService;
import com.example.booking.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @PostMapping(value = "/getEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getEmployee(@RequestBody EmployeeRequest request){
        return new ResponseEntity<>(employeeService.getEmployee(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateEmployee(@RequestBody EmployeeRequest request){
        return new ResponseEntity<>(employeeService.updateEmployee(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteEmployee(@RequestBody EmployeeRequest request){
        return new ResponseEntity<>(employeeService.deleteEmployee(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createEmployee(@RequestBody EmployeeRequest request){
        return new ResponseEntity<>(employeeService.createEmployee(request), HttpStatus.OK);
    }
}
