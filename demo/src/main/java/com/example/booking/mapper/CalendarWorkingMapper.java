package com.example.booking.mapper;

import com.example.booking.model.request.CalendarWorkingRequest;
import com.example.booking.model.response.CalendarWorkingResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalendarWorkingMapper {
    public CalendarWorkingResponse create(CalendarWorkingRequest request);

    public List<CalendarWorkingResponse> get(CalendarWorkingRequest request);

    public List<CalendarWorkingResponse> countService(CalendarWorkingRequest request);
}
