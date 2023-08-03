package com.example.booking.service;

import com.example.booking.model.request.MenuRequest;
import com.example.booking.model.request.PermissionRequest;
import com.example.booking.model.response.BaseResponse;

import java.io.IOException;
import java.util.List;

public interface IMenuService {

	 BaseResponse create(MenuRequest request);
	 
	 BaseResponse update(MenuRequest request) throws IOException;
	 
	 BaseResponse getMenu(MenuRequest request) throws IOException;

	 BaseResponse getMenuForCategory(List<PermissionRequest> request) throws IOException;

	 BaseResponse getParentMenu(MenuRequest request) throws IOException;

	 BaseResponse findAllMenu(MenuRequest request) throws IOException;
	 
	 BaseResponse findAllMenuChild() throws IOException;
	 
	 BaseResponse findMenuByUserId(String userId);
	 
}
