package com.example.booking.mapper;

import com.example.booking.model.request.PermissionRequest;
import com.example.booking.model.response.PermissionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionMapper {
    int create(PermissionRequest request);

    List<PermissionResponse> checkDuplicate(PermissionRequest request);

    List<PermissionResponse> get(PermissionRequest request);
}
