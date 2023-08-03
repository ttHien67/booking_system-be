package com.example.booking.service;

import com.example.booking.model.request.PermissionRequest;
import com.example.booking.model.response.BaseResponse;

public interface IPermissionService {

    BaseResponse createPermission(PermissionRequest request);

    BaseResponse getPermission(PermissionRequest request);
}
