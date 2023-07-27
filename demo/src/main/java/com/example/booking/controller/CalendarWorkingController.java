package com.example.booking.controller;

import com.example.booking.model.request.BookingInfoRequest;
import com.example.booking.model.request.CalendarWorkingRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.service.IBookingInfoService;
import com.example.booking.service.ICalendarWorkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/calendarWorking")
public class CalendarWorkingController {

    @Autowired
    private ICalendarWorkingService calendarWorkingService;

    @PostMapping(value = "/createCalendar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createCalendar(@RequestBody CalendarWorkingRequest request){
        return new ResponseEntity<>(calendarWorkingService.createCalendar(request), HttpStatus.OK);
    }

    @PostMapping(value = "/getCalendar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getCalendar(@RequestBody CalendarWorkingRequest request){
        return new ResponseEntity<>(calendarWorkingService.getCalendar(request), HttpStatus.OK);
    }

    @PostMapping(value = "/countService", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> countService(@RequestBody CalendarWorkingRequest request){
        return new ResponseEntity<>(calendarWorkingService.countService(request), HttpStatus.OK);
    }

//    @PostMapping(value = "/updateCalendar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<BaseResponse> updateCalendar(@RequestBody BookingInfoRequest request){
//        return new ResponseEntity<>(calendarWorkingService.updateCalendar(request), HttpStatus.OK);
//    }
}
