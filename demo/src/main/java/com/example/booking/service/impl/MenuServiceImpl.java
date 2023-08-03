package com.example.booking.service.impl;

import com.example.booking.model.request.PermissionRequest;
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
	public BaseResponse create(MenuRequest request) {
		BaseResponse response = new BaseResponse();
		try {
			int created = mapper.create(request);
			if (created > 0) {
				response.setErrorCode("0");
				response.setErrorDesc("Create Successfully");
			} else {
				response.setErrorCode("1");
				response.setErrorDesc("Create failure");
			}
		} catch (Exception e) {
			response.setErrorCode("-1");
			response.setErrorDesc("fail");
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
	public BaseResponse getMenuForCategory(List<PermissionRequest> request) throws IOException {
		try{
			List<MenuResponse> result = new ArrayList<>();

			for(PermissionRequest item: request){
				result.add(mapper.getForCategory(item));
			}
			if(result.size() > 0){
				return new BaseResponse(result, "0", "success");
			}else {
				return new BaseResponse("1", "fail");
			}

		}catch (Exception e) {
			return new BaseResponse("-1", "fail");
		}
	}

	@Override
	public BaseResponse getParentMenu(MenuRequest request) throws IOException {
		try{
			List<MenuResponse> result = mapper.getParentMenu(request);

			if(result.size() > 0){
				return new BaseResponse(result, "0", "get successfully");
			}else {
				return new BaseResponse("1", "get failure");
			}
		}catch (Exception e){
			return new BaseResponse("-1", "Fail");
		}

	}

	@Override
	public BaseResponse update(MenuRequest request) throws IOException {
		BaseResponse response = new BaseResponse();
		try {
			int updated = mapper.update(request);
			if (updated > 0) {
				response.setErrorCode("0");
				response.setErrorDesc("Update Successfully");
			} else {
				response.setErrorCode("1");
				response.setErrorDesc("Update failure");
			}
		} catch (Exception e) {
			response.setErrorCode("-1");
			response.setErrorDesc("fail");
		}
		return response;
	}

	@Override
	public BaseResponse findAllMenu(MenuRequest request) throws IOException {
		try{
			List<MenuResponse> result = mapper.findAllMenu(request);
			int count = mapper.countMenu(request);

			return new BaseResponse(result, count, "0", "success");
		}catch (Exception e){
			return new BaseResponse(e);
		}
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
