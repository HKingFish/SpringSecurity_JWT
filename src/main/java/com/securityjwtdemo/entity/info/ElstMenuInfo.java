package com.securityjwtdemo.entity.info;

import com.securityjwtdemo.entity.ElstRole;

import java.util.List;

/**
 * @Author : KingFish
 * @Email : XXXXXX
 * @Data: 2019/10/31
 * @Des:
 */
public class ElstMenuInfo {
    private Integer id;
    private String menuId;
    private String menuName;
    private String menuUrl;
    private String menuPath;
    private String parentId;
    private Short menuEnabled;
    private List<ElstRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Short getMenuEnabled() {
        return menuEnabled;
    }

    public void setMenuEnabled(Short menuEnabled) {
        this.menuEnabled = menuEnabled;
    }

    public List<ElstRole> getRoles() {
        return roles;
    }

    public void setRoles(List<ElstRole> roles) {
        this.roles = roles;
    }
}