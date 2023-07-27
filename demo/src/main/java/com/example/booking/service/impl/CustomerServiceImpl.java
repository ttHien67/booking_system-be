package com.example.booking.service.impl;

import com.example.booking.mapper.CustomerMapper;
import com.example.booking.model.request.BookingInfoRequest;
import com.example.booking.model.request.CustomerRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.model.response.CustomerResponse;
import com.example.booking.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper mapper;

    public BaseResponse getCustomer(CustomerRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            List<CustomerResponse> result = mapper.get(request);
            int count = mapper.countCustomer(request);

            if(result.size() > 0) {
                baseResponse = new BaseResponse(result, count, "0", "Get Successsfully");
            }else {
                baseResponse = new BaseResponse("1", "Get failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse updateCustomer(CustomerRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int result = mapper.update(request);

            if(result > 0) {
                baseResponse = new BaseResponse(request, "0", "Update Successsfully");
            }else {
                baseResponse = new BaseResponse("1", "Update failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse deleteCustomer(CustomerRequest request) {
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
}
