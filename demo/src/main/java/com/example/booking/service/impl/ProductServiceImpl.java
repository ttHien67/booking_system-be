package com.example.booking.service.impl;

import com.example.booking.mapper.ProductMapper;
import com.example.booking.model.request.EmployeeRequest;
import com.example.booking.model.request.ProductRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.model.response.EmployeeResponse;
import com.example.booking.model.response.ProductResponse;
import com.example.booking.model.response.UserResponse;
import com.example.booking.service.IProductService;
import com.google.common.base.Strings;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper mapper;

    public BaseResponse getProduct(ProductRequest request) {
        try{
            List<ProductResponse> list = mapper.get(request);
            if(list.size() > 0){
                return new BaseResponse(list,"0", "successfully");
            }else {
                return new BaseResponse("1", "fail");
            }
        }catch (Exception e){
            return new BaseResponse("1", "failed");
        }
    }

    public BaseResponse updateProduct(ProductRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int result = mapper.update(request);

            if(result > 0) {
                baseResponse = new BaseResponse(request, "0", "Update Successsfully");
            }else {
                baseResponse = new BaseResponse("1", "Update failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse deleteProduct(ProductRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int result = mapper.delete(request);

            if(result > 0) {
                baseResponse = new BaseResponse(request, "0", "Delete Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Delete failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse createProduct(ProductRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            ProductResponse result = mapper.create(request);

            if(result != null) {
                baseResponse = new BaseResponse(request, "0", "Create Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Create failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }
}
