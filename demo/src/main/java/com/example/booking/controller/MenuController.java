package com.example.booking.controller;

import com.example.booking.model.request.MenuRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.service.IMenuService;
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
@RequestMapping(value = "/menu")
public class MenuController {
	@Autowired
    private IMenuService menuService;


    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> create(@RequestBody MenuRequest request) throws IOException {
        return new ResponseEntity<>(menuService.create(request), HttpStatus.OK);
    }
    
    @PostMapping(value = "/getMenu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getMenu(@RequestBody MenuRequest request) throws IOException {
        return new ResponseEntity<>(menuService.getMenu(request), HttpStatus.OK);
    }
    
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> update(@RequestBody MenuRequest request) throws IOException {
        return new ResponseEntity<>(menuService.update(request), HttpStatus.OK);
    }
    
    @PostMapping(value = "/findAllMenu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> findAllMenu() throws IOException {
        return new ResponseEntity<>(menuService.findAllMenu(), HttpStatus.OK);
    }
    
    @PostMapping(value = "/findAllMenuChild", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> findAllMenuChild() throws IOException {
        return new ResponseEntity<>(menuService.findAllMenuChild(), HttpStatus.OK);
    }
    
//    @PostMapping(value = "/findMenuByUserId", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<BaseResponse> findMenuByUserId(@RequestBody CommonRequest request) throws IOException {
//        return new ResponseEntity<>(menuService.findMenuByUserId(request.getUserId()), HttpStatus.OK);
//    }
}
