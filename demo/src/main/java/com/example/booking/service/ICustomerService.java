package com.example.booking.service;

import com.example.booking.model.request.BookingInfoRequest;
import com.example.booking.model.request.CustomerRequest;
import com.example.booking.model.response.BaseResponse;

public interface ICustomerService {

    public BaseResponse getCustomer(CustomerRequest request);

    public BaseResponse updateCustomer(CustomerRequest request);

    public BaseResponse deleteCustomer(CustomerRequest request);


}
