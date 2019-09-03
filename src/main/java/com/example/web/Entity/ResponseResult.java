package com.example.web.Entity;

import java.io.Serializable;

/**
 * 用于向客户端发送响应结果
 * @param <T> 操作结果中包含数据类型
 */
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -4250418147973163997L;
    private Integer state;
    private String massage;
    private T data;


    public ResponseResult(){
        super();
    }

    public ResponseResult(Integer state){
        super();
        this.state=state;
    }
    public ResponseResult(Integer state, T data){
        super();
        this.state = state;
        this.data = data;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
