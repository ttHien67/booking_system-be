package com.example.booking.service.impl;

import com.example.booking.mapper.CalendarWorkingMapper;
import com.example.booking.model.request.CalendarWorkingRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.model.response.CalendarWorkingResponse;
import com.example.booking.service.ICalendarWorkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarWorkingServiceImpl implements ICalendarWorkingService {

    @Autowired
    private CalendarWorkingMapper mapper;

    public BaseResponse createCalendar(CalendarWorkingRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{

            CalendarWorkingResponse result = mapper.create(request);

            if(result != null) {
                baseResponse = new BaseResponse(request, "0", "Create Successsfully");
            }else {
                baseResponse = new BaseResponse("1", "Create failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse getCalendar(CalendarWorkingRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            List<CalendarWorkingResponse> result = mapper.get(request);

            if(result.size() >= 0) {
                baseResponse = new BaseResponse(result, "0", "Get Successsfully");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse countService(CalendarWorkingRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{

            List<CalendarWorkingResponse> result = mapper.countService(request);

            if(result.size() >= 0) {
                baseResponse = new BaseResponse(result, "0", "Get Successsfully");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

//    public BaseResponse updateCalendar(CalendarWorkingRequest request) {
//        BaseResponse baseResponse = new BaseResponse();
//        try{
//            int result = mapper.update(request);
//
//            if(result > 0) {
//                baseResponse = new BaseResponse(request, "0", "Update Successsfully");
//            }else {
//                baseResponse = new BaseResponse("1", "Update failure");
//            }
//
//        }catch (Exception e){
//            baseResponse = new BaseResponse("1", "Failed");
//            return baseResponse;
//        }
//        return baseResponse;
//    }
}
