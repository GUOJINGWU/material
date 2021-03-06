package com.youzhicai.materialstore.web.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class AuthInfo {
    private boolean state;

    private String id;// 用户ID
    private String user_ID;// 企业id
    private String userId;// 登录用户名
    private String userName;
    private String userType;
    private String deviceSeriesNum;
    private String certEndDate;
    private String agencyLoginID;
    private String baseUrl;
    private String userUniqueID;// 不用
    private String lastLoginTime;
    private String lastLoginIP;
    private String isMain;
    private String invalidTime;
    private String sessionKey;
    private String phoneNumber;
    private String telPhone;
    private String subName;
    private String contactUser;
    private String companyAddress;
    private String contactUserPhone;
    private String contactTel;
    private String faxNum;
    private String email;
    private String companyWeb;
    private String randomNum;
    private CookieUsers cookie;
    private HashMap<Integer, HashMap<Integer, ArrayList<String>>> permissions;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDeviceSeriesNum() {
        return deviceSeriesNum;
    }

    public void setDeviceSeriesNum(String deviceSeriesNum) {
        this.deviceSeriesNum = deviceSeriesNum;
    }

    public String getCertEndDate() {
        return certEndDate;
    }

    public void setCertEndDate(String certEndDate) {
        this.certEndDate = certEndDate;
    }

    public String getAgencyLoginID() {
        return agencyLoginID;
    }

    public void setAgencyLoginID(String agencyLoginID) {
        this.agencyLoginID = agencyLoginID;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUserUniqueID() {
        return userUniqueID;
    }

    public void setUserUniqueID(String userUniqueID) {
        this.userUniqueID = userUniqueID;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public String getIsMain() {
        return isMain;
    }

    public void setIsMain(String isMain) {
        this.isMain = isMain;
    }

    public String getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(String invalidTime) {
        this.invalidTime = invalidTime;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getContactUser() {
        return contactUser;
    }

    public void setContactUser(String contactUser) {
        this.contactUser = contactUser;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getContactUserPhone() {
        return contactUserPhone;
    }

    public void setContactUserPhone(String contactUserPhone) {
        this.contactUserPhone = contactUserPhone;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getFaxNum() {
        return faxNum;
    }

    public void setFaxNum(String faxNum) {
        this.faxNum = faxNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyWeb() {
        return companyWeb;
    }

    public void setCompanyWeb(String companyWeb) {
        this.companyWeb = companyWeb;
    }

    public String getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(String randomNum) {
        this.randomNum = randomNum;
    }

    public CookieUsers getCookie() {
        return cookie;
    }

    public void setCookie(CookieUsers cookie) {
        this.cookie = cookie;
    }

    public HashMap<Integer, HashMap<Integer, ArrayList<String>>> getPermissions() {
        return permissions;
    }

    public void setPermissions(HashMap<Integer, HashMap<Integer, ArrayList<String>>> permissions) {
        this.permissions = permissions;
    }

    public AuthInfo() {
        super();
    }

}
