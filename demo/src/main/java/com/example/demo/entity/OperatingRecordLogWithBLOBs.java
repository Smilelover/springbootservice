package com.example.demo.entity;

import java.io.Serializable;

/**
 * operating_record_log
 * @author 
 */
public class OperatingRecordLogWithBLOBs extends OperatingRecordLog implements Serializable {
    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 响应参数
     */
    private String responseParam;

    private static final long serialVersionUID = 1L;

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getResponseParam() {
        return responseParam;
    }

    public void setResponseParam(String responseParam) {
        this.responseParam = responseParam;
    }
}