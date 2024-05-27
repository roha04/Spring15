package com.example.demo.controllers;

import com.example.demo.data.dto.NoteDto;
import com.example.demo.service.NoteConvertor;
import com.example.demo.service.NoteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Validated
@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired private NoteService noteService;
    @Autowired private NoteConvertor noteConvertor;
    @GetMapping(value = "/list")
    public ModelAndView noteList() {
        ModelAndView result = new ModelAndView("notes/listNotes");
        result.addObject("notes", noteConvertor.dtosToResponses(noteService.listAll()));
        return result;
    }
    @PostMapping(value = "/create")
    public ModelAndView createNote(
            @RequestParam(value="title") /** @Size(min = 1, max = 250) */ String title,
            @RequestParam(value="content") /** @NotBlank */ String content) {
        NoteDto dto = new NoteDto();
        dto.setTitle(title);
        dto.setContent(content);
        noteService.add(dto);
        return noteList();
    }
    @PostMapping(value = "/delete")
    public ModelAndView deleteNoteById(@Valid @NotNull @RequestParam(value="id") long id) {
        noteService.deleteById(id);
        return noteList();
    }
    @GetMapping(value = "/edit")
    public ModelAndView getNoteForEdit(@NotNull @RequestParam(value="id") long id) {
        ModelAndView result = new ModelAndView("notes/editNote");
        result.addObject("note", noteConvertor.dtoToResponse(noteService.getById(id)));
        return result;
    }
    @PostMapping(value = "/update")
    public ModelAndView updateNote(
            @NotNull @RequestParam(value="id") int id,
            /** @Size(min = 1, max = 250) */ @RequestParam(value="title") String title,
            @NotEmpty @RequestParam(value="content") String content) {
        NoteDto dto = new NoteDto();
        dto.setId(id);
        dto.setTitle(title);
        dto.setContent(content);
        noteService.update(dto);
        return noteList();
    }
}
