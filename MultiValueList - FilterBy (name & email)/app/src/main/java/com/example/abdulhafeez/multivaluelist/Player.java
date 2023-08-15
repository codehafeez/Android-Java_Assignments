package com.example.abdulhafeez.multivaluelist;
public class Player {

    private String name;
    private String email;
    private int img;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getImg() { return img; }
    public void setImg(int img) { this.img = img; }

    public Player(String name, String email, int img){
        this.name = name;
        this.img = img;
        this.email = email;
    }
}
