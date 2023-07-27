package com.example.booking.service;

import com.example.booking.model.request.BookingInfoRequest;
import com.example.booking.model.request.CustomerRequest;
import com.example.booking.model.response.BaseResponse;

public interface IBookingInfoService {

    public BaseResponse createBooking(BookingInfoRequest request);

    public BaseResponse getBooking(BookingInfoRequest request);

    public BaseResponse updateBooking(BookingInfoRequest request);

    public BaseResponse deleteBooking(BookingInfoRequest request);

    public BaseResponse statisticBooking(BookingInfoRequest request);
}
