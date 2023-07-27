package com.example.booking.service.impl;

import com.example.booking.service.IMenuService;
import com.example.booking.mapper.MenuMapper;
import com.example.booking.model.request.MenuRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.model.response.MenuResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private MenuMapper mapper;

	@Override
	public BaseResponse create(MenuRequest request) throws IOException {
		BaseResponse response = new BaseResponse();
		if(request == null) {
			response.setErrorCode("400");
			response.setErrorDesc("Bad request");
			return response;
		}
		if(request.getName() == null || request.getPath() == null) {
			response.setErrorCode("400");
			response.setErrorDesc("Bad request because missing name or path");
			return response;
		}
		try {
			int created = mapper.create(request);
			if (created > 0) {
				response.setErrorCode("0");
				response.setErrorDesc("Tạo menu thành công");
			} else {
				response.setErrorCode("1");
				response.setErrorDesc("Tạo menu thất bại");
			}
		} catch (Exception e) {
			response.setErrorCode("1");
			response.setErrorDesc("Tạo menu thất bại");
		}
		
		return response;
	}

	@Override
	public BaseResponse getMenu(MenuRequest request) throws IOException {
		BaseResponse response = new BaseResponse();
		List<MenuResponse> result = new ArrayList<>();

		result = mapper.get(request);

		if(result.size() > 0){
			return new BaseResponse(result, "0", "get successfully");
		}
		return response;
	}

	@Override
	public BaseResponse update(MenuRequest request) throws IOException {
		BaseResponse response = new BaseResponse();
		if(request == null) {
			response.setErrorCode("400");
			response.setErrorDesc("Bad request");
			return response;
		}
		if(request.getName() == null || request.getPath() == null || request.getId() == null) {
			response.setErrorCode("400");
			response.setErrorDesc("Bad request because missing name or path");
			return response;
		}
		
		try {
			int updated = mapper.update(request);
			if (updated > 0) {
				response.setErrorCode("0");
				response.setErrorDesc("Cập nhật menu thành công");
			} else {
				response.setErrorCode("1");
				response.setErrorDesc("Cập nhật menu thất bại");
			}
		} catch (Exception e) {
			response.setErrorCode("1");
			response.setErrorDesc("Cập nhật menu thất bại");
		}
		return response;
	}

	@Override
	public BaseResponse findAllMenu() throws IOException {
		BaseResponse response = new BaseResponse();
		response.setErrorCode("0");
		response.setData(mapper.findAllMenu());
		return response;
	}

	@Override
	public BaseResponse findMenuByUserId(String userId) {
		BaseResponse response = new BaseResponse();
		String roleCodes = mapper.fetchRoleByUserId(userId);
		if(roleCodes != null) {
			String[] listRole = roleCodes.split(",");
			List<String> listRoles = Arrays.asList(listRole);
			List<MenuResponse> listParentMenu = mapper.findParentMenu(listRoles);
			for(MenuResponse item : listParentMenu) {
				item.setMenuChilds(mapper.findMenuByParentId(item.getId(), listRoles));
			}
			response.setData(listParentMenu);
			response.setErrorCode("0");
		}
		return response;
	}

	@Override
	public BaseResponse findAllMenuChild() throws IOException {
		BaseResponse response = new BaseResponse();
		response.setErrorCode("0");
		response.setData(mapper.findAllMenuChild());
		return response;
	}

}
