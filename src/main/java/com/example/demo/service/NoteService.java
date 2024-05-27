package com.example.demo.service;

import com.example.demo.data.dto.NoteDto;

import java.util.List;

public interface NoteService {
    List<NoteDto> listAll();
    NoteDto add(NoteDto note);
    void deleteById(Long id);
    void deleteLast();
    void update(NoteDto note);
    NoteDto getById(Long id);
}
