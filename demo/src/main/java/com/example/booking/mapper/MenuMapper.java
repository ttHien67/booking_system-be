package com.example.booking.mapper;

import com.example.booking.model.request.MenuRequest;
import com.example.booking.model.response.MenuResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuMapper {

	int create(MenuRequest request);
	
	int update(MenuRequest request);

	List<MenuResponse> get(MenuRequest request);

	List<MenuResponse> getAll();

	int countByCondition(MenuRequest request);
	
	List<MenuResponse> findAllMenu();
	
	List<MenuResponse> findAllMenuChild();
	
	List<MenuResponse> findParentMenu(List<String> listRoles);
	
	List<MenuResponse> findMenuByParentId(String parentId, List<String> listRoles);
	
	String fetchRoleByUserId(String userId);
	
}
