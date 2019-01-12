package com.web.service;

import com.web.domain.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {
    Long create (Note note);
    Note getNote (Long id);
    void update (Note note);
    void delete (Note note);
    List<Note> findAllNotes();
    List<Note> findByDoctor();
    List<Note> findAllNotes();
    List<Note> findAllNotes();

}
