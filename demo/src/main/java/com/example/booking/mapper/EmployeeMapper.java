package com.example.booking.mapper;

import com.example.booking.model.request.BookingInfoRequest;
import com.example.booking.model.request.CustomerRequest;
import com.example.booking.model.request.EmployeeRequest;
import com.example.booking.model.response.CustomerResponse;
import com.example.booking.model.response.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeMapper {

    public EmployeeResponse create(EmployeeRequest request);

    public List<EmployeeResponse> get(EmployeeRequest request);

    public List<EmployeeResponse> getAll();

    public int update(EmployeeRequest request);

    public int updateTimeWork(BookingInfoRequest request);

    public int delete(EmployeeRequest request);

    public int countEmployee(EmployeeRequest request);

    public int checkInfo(EmployeeRequest request);
}
