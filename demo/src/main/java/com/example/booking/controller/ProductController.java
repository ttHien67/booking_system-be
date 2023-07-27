package com.example.booking.controller;

import com.example.booking.model.request.EmployeeRequest;
import com.example.booking.model.request.ProductRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.service.IEmployeeService;
import com.example.booking.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping(value = "/getProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getProduct(@RequestBody ProductRequest request){
        return new ResponseEntity<>(productService.getProduct(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateEmployee(@RequestBody ProductRequest request){
        return new ResponseEntity<>(productService.updateEmployee(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteEmployee(@RequestBody ProductRequest request){
        return new ResponseEntity<>(productService.deleteEmployee(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createEmployee(@RequestBody ProductRequest request){
        return new ResponseEntity<>(productService.createEmployee(request), HttpStatus.OK);
    }
}
