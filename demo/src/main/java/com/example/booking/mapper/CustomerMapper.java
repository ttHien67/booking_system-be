package com.example.booking.mapper;

import com.example.booking.model.request.BookingInfoRequest;
import com.example.booking.model.request.CustomerRequest;
import com.example.booking.model.response.BookingInfoResponse;
import com.example.booking.model.response.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerMapper {

    public CustomerResponse create(BookingInfoRequest request);

    public int updateVip(String code);

    public List<CustomerResponse> get(CustomerRequest request);

    public CustomerResponse getByCode(String code);

    public int update(CustomerRequest request);

    public int delete(CustomerRequest request);

    public int countCustomer(CustomerRequest request);

    public CustomerResponse checkInfo(BookingInfoRequest request);


}
