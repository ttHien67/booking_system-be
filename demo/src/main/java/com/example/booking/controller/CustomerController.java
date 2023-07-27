package com.example.booking.controller;

import com.example.booking.model.request.BookingInfoRequest;
import com.example.booking.model.request.CustomerRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.service.IBookingInfoService;
import com.example.booking.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping(value = "/getCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getCustomer(@RequestBody CustomerRequest request){
        return new ResponseEntity<>(customerService.getCustomer(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateCustomer(@RequestBody CustomerRequest request){
        return new ResponseEntity<>(customerService.updateCustomer(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteCustomer(@RequestBody CustomerRequest request){
        return new ResponseEntity<>(customerService.deleteCustomer(request), HttpStatus.OK);
    }
}
