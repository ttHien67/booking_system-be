package com.example.booking.model.response;

import java.util.Date;
import java.util.List;

public class MenuResponse {
	
	private String id;
	private String name;
	private String parentId;
	private String path;
	private String creator;
	private String createDate;
	private List<MenuResponse> menuChilds;

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<MenuResponse> getMenuChilds() {
		return menuChilds;
	}
	public void setMenuChilds(List<MenuResponse> menuChilds) {
		this.menuChilds = menuChilds;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
}
