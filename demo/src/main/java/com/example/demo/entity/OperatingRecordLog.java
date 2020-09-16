package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * operating_record_log
 * @author 
 */
public class OperatingRecordLog implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 请求token
     */
    private String token;

    /**
     * 用户id
     */
    private Integer memberId;

    /**
     * 接口路径
     */
    private String apiUri;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求类型
     */
    private String requestType;

    /**
     * 请求ip地址
     */
    private String ipAddress;

    /**
     * 耗时(毫秒)
     */
    private Long timeConsuming;

    /**
     * 平台响应状态码
     */
    private Integer responseCode;

    /**
     * 平台响应状态说明
     */
    private String responseMessage;

    /**
     * Http响应状态
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getApiUri() {
        return apiUri;
    }

    public void setApiUri(String apiUri) {
        this.apiUri = apiUri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Long getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(Long timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}