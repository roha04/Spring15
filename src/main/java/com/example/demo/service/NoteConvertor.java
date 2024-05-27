package com.example.demo.service;

import com.example.demo.controllers.response.NoteResponse;
import com.example.demo.data.dto.NoteDto;
import com.example.demo.data.entity.NoteEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class NoteConvertor {
    public NoteEntity dtoToEntity(NoteDto noteDto) {
        NoteEntity entity = new NoteEntity();
        entity.setId(noteDto.getId());
        entity.setTitle(noteDto.getTitle());
        entity.setContent(noteDto.getContent());
        return entity;
    }
    public List<NoteEntity> dtoToEntities(Collection<NoteDto> notes) {
        return notes.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());
    }
    public NoteDto entityToDto(NoteEntity entity) {
        NoteDto dto = new NoteDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        return dto;
    }
    public List<NoteDto> entitiesToDtos(Collection<NoteEntity> entities) {
        return entities.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
    public NoteResponse dtoToResponse(NoteDto dto) {
        NoteResponse response = new NoteResponse();
        response.setId(dto.getId());
        response.setTitle(dto.getTitle());
        response.setContent(dto.getContent());
        return response;
    }
    public List<NoteResponse> dtosToResponses(Collection<NoteDto> dtos) {
        return dtos.stream()
                .map(this::dtoToResponse)
                .collect(Collectors.toList());
    }
}
