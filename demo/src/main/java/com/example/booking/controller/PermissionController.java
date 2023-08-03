package com.example.booking.controller;

import com.example.booking.model.request.MenuRequest;
import com.example.booking.model.request.PermissionRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @PostMapping(value = "/createPermission", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createPermission(@RequestBody PermissionRequest request) throws IOException {
        return new ResponseEntity<>(permissionService.createPermission(request), HttpStatus.OK);
    }

    @PostMapping(value = "/getPermission", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getPermission(@RequestBody PermissionRequest request) throws IOException {
        return new ResponseEntity<>(permissionService.getPermission(request), HttpStatus.OK);
    }
}
