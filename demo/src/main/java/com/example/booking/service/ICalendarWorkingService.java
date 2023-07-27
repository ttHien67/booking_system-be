package com.example.booking.service;

import com.example.booking.model.request.BookingInfoRequest;
import com.example.booking.model.request.CalendarWorkingRequest;
import com.example.booking.model.response.BaseResponse;

public interface ICalendarWorkingService {

    public BaseResponse createCalendar(CalendarWorkingRequest request);

    public BaseResponse getCalendar(CalendarWorkingRequest request);

    public BaseResponse countService(CalendarWorkingRequest request);


//    public BaseResponse updateCalendar(CalendarWorkingRequest request);
}
