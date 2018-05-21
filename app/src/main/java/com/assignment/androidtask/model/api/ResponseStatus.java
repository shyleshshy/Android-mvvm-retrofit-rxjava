package com.assignment.androidtask.model.api;

public class ResponseStatus {
    /**
     * code : 207
     * message : Password Mismatch!
     */

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
