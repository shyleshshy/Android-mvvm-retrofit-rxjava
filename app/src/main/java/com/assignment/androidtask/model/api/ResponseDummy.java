package com.assignment.androidtask.model.api;

public class ResponseDummy {

    /**
     * postId : 1
     * id : 1
     * name : id labore ex et quam laborum
     * email : Eliseo@gardner.biz
     * body : laudantium enim quasi est quidem magnam voluptate ipsam eos
     tempora quo necessitatibus
     dolor quam autem quasi
     reiciendis et nam sapiente accusantium
     */

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public ResponseDummy() {
    }

    public ResponseDummy(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
