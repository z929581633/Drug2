package com.drug.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class MenuDO implements Serializable{
	/**
	 * 菜单ID
	 */
	private Integer menuId;
	
	/**
	 * 菜单名称
	 */
	private String menuName;
	
	/**
	 * 父级菜单ID
	 */
	private Integer menuParent;
	
	/**
	 * 菜单Icon
	 */
	private String menuIcon;
	
	/**
	 * 菜单类型
	 */
	private Integer menuType;
	
	/**
	 * 菜单URL
	 */
	private String menuURL;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getMenuParent() {
		return menuParent;
	}

	public void setMenuParent(Integer menuParent) {
		this.menuParent = menuParent;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	public String getMenuURL() {
		return menuURL;
	}

	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}
	
}
