package com.example.booking.controller;

import com.example.booking.model.request.BookingInfoRequest;
import com.example.booking.model.request.CustomerRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.service.IBookingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookingInfo")
public class BookingInfoController {

    @Autowired
    private IBookingInfoService bookingService;

    @PostMapping(value = "/createBooking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createBooking(@RequestBody BookingInfoRequest request){
        return new ResponseEntity<>(bookingService.createBooking(request), HttpStatus.OK);
    }

    @PostMapping(value = "/getBooking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getBooking(@RequestBody BookingInfoRequest request){
        return new ResponseEntity<>(bookingService.getBooking(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateBooking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateBooking(@RequestBody BookingInfoRequest request){
        return new ResponseEntity<>(bookingService.updateBooking(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteBooking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteBooking(@RequestBody BookingInfoRequest request){
        return new ResponseEntity<>(bookingService.deleteBooking(request), HttpStatus.OK);
    }

    @PostMapping(value = "/statisticBooking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> statisticBooking(@RequestBody BookingInfoRequest request){
        return new ResponseEntity<>(bookingService.statisticBooking(request), HttpStatus.OK);
    }


}
