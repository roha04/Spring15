package com.example.demo.data.entity;

import lombok.Data;

@Data
public class NoteEntity {
    private int id;
    private String title;
    private String content;

    public NoteEntity() {
    }
    public NoteEntity(String title, String content) {
        super();
        this.title = title;
        this.content = content;
    }
    public String getIdToString() {
        return String.valueOf(this.id);
    }
}
