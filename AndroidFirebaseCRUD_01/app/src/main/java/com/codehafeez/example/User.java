package com.codehafeez.example;
public class User {

    private String userid;
    private String username;
    private String useremail;

    public User() {}

    public User(String user_id,String username,String useremail) {
        this.userid = user_id;
        this.username = username;
        this.useremail = useremail;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
}