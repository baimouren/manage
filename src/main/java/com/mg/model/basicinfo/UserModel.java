package com.mg.model.basicinfo;

import java.io.Serializable;
import java.util.Date;

public class UserModel implements Serializable{
	
	private static final long serialVersionUID = -6354205091038256671L;
	
    private Integer rowId;
	private String loginName;
	private String password;
	private String userName;
	private String phone;
	private String address;
    private Date createTime;

    public Integer getRowId() {
        return rowId;
	}

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
	
}
