package com.github.dto;

import java.io.Serializable;

/**
 * Created by chenqimiao on 2017/5/2.
 */
public class BootDto implements Serializable{
    private Boolean isSuccess;
    private Object Data;
    private String msg;

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
