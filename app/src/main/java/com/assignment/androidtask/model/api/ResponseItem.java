package com.assignment.androidtask.model.api;

import java.util.List;

public class ResponseItem {

    private ResponseStatus status;
    private List<ItemsBean> responseBody;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public List<ItemsBean> getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(List<ItemsBean> responseBody) {
        this.responseBody = responseBody;
    }
}
