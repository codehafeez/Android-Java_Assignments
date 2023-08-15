package com.codehafeez.example;
public class Note {

    private String docId;
    private String title;
    private String description;

    public Note() {}

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}