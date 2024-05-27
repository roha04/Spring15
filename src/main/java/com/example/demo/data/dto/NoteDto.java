package com.example.demo.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {
    private int id;
    private String title;
    private String content;
    public NoteDto(String title, String content) {
        super();
        this.title = title;
        this.content = content;
    }
    public String getIdToString() {
        return String.valueOf(this.id);
    }

    @Override
    public String toString() {
        return "NoteDto { "+"id="+id+", title='"+title+", content='"+content+" }";
    }
}
