package com.example.booking.service.impl;

import com.example.booking.mapper.BookingMapper;
import com.example.booking.mapper.CustomerMapper;
import com.example.booking.mapper.EmployeeMapper;
import com.example.booking.model.request.BookingInfoRequest;
import com.example.booking.model.request.CustomerRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.model.response.BookingInfoResponse;
import com.example.booking.model.response.CustomerResponse;
import com.example.booking.model.response.EmployeeResponse;
import com.example.booking.service.IBookingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class BookingInfoServiceImpl implements IBookingInfoService {

    @Autowired
    private BookingMapper mapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public BaseResponse createBooking(BookingInfoRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
//            create booking for new customer
//            if(request.getCustomerId() == null){
////                create booking for new customer
//                CustomerResponse checkCustomerInfo = customerMapper.checkInfo(request);
//                if(checkCustomerInfo != null) {
//                    return new BaseResponse("1", "Customer code has been used");
//                }else {
////                    create customer information
//                    CustomerResponse customer = customerMapper.create(request);
////                    update customer priority
//
//                    if(customer == null) {
//                        return new BaseResponse("1", "Create failure");
//                    }
////                    set customer id for booking form
//                    CustomerResponse cusNew = customerMapper.getByCode(customer.getCode());
//                    request.setCustomerId(cusNew.getId());
//                }
//            }
            int checkPriority = mapper.checkPriority(request);
            if(checkPriority > 2){
                request.setPriority(1);
            }
//            create booking form
            BookingInfoResponse result = mapper.create(request);

            if(result != null) {
                return new BaseResponse(result, "0", "Create Successfully");
            }else {
                return new BaseResponse("1", "Create failure");
            }
        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
    }

    public BaseResponse getBooking(BookingInfoRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            List<BookingInfoResponse> result = mapper.get(request);
            int count = mapper.countBooking(request);

            if(result.size() >= 0) {
                baseResponse = new BaseResponse(result, count, "0", "Get Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Get failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse updateBooking(BookingInfoRequest request) {
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

    public BaseResponse deleteBooking(BookingInfoRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int result = mapper.delete(request);

            if(result > 0) {
                baseResponse = new BaseResponse(request, "0", "Delete Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Delete failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse statisticBooking(BookingInfoRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            ArrayList<EmployeeResponse> result = new ArrayList<EmployeeResponse>();
            List<EmployeeResponse> employees = employeeMapper.getAll();

            for(EmployeeResponse item : employees){
                result.add(mapper.statistic(item.getId(), request.getDate(), request.getMonth(), request.getYear()));
            }

            if(result.size() > 0) {
                baseResponse = new BaseResponse(result, "0", "Statistic Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Statistic failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }
}
