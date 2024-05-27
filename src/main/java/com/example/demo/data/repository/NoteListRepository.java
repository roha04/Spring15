package com.example.demo.data.repository;

import com.example.demo.data.dto.NoteDto;
import com.example.demo.data.entity.NoteEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class NoteListRepository {
    private List<NoteEntity> notes = new ArrayList<>();
    public List<NoteEntity> listAllNotes() {
        return this.notes;
    }
    public NoteEntity addNote(NoteEntity note) {
        if (this.notes.isEmpty()) {
            note.setId(1);
            this.notes.add(note);
        } else {
            NoteEntity noteWithMaxId = notes.stream()
                    .max(Comparator.comparing(NoteEntity::getId))
                    .orElseThrow();
            int newNoteId = (noteWithMaxId == null) ? 1 : noteWithMaxId.getId() + 1;
            note.setId(newNoteId);
            this.notes.add(note);
        }
        return note;
    }
    public void updateNote(NoteDto note) {

        NoteEntity temp = getNoteById((long) note.getId());
        if (temp == null) {
            throw new NoSuchElementException("note by id "+note.getId()+" is not present in list notes!!!");
        }
        temp.setTitle(note.getTitle());
        temp.setContent(note.getContent());
    }
    public NoteEntity getNoteById(Long id) {
        NoteEntity note = notes.stream()
                .filter(p -> p.getId()==id)
                .findAny().orElse(null);
        if (note == null) {
            throw new NoSuchElementException("note by id "+id+" is not present!!!");
        }
        return note;
    }
    public void removeNoteById(Long id) {
        this.notes.stream()
                .filter(n -> n.getIdToString().equals(id.toString()))
                .findFirst()
                .ifPresent(this.notes::remove);
    }
    public void remoteLastNote() {
        int id = 0;
        id = this.notes.getLast().getId();
        if (id>0) {
            removeNoteById((long) id);
        }
    }
    public NoteEntity save(NoteEntity note) {
        if (this.notes.isEmpty()) {
            note.setId(1);
            this.notes.add(note);
        } else {
            int id = note.getId();
            Optional<NoteEntity> optionalNote = this.notes.stream()
                    .filter(n -> n.getIdToString().equals(id))
                    .findFirst();
            if (optionalNote.isPresent()) {
                this.notes.remove(optionalNote.get());
                this.notes.add(note);
            }
        }
        return note;
    }
}
