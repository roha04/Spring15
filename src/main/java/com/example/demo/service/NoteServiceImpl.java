package com.example.demo.service;

import com.example.demo.data.dto.NoteDto;
import com.example.demo.data.entity.NoteEntity;
import com.example.demo.data.repository.NoteListRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteListRepository noteListRepository;
    @Autowired
    private NoteConvertor noteConvertor;
    @Override
    public List<NoteDto> listAll() {
        return noteConvertor.entitiesToDtos(noteListRepository.listAllNotes());
    }
    @Override
    public NoteDto add(NoteDto note) {
        NoteEntity entity = noteConvertor.dtoToEntity(note);
        entity.setId(0);
        return noteConvertor.entityToDto(noteListRepository.addNote(entity));
    }
    @Override
    public void deleteById(Long id) {
        noteListRepository.removeNoteById(id);
    }
    @Override
    public void deleteLast() {
        noteListRepository.remoteLastNote();
    }
    @Override
    public void update(NoteDto note) {
        noteListRepository.updateNote(note);
    }
    @Override
    public NoteDto getById(Long id) {
        return noteConvertor.entityToDto(noteListRepository.getNoteById(id));
    }
    @PostConstruct
    public void init() {
        NoteDto note = new NoteDto();
        for (int i=1; i<4; i++) {
            note = new NoteDto("Title note " + i, "Content note " + i);
            note = add(note);
        }
        note.setTitle("updated title note 3");
        update(note);
        listAll().forEach(NoteDto::toString);
    }

}
