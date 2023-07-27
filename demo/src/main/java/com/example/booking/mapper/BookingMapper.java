package com.example.booking.mapper;

import com.example.booking.model.request.BookingInfoRequest;
import com.example.booking.model.request.CustomerRequest;
import com.example.booking.model.response.BookingInfoResponse;
import com.example.booking.model.response.CustomerResponse;
import com.example.booking.model.response.EmployeeResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingMapper {

    public BookingInfoResponse create(BookingInfoRequest request);

    public List<BookingInfoResponse> get(BookingInfoRequest request);

    public List<BookingInfoResponse> getByEmployee(BookingInfoRequest request);

    public int update(BookingInfoRequest request);

    public int delete(BookingInfoRequest request);

    public int countBooking(BookingInfoRequest request);

    public int checkPriority(BookingInfoRequest request);

    public EmployeeResponse statistic(@Param("id") String id, @Param("date")String date,
                                      @Param("month")String month, @Param("year")String year);

}
