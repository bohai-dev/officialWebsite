package com.cfun.website.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ContactUs {
    private Integer id;

    private Integer companyId;

    private String contactUser;

    private String contactPhone;

    private String qqWechat;

    private String contactDeatil;

    private Integer readStatus;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    public ContactUs() {
      this.readStatus=0;
      this.createdTime=new Date();    	
    	
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getContactUser() {
        return contactUser;
    }

    public void setContactUser(String contactUser) {
        this.contactUser = contactUser == null ? null : contactUser.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getQqWechat() {
        return qqWechat;
    }

    public void setQqWechat(String qqWechat) {
        this.qqWechat = qqWechat == null ? null : qqWechat.trim();
    }

    public String getContactDeatil() {
        return contactDeatil;
    }

    public void setContactDeatil(String contactDeatil) {
        this.contactDeatil = contactDeatil == null ? null : contactDeatil.trim();
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}