package com.example.booking.service;

import com.example.booking.model.request.MenuRequest;
import com.example.booking.model.response.BaseResponse;

import java.io.IOException;

public interface IMenuService {

	 BaseResponse create(MenuRequest request) throws IOException;
	 
	 BaseResponse update(MenuRequest request) throws IOException;
	 
	 BaseResponse getMenu(MenuRequest request) throws IOException;
	 
	 BaseResponse findAllMenu() throws IOException;
	 
	 BaseResponse findAllMenuChild() throws IOException;
	 
	 BaseResponse findMenuByUserId(String userId);
	 
}
