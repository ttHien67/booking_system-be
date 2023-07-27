package com.example.booking.service;

import com.example.booking.model.request.EmployeeRequest;
import com.example.booking.model.request.ProductRequest;
import com.example.booking.model.response.BaseResponse;

public interface IProductService {

    public BaseResponse getProduct(ProductRequest request);

    public BaseResponse updateProduct(ProductRequest request);

    public BaseResponse deleteProduct(ProductRequest request);

    public BaseResponse createProduct(ProductRequest request);
}
