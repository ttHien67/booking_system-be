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

    @PostMapping(value = "/updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateProduct(@RequestBody ProductRequest request){
        return new ResponseEntity<>(productService.updateProduct(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteProduct(@RequestBody ProductRequest request){
        return new ResponseEntity<>(productService.deleteProduct(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createProduct(@RequestBody ProductRequest request){
        return new ResponseEntity<>(productService.createProduct(request), HttpStatus.OK);
    }
}
