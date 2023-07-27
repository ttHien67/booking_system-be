package com.example.booking.mapper;

import com.example.booking.model.request.BookingInfoRequest;
import com.example.booking.model.request.EmployeeRequest;
import com.example.booking.model.request.ProductRequest;
import com.example.booking.model.response.EmployeeResponse;
import com.example.booking.model.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductMapper {

    List<ProductResponse> get(ProductRequest request);

    public ProductResponse create(ProductRequest request);

    public int update(ProductRequest request);

    public int delete(ProductRequest request);
}
