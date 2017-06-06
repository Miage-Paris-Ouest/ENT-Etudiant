package com.paris10.ent.designPatterns;

/**
 * Created by Numerial on 06/06/2017.
 */
public class ResponseMapper {
    private String status;
    private Object data;

    public ResponseMapper(){

    }
    public ResponseMapper(String status, Object data){
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}